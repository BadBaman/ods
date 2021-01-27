package cn.stylefeng.guns.activiti.modular.service.impl;

import cn.stylefeng.guns.activiti.modular.mapper.WorkFlowMapper;
import cn.stylefeng.guns.activiti.modular.service.OdsCounterSignService;
import cn.stylefeng.guns.activiti.modular.service.WorkFlowService;
import cn.stylefeng.guns.onlineaccess.modular.entity.Application;
import cn.stylefeng.guns.onlineaccess.modular.entity.ProjectUser;
import cn.stylefeng.guns.onlineaccess.modular.entity.WorkFlowR;
import cn.stylefeng.guns.onlineaccess.modular.result.ApplicationResult;
import cn.stylefeng.guns.onlineaccess.modular.service.ApplicationService;
import cn.stylefeng.guns.onlineaccess.modular.service.impl.ProjectServiceImpl;
import cn.stylefeng.guns.onlineaccess.modular.service.impl.ProjectUserServiceImpl;
import com.google.common.collect.Maps;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.TaskEntityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OdsCounterSignServiceImpl implements OdsCounterSignService {


    @Autowired
    ProjectServiceImpl projectService;

    @Autowired
    ProjectUserServiceImpl projectUserService;

    @Autowired
    WorkFlowService workFlowService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    IdentityService identityService;

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    private static final Logger logger = LoggerFactory.getLogger(OdsCounterSignServiceImpl.class);

    /**
     * @param userId        用户id
     * @param projectId     项目id
     * @param applicationId 申请id
     * @return
     */
    @Override
    public String startOdsProcess(Long userId, Long projectId, Long applicationId) {

        Map<String, Object> variables = Maps.newHashMap();
        //1. 为建立和工作流的双边关系，将applicationId作为businessKey
        //获取项目的相关信息，查看项目是否需要会签，或者通过查询projectuser表中有无相关数据来决定
        /*就一共6个角色：
        1.project_secretary项目秘书;
        2.data_manager数据管理员;
        3.data_coordinator数据协调员;
        4.applicant数据申请用户；
        5.project_coordinator项目协调员和
        6.system_admin系统管理员
        5和6是全平台角色*/

        String applyUserId = String.valueOf(userId);
        String businessKey = String.valueOf(applicationId);
        variables.put("applyUserId", applyUserId);

        List<ProjectUser> secretaryList = projectUserService.getDatanegotiatorByProjectIdResult(projectId, 1);
        if (secretaryList == null || secretaryList.size() == 0) {
            throw new RuntimeException("未添加项目秘书！");
        }
        Long secretaryId = secretaryList.get(0).getUserId();
        variables.put("secretaryId", secretaryId);

        List<ProjectUser> dataDeliverUserList = projectUserService.getDatanegotiatorByProjectIdResult(projectId, 2);
        if (dataDeliverUserList == null || dataDeliverUserList.size() == 0) {
            throw new RuntimeException("未添加项目数据管理员！");
        }
        Long dataDeliverUserId = dataDeliverUserList.get(0).getUserId();
        variables.put("dataDeliverUserId", dataDeliverUserId);

        List<ProjectUser> dataCoordinatorList = projectUserService.getDatanegotiatorByProjectIdResult(projectId, 3);
        if (dataCoordinatorList == null || dataCoordinatorList.size() == 0) {
            throw new RuntimeException("未添加项目数据协调员！");
        }
        Long dataCoordinatorId = dataCoordinatorList.get(0).getUserId();
        variables.put("dataCoordinatorId", dataCoordinatorId);

        List<ProjectUser> users = projectUserService.getDatanegotiatorByProjectIdResult(projectId, 5);
        if (users != null && users.size() > 0) {
            variables.put("users", users);
        } else {
            logger.info("该项目没有项目协调员，也就是没有录入意见会签！");
        }

        //2. 开启工作流，返回流程实例id
        //设置流程开启人
        identityService.setAuthenticatedUserId(applyUserId);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("ods", businessKey, variables);


        //3. 将相关信息插入workflow_r表中
        WorkFlowR workFlowR = new WorkFlowR();
        workFlowR.setProcId(processInstance.getProcessInstanceId());
        workFlowR.setApplicationId(applicationId);
        workFlowR.setStatus(0);
        workFlowService.save(workFlowR);

        //4. 替用户完成提交申请这一步
        Task task = taskService.createTaskQuery().processDefinitionKey("ods").taskAssignee(applyUserId).singleResult();
        if(task==null){
            throw new RuntimeException("开启流程出错！");
        }
        taskService.complete(task.getId());

        return processInstance.getProcessInstanceId();
    }

    /**
     * @param applicant 流程申请人
     * @return
     */
    @Override
    public List<ApplicationResult> getOdsProcessList(Long applicant) {
        List<ApplicationResult> results = applicationService.getApplicantAndWorkflowRByApplicant(applicant);
        for (ApplicationResult result : results) {
            String instanceId = result.getWorkFlowR().getProcId();
            if (instanceId != null && !"".equals(instanceId)) {
                //查询当前的任务列表
                List<Task> taskList = taskService.createTaskQuery().processInstanceId(instanceId).list();
                if (CollectionUtils.isEmpty(taskList)) {
                    TaskEntityImpl task = (TaskEntityImpl) taskList.get(0);
                    if (task.getSuspensionState()==2){
                        result.getWorkFlowR().setCurrentTask("任务已挂起");
                    }else{
                        result.getWorkFlowR().setCurrentTask(task.getName());
                    }
                }else{
                    result.getWorkFlowR().setCurrentTask("流程已结束");
                }
                result.getWorkFlowR().setCurrentTask("流程未启动");
            }
        }
        return results;
    }
}
