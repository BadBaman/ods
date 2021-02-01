package cn.stylefeng.guns.activiti.modular.service.impl;

import cn.stylefeng.guns.activiti.modular.Result.OdsApplicationResult;
import cn.stylefeng.guns.activiti.modular.domin.ApproveDto;
import cn.stylefeng.guns.activiti.modular.domin.HistoricActivity;
import cn.stylefeng.guns.activiti.modular.service.OdsCounterSignService;
import cn.stylefeng.guns.activiti.modular.service.WorkFlowService;
import cn.stylefeng.guns.onlineaccess.modular.entity.WorkFlowR;
import cn.stylefeng.guns.onlineaccess.modular.mapper.ApplicationMapper;
import cn.stylefeng.guns.onlineaccess.modular.result.ApplicationResult;
import cn.stylefeng.guns.onlineaccess.modular.result.ProjectUserResult;
import cn.stylefeng.guns.onlineaccess.modular.service.ApplicationService;
import cn.stylefeng.guns.onlineaccess.modular.service.impl.ProjectServiceImpl;
import cn.stylefeng.guns.onlineaccess.modular.service.impl.ProjectUserServiceImpl;
import cn.stylefeng.guns.sys.modular.user.entity.SysUser;
import cn.stylefeng.guns.sys.modular.user.service.SysUserService;
import com.google.common.collect.Maps;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.persistence.entity.TaskEntityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    SysUserService sysUserService;

    @Autowired
    IdentityService identityService;

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Autowired
    HistoryService historyService;

    @Autowired
    ApplicationMapper applicationMapper;

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

        List<ProjectUserResult> secretaryList = projectUserService.getDatanegotiatorByProjectIdResult(projectId, 1);

        if (secretaryList == null || secretaryList.size() == 0) {
            throw new RuntimeException("未添加项目秘书！");
        }
        logger.info("secretaryList.size = {},secretaryList={}",secretaryList.size(),secretaryList);
        Long secretaryId = secretaryList.get(0).getUserId();
        variables.put("secretaryId", secretaryId);

        List<ProjectUserResult> dataDeliverUserList = projectUserService.getDatanegotiatorByProjectIdResult(projectId, 2);
        if (dataDeliverUserList == null || dataDeliverUserList.size() == 0) {
            throw new RuntimeException("未添加项目数据管理员！");
        }
        Long dataDeliverUserId = dataDeliverUserList.get(0).getUserId();
        variables.put("dataDeliverUserId", dataDeliverUserId);

        List<ProjectUserResult> dataCoordinatorList = projectUserService.getDatanegotiatorByProjectIdResult(projectId, 3);
        if (dataCoordinatorList == null || dataCoordinatorList.size() == 0) {
            throw new RuntimeException("未添加项目数据协调员！");
        }
        Long dataCoordinatorId = dataCoordinatorList.get(0).getUserId();
        variables.put("dataCoordinatorId", dataCoordinatorId);

        List<ProjectUserResult> counterSignusers = projectUserService.getDatanegotiatorByProjectIdResult(projectId, 7);
        if (counterSignusers != null && counterSignusers.size() > 0) {
            List<String> users = counterSignusers.stream().map(x -> String.valueOf(x.getUserId())).collect(Collectors.toList());
            //List<String> users = new ArrayList<String>();
            variables.put("users", users);
            variables.put("needSuggestion",true);
        } else {
            variables.put("needSuggestion",false);
            logger.info("该项目没有项目协调员，也就是没有录入意见会签！");
        }

        //2. 开启工作流，返回流程实例id
        //设置流程开启人
        identityService.setAuthenticatedUserId(applyUserId);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("ods", businessKey, variables);


        //3. 将相关信息插入workflow_r表中
        WorkFlowR workFlowR = new WorkFlowR();
        workFlowR.setProcId(processInstance.getId());
        workFlowR.setApplicationId(applicationId);
        workFlowR.setStatus(0);
        workFlowService.save(workFlowR);

        //4. 替用户完成提交申请这一步
        Task task = taskService.createTaskQuery().processDefinitionKey("ods").taskAssignee(applyUserId).singleResult();
        if (task == null) {
            throw new RuntimeException("开启流程出错！");
        }
        taskService.complete(task.getId());

        return processInstance.getId();
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
                if (!CollectionUtils.isEmpty(taskList)) {
                    TaskEntityImpl task = (TaskEntityImpl) taskList.get(0);
                    if (task.getSuspensionState() == 2) {
                        result.getWorkFlowR().setCurrentTask("任务已挂起");
                    } else {
                        result.getWorkFlowR().setCurrentTask(task.getName());
                    }
                } else {
                    result.getWorkFlowR().setCurrentTask("流程已结束");
                }

            }else{
                result.getWorkFlowR().setCurrentTask("流程未启动");
            }
        }
        return results;
    }

    @Override
    public List<OdsApplicationResult> findTaskDoneList(Integer pageNow, Integer pagesize, String userId) {
        List<HistoricTaskInstance> hisTaskList = historyService
                .createHistoricTaskInstanceQuery()
                .processDefinitionKey("ods")
                .taskAssignee(userId)
                .finished()
                .orderByHistoricTaskInstanceEndTime()
                .desc()
                .listPage((pageNow - 1) * pagesize, pagesize);

        List<OdsApplicationResult> results = new ArrayList<>();

        for (HistoricTaskInstance instance : hisTaskList) {
            String processInstanceId = instance.getProcessInstanceId();
            HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery()
                    .processInstanceId(processInstanceId).singleResult();
            String businessKey = processInstance.getBusinessKey();
            ApplicationResult applicationResult = applicationService.getApplicantAndWorkflowRByApplicationId(businessKey);
            SysUser user = sysUserService.getById(applicationResult.getApplicantId());
            OdsApplicationResult result = new OdsApplicationResult();
            //BeanUtils.copyProperties(applicationResult, result);
            //logger.info("---{}",instance.getName());
            //applicationResult.getWorkFlowR().setCurrentTask(instance.getName());
            result.setTaskId(instance.getId());
            result.setUsername(user.getName());
            result.setTaskName(instance.getName());
            result.setDoneTime(instance.getEndTime());
            result.setApplicationResult(applicationResult);
            results.add(result);
        }
        return results;
    }

    @Override
    public List<OdsApplicationResult> findToDoTaskDoneList(Integer pageNow, Integer pagesize, String userId) {
        //List<Task> tasks = findTodoTasks(userId, "ods");
        List<Task> todoTaskList = taskService
                .createTaskQuery()
                .processDefinitionKey("ods")
                .taskAssignee(userId)
                .orderByTaskCreateTime()
                .desc()
                .listPage((pageNow - 1) * pagesize, pagesize);
        logger.info("todoTaskList = {}",todoTaskList);
        List<OdsApplicationResult> results = new ArrayList<>();
        for (Task task : todoTaskList) {
            TaskEntityImpl taskImpl = (TaskEntityImpl) task;

            String processInstanceId = taskImpl.getProcessInstanceId();

            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
            String businessKey = processInstance.getBusinessKey();
            logger.info("businessKey = {}", businessKey);//这个businessKey是application表的主键
            ApplicationResult applicationResult = applicationService.getApplicantAndWorkflowRByApplicationId(businessKey);
            if(applicationResult==null || applicationResult.getApplicantId()==null){
                throw new RuntimeException("内部服务器错误,没有这条申请！");
            }
            SysUser user = sysUserService.getById(applicationResult.getApplicantId());
            OdsApplicationResult result = new OdsApplicationResult();
            logger.info("applicationResult = {}", applicationResult);
            //BeanUtils.copyProperties(result, applicationResult);
            logger.info("result = {}", result);
            if(user==null){
                throw new RuntimeException("内部服务器错误，没有这个用户！");
            }
            if(taskImpl.getSuspensionState()==2){
                applicationResult.getWorkFlowR().setCurrentTask("已挂起");
            }else{
                applicationResult.getWorkFlowR().setCurrentTask(taskImpl.getName());
            }
            result.setUsername(user.getName());
            result.setTaskId(taskImpl.getId());
            result.setApplicationResult(applicationResult);
            results.add(result);
        }
        return results;
    }
    private List<Task> findTodoTasks(String userId, String key) {
        List<Task> tasks = new ArrayList<Task>();
        // 根据当前人的ID查询
        List<Task> todoList = taskService
                .createTaskQuery()
                .processDefinitionKey(key)
                .taskAssignee(userId)
                .list();
        logger.info("todoList = {}",todoList);
        // 根据当前人未签收的任务
        List<Task> unsignedTasks = taskService
                .createTaskQuery()
                .processDefinitionKey(key)
                .taskCandidateUser(userId)
                .list();
        // 合并
        logger.info("unsignedTasks = {}",unsignedTasks);
        tasks.addAll(todoList);
        tasks.addAll(unsignedTasks);
        return tasks;
    }
    @Override
    public boolean completeTask(ApproveDto approveDto, String userId) {
        Map<String, Object> variables = new HashMap<>();
        identityService.setAuthenticatedUserId(userId);
        String taskId = approveDto.getTaskId();
        String instanceId = approveDto.getInstanceId();
        //String activitiFlag = approveDto.getActivitiFlag();
        boolean isApprove = approveDto.getIsApprove();
        String comment = null;

        comment = isApprove ? "【同意】" + approveDto.getComment() : "【拒绝】" + approveDto.getComment();

        variables.put("comment",comment);
        //variables.put(activitiFlag,isApprove);// 如果是会签 activitiFlag 就是 approved
        taskService.addComment(taskId,instanceId,comment);

        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task==null){
            throw new RuntimeException("系统错误，该任务已完成！");
        }else{
            String formKey = task.getFormKey();
            if(formKey!=null && !formKey.equals("")){
                variables.put(formKey.split(":")[1],isApprove);
            }
        }
        //task.get
        //task.getFormKey()
        //任务所有者
        String taskOwner = task.getOwner();
        //任务代办人
        String taskAssignee = task.getAssignee();
        if(taskOwner!=null && !taskOwner.equals(taskAssignee)){//任务被指派出去了
            taskService.resolveTask(taskId,variables);
        }else{// 任务有本人完成
            taskService.complete(taskId,variables);
        }
        task = taskService.createTaskQuery().taskId(taskId).singleResult();
        return task==null;
    }

    /**
     *
     * @param processInstanceId 流程实例id
     * @return
     */
    @Override
    public List<HistoricActivity> selectHistoryList(String processInstanceId) {

        List<HistoricActivity> activityList = new ArrayList<>();

        List<HistoricActivityInstance> list = historyService.createHistoricActivityInstanceQuery()
                .processInstanceId(processInstanceId)
                .activityType("userTask")
                .finished()
                .orderByHistoricActivityInstanceEndTime()
                //.orderByHistoricActivityInstanceStartTime()
                //.desc()
                .asc()
                .list();

        list.forEach(instance -> {
            HistoricActivity activity = new HistoricActivity();
            BeanUtils.copyProperties(instance,activity);
            //instance.
            String taskId = instance.getTaskId();
            //查询历史评论
            List<Comment> comments = taskService.getTaskComments(taskId, "comment");
            if(!CollectionUtils.isEmpty(comments)){
                activity.setComment(comments.get(0).getFullMessage());
            }

            //查询任务执行人的名字
            SysUser user = sysUserService.getById(instance.getAssignee());
            //SysUser sysUser = sysUserService.getUserByCount(instance.getAssignee());
            if(user!=null){
                activity.setAssigneeName(user.getName());
            }
            activityList.add(activity);
        });

        return activityList;
    }
}
