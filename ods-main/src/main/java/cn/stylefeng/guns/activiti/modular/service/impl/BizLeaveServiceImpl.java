package cn.stylefeng.guns.activiti.modular.service.impl;

import cn.stylefeng.guns.activiti.modular.config.ICustomProcessDiagramGenerator;
import cn.stylefeng.guns.activiti.modular.config.WorkflowConstants;
import cn.stylefeng.guns.activiti.modular.domin.ApproveDto;
import cn.stylefeng.guns.activiti.modular.domin.BizLeaveVo;
import cn.stylefeng.guns.activiti.modular.domin.HistoricActivity;
import cn.stylefeng.guns.activiti.modular.mapper.BizLeaveMapper;
import cn.stylefeng.guns.activiti.modular.service.IBizLeaveService;
import cn.stylefeng.guns.core.pojo.login.SysLoginUser;
import cn.stylefeng.guns.sys.modular.user.entity.SysUser;
import cn.stylefeng.guns.sys.modular.user.service.SysUserService;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowNode;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class BizLeaveServiceImpl implements IBizLeaveService {

    @Autowired
    private BizLeaveMapper bizLeaveMapper;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private IdentityService identityService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ProcessEngine processEngine;
    @Resource
    private SysUserService sysUserService;
    private static final Logger logger = LoggerFactory.getLogger(BizLeaveServiceImpl.class);

    @Override
    public BizLeaveVo selectBizLeaveById(Long id) {
        BizLeaveVo leave = bizLeaveMapper.selectBizLeaveById(id);
        SysUser sysUser = sysUserService.getUserByCount(leave.getApplyUser());
        //SysUser sysUser = userMapper.selectUserByLoginName(leave.getApplyUser());
        if (sysUser != null) {
            leave.setApplyUserName(sysUser.getName());
        }
        return leave;
    }


    @Override
    public int updateBizLeave(BizLeaveVo bizLeave) {
        bizLeave.setUpdateTime(new Date());
        return bizLeaveMapper.updateBizLeave(bizLeave);
    }

    /**
     * 请假流程列表
     * @param bizLeaveVo
     * @return
     */
    @Override
    public List<BizLeaveVo> selectBizLeaveList(BizLeaveVo bizLeaveVo) {
        List<BizLeaveVo> bizLeaveVos = bizLeaveMapper.selectBizLeaveList(bizLeaveVo);
        for (BizLeaveVo leave : bizLeaveVos) {
            if(leave.getInstanceId()!=null && !"".equals(leave.getInstanceId())){
                //查询流程的当前任务列表
                List<Task> taskList = taskService.createTaskQuery()
                        .processInstanceId(leave.getInstanceId())
                        .list();    // 例如请假会签，会同时拥有多个任务
                if (!CollectionUtils.isEmpty(taskList)) {//如果任务列表不为空
                    TaskEntityImpl task = (TaskEntityImpl) taskList.get(0);
                    leave.setTaskId(task.getId());
                    if (task.getSuspensionState() == 2) {
                        leave.setTaskName("已挂起");
                        leave.setSuspendState("2");
                    } else {
                        leave.setTaskName(task.getName());
                        leave.setSuspendState("1");
                    }
                } else {// 任务列表为空 则是流程已办结或者已撤销
                    leave.setTaskName("已结束");
                }
            }else{
                leave.setTaskName("未启动");
            }
        }
        return bizLeaveVos;
    }


    /**
     * 已办
     * 没有进行分页和过滤
     * @param bizLeaveVo 封装了搜索条件
     * @param userId
     * @return
     */
    @Override
    public List<BizLeaveVo> findTaskDoneList(BizLeaveVo bizLeaveVo, String userId) {
        List<HistoricTaskInstance> hisList = historyService
                .createHistoricTaskInstanceQuery()
                .processDefinitionKey(bizLeaveVo.getType())
                .taskAssignee(userId)
                .finished()
                .orderByHistoricTaskInstanceEndTime()
                .desc()
                .list();

        List<BizLeaveVo> results = new ArrayList<>();
        //未过滤
        for (HistoricTaskInstance instance : hisList) {
            String processInstanceId = instance.getProcessInstanceId();
            HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery()
                    .processInstanceId(processInstanceId).singleResult();
            String businessKey = processInstance.getBusinessKey();
            BizLeaveVo leave2 = bizLeaveMapper.selectBizLeaveById(new Long(businessKey));
            BizLeaveVo newLeave = new BizLeaveVo();
            BeanUtils.copyProperties(leave2, newLeave);
            newLeave.setTaskId(instance.getId());
            newLeave.setTaskName(instance.getName());
            newLeave.setDoneTime(instance.getEndTime());
            results.add(newLeave);
        }
        return results;
    }

    /**
     * 代办
     * 没有进行分页和过滤
     * @param bizLeaveVo
     * @param userId
     * @return
     */
    @Override
    public List<BizLeaveVo> findToDoTaskDoneList(BizLeaveVo bizLeaveVo, String userId) {
        List<Task> tasks = findTodoTasks(userId, bizLeaveVo.getType());

        List<BizLeaveVo> results = new ArrayList<>();
        for (Task task : tasks) {
            TaskEntityImpl taskImpl = (TaskEntityImpl) task;

            String processInstanceId = taskImpl.getProcessInstanceId();

            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
            String businessKey = processInstance.getBusinessKey();
            logger.info("businessKey = {}", businessKey);//这个businessKey为什是biz_leave表的主键id
            BizLeaveVo leave2 = bizLeaveMapper.selectBizLeaveById(new Long(businessKey));

            leave2.setTaskId(taskImpl.getId());
            if (taskImpl.getSuspensionState() == 2) {
                leave2.setTaskName("已挂起");
            } else {
                leave2.setTaskName(taskImpl.getName());
            }
            logger.info("leave2 = {}", leave2);
            results.add(leave2);
        }

        return results;
    }


    /**
     * 开始流程 流程开启后如何为任务指定代办人，不能固定，应该要从数据库中查询到
     * @param leave 依据leave id查询的请假实体类
     * @param loginUser 登录用户
     * @param key 流程key 有leave和leave-countersign
     * @param variables 启动参数变量
     * @return
     */
    @Override
    public String submitApply(BizLeaveVo leave, SysLoginUser loginUser, String key, Map<String, Object> variables) {
        Long applyUserId = loginUser.getId();
        String applyUserName = loginUser.getUsername();
        Date applyDate = new Date();

        leave.setApplyUser(applyUserName);
        leave.setApplyTime(applyDate);
        leave.setUpdateUser(applyUserId);
        leave.setUpdateTime(applyDate);



        bizLeaveMapper.updateBizLeave(leave);
        //保存启动流程参数
        if(key.equals("leave")){
            variables.put("applyUserId",applyUserId);
            variables.put("deptLeaderId",String.valueOf(1346705647156162562L));
            variables.put("hrId",String.valueOf(1346705647156162562L));
            variables.put("applyUserName",applyUserName);
            variables.put("applyDate",applyDate);
            variables.put("leave",leave);
        }else if(key.equals("leave-countersign")){
            //ODS项目流程会签需要获取当前项目的相关审批人，以及需要参与的填写意见的会签用户

            //数据库查询出的id是Long类型，需要转换成String类型 tcycy 和 xuyuxiang
            Long users1[] = new Long[]{1346705647156162562L,1280709549107552257L};
            List<Long> users2 = (List<Long>) Arrays.asList(users1);
            List<String> users = users2.stream().map(x -> String.valueOf(x)).collect(Collectors.toList());

            variables.put("users",users);
        }


        String businessKey = leave.getId().toString();
        //保存发起人信息 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
        identityService.setAuthenticatedUserId(String.valueOf(applyUserId));
        //开启流程，传入业务id作为businessKey
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, businessKey, variables);
        leave.setInstanceId(processInstance.getId());//表和流程建立双向绑定关系
        bizLeaveMapper.updateBizLeave(leave);

        //保存启动流程信息

        return processInstance.getProcessInstanceId();
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


    /**
     * 新增请假流程
     * @param bizLeaveVo
     * @return
     */
    @Override
    public int insertBizLeave(BizLeaveVo bizLeaveVo, SysLoginUser loginUser) {
        bizLeaveVo.setCreateUser(loginUser.getId());
        bizLeaveVo.setCreateTime(new Date());
        return bizLeaveMapper.insertBizLeave(bizLeaveVo);
    }

    /**
     * 完成任务 completetask bussinesskey
     * @param userId 用户id
     */
    @Override
    public void completeTask(ApproveDto approveDto, String userId) {
        Map<String, Object> variables = new HashMap<>();
        identityService.setAuthenticatedUserId(userId);
        String taskId = approveDto.getTaskId();
        String instanceId = approveDto.getInstanceId();
        String activitiFlag = approveDto.getActivitiFlag();
        String comment;
        boolean isApprove = approveDto.getIsApprove();

        comment = isApprove ? "【同意】" + approveDto.getComment() : "【拒绝】" + approveDto.getComment();


        variables.put("comment",comment);
        variables.put(activitiFlag,isApprove);// 如果是会签 activitiFlag 就是 approved
        taskService.addComment(taskId,instanceId,comment);

        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        //任务所有者
        String taskOwner = task.getOwner();
        //任务代办人
        String taskAssignee = task.getAssignee();
        if(taskOwner!=null && !taskOwner.equals(taskAssignee)){//任务被指派出去了
            taskService.resolveTask(taskId,variables);
        }else{// 任务有本人完成
            taskService.complete(taskId,variables);
        }

    }

    /**
     * 流程历史，可以结合流程图，和已办待办不同， processhistory bussinesskey
     * @param processInstanceId 流程实例id
     * @param historicActivity 封装的查询条件
     * @return
     */
    @Override
    public List<HistoricActivity> selectHistoryList(String processInstanceId, HistoricActivity historicActivity) {
        List<HistoricActivity> activityList = new ArrayList<>();
        HistoricActivityInstanceQuery query = historyService.createHistoricActivityInstanceQuery();
        //如果查询条件的审批人不为空，将其加入到查询条件中
        if(historicActivity.getAssignee()!=null && !historicActivity.getAssignee().equals("")){
            query.taskAssignee(historicActivity.getAssignee());
        }
        if(historicActivity.getActivityName()!=null && historicActivity.getActivityName().equals("")){
            query.activityName(historicActivity.getActivityName());
        }

        List<HistoricActivityInstance> list = query.processInstanceId(processInstanceId)
                .activityType("userTask")
                .finished()
                .orderByHistoricActivityInstanceStartTime()
                .desc()
                .list();

        list.forEach(instance -> {
            HistoricActivity activity = new HistoricActivity();
            BeanUtils.copyProperties(instance,activity);
            String taskId = instance.getTaskId();
            //查询历史评论
            List<Comment> comments = taskService.getTaskComments(taskId, "comment");
            if(CollectionUtils.isEmpty(comments)){
                activity.setComment(comments.get(0).getFullMessage());
            }

            //查询任务执行人的名字
            SysUser sysUser = sysUserService.getUserByCount(instance.getAssignee());
            if(sysUser!=null){
                activity.setAssigneeName(sysUser.getName());
            }
            activityList.add(activity);
        });

        return activityList;
    }

    /**
     *
     * @param pProcessInstanceId 流程ID
     * @param response 响应
     */
    @Override
    public void resloveProcessDiagram(String pProcessInstanceId, HttpServletResponse response) throws Exception{
        String processDefinitionId = "";
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(pProcessInstanceId).singleResult();
        if(processInstance == null) {
            HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(pProcessInstanceId).singleResult();
            processDefinitionId = historicProcessInstance.getProcessDefinitionId();
        } else {
            processDefinitionId = processInstance.getProcessDefinitionId();
        }
        ProcessDefinitionQuery pdq = repositoryService.createProcessDefinitionQuery();
        ProcessDefinition pd = pdq.processDefinitionId(processDefinitionId).singleResult();

        String resourceName = pd.getDiagramResourceName();

        if(resourceName.endsWith(".png") && (pProcessInstanceId!=null && !pProcessInstanceId.equals("")))
        {
            getActivitiProccessImage(pProcessInstanceId,response);
            //ProcessDiagramGenerator.generateDiagram(pde, "png", getRuntimeService().getActiveActivityIds(processInstanceId));
        }
        else
        {
            // 通过接口读取
            InputStream resourceAsStream = repositoryService.getResourceAsStream(pd.getDeploymentId(), resourceName);

            // 输出资源内容到相应对象
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
                response.getOutputStream().write(b, 0, len);
            }
        }
    }

    /**
     * 获取流程图像，已执行节点和流程线高亮显示
     */
    public void getActivitiProccessImage(String pProcessInstanceId, HttpServletResponse response) {
        //logger.info("[开始]-获取流程图图像");
        try {
            //  获取历史流程实例
            HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery()
                    .processInstanceId(pProcessInstanceId).singleResult();

            if (historicProcessInstance == null) {
                //throw new BusinessException("获取流程实例ID[" + pProcessInstanceId + "]对应的历史流程实例失败！");
            }
            else {
                // 获取流程定义
                ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
                        .getDeployedProcessDefinition(historicProcessInstance.getProcessDefinitionId());

                // 获取流程历史中已执行节点，并按照节点在流程中执行先后顺序排序
                List<HistoricActivityInstance> historicActivityInstanceList = historyService.createHistoricActivityInstanceQuery()
                        .processInstanceId(pProcessInstanceId).orderByHistoricActivityInstanceId().asc().list();

                // 已执行的节点ID集合
                List<String> executedActivityIdList = new ArrayList<String>();
                int index = 1;
                //logger.info("获取已经执行的节点ID");
                for (HistoricActivityInstance activityInstance : historicActivityInstanceList) {
                    executedActivityIdList.add(activityInstance.getActivityId());

                    //logger.info("第[" + index + "]个已执行节点=" + activityInstance.getActivityId() + " : " +activityInstance.getActivityName());
                    index++;
                }

                BpmnModel bpmnModel = repositoryService.getBpmnModel(historicProcessInstance.getProcessDefinitionId());

                // 已执行的线集合
                List<String> flowIds = new ArrayList<String>();
                // 获取流程走过的线 (getHighLightedFlows是下面的方法)
                flowIds = getHighLightedFlows(bpmnModel,processDefinition, historicActivityInstanceList);

//                // 获取流程图图像字符流
//                ProcessDiagramGenerator pec = processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator();
//                //配置字体
//                InputStream imageStream = pec.generateDiagram(bpmnModel, "png", executedActivityIdList, flowIds,"宋体","微软雅黑","黑体",null,2.0);

                Set<String> currIds = runtimeService.createExecutionQuery().processInstanceId(pProcessInstanceId).list()
                        .stream().map(e->e.getActivityId()).collect(Collectors.toSet());

                ICustomProcessDiagramGenerator diagramGenerator = (ICustomProcessDiagramGenerator) processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator();
                InputStream imageStream = diagramGenerator.generateDiagram(bpmnModel, "png", executedActivityIdList,
                        flowIds, "宋体", "宋体", "宋体", null, 1.0, new Color[] { WorkflowConstants.COLOR_NORMAL, WorkflowConstants.COLOR_CURRENT }, currIds);

                response.setContentType("image/png");
                OutputStream os = response.getOutputStream();
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                while ((bytesRead = imageStream.read(buffer, 0, 8192)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                os.close();
                imageStream.close();
            }
            //logger.info("[完成]-获取流程图图像");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //logger.error("【异常】-获取流程图失败！" + e.getMessage());
            //throw new BusinessException("获取流程图失败！" + e.getMessage());
        }
    }

    /**
     * 将走过的流程高亮显示
     * @param bpmnModel
     * @param processDefinitionEntity
     * @param historicActivityInstances
     * @return
     */
    private List<String> getHighLightedFlows(BpmnModel bpmnModel,ProcessDefinitionEntity processDefinitionEntity,List<HistoricActivityInstance> historicActivityInstances) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //24小时制
        List<String> highFlows = new ArrayList<String>();// 用以保存高亮的线flowId

        for (int i = 0; i < historicActivityInstances.size() - 1; i++) {
            // 对历史流程节点进行遍历
            // 得到节点定义的详细信息
            FlowNode activityImpl = (FlowNode)bpmnModel.getMainProcess().getFlowElement(historicActivityInstances.get(i).getActivityId());


            List<FlowNode> sameStartTimeNodes = new ArrayList<FlowNode>();// 用以保存后续开始时间相同的节点
            FlowNode sameActivityImpl1 = null;

            HistoricActivityInstance activityImpl_ = historicActivityInstances.get(i);// 第一个节点
            HistoricActivityInstance activityImp2_ ;

            for(int k = i + 1 ; k <= historicActivityInstances.size() - 1; k++) {
                activityImp2_ = historicActivityInstances.get(k);// 后续第1个节点

                if ( activityImpl_.getActivityType().equals("userTask") && activityImp2_.getActivityType().equals("userTask") &&
                        df.format(activityImpl_.getStartTime()).equals(df.format(activityImp2_.getStartTime()))   ) //都是usertask，且主节点与后续节点的开始时间相同，说明不是真实的后继节点
                {

                }
                else {
                    sameActivityImpl1 = (FlowNode)bpmnModel.getMainProcess().getFlowElement(historicActivityInstances.get(k).getActivityId());//找到紧跟在后面的一个节点
                    break;
                }

            }
            sameStartTimeNodes.add(sameActivityImpl1); // 将后面第一个节点放在时间相同节点的集合里
            for (int j = i + 1; j < historicActivityInstances.size() - 1; j++) {
                HistoricActivityInstance activityImpl1 = historicActivityInstances.get(j);// 后续第一个节点
                HistoricActivityInstance activityImpl2 = historicActivityInstances.get(j + 1);// 后续第二个节点

                if (df.format(activityImpl1.getStartTime()).equals(df.format(activityImpl2.getStartTime()))  )
                {// 如果第一个节点和第二个节点开始时间相同保存
                    FlowNode sameActivityImpl2 = (FlowNode)bpmnModel.getMainProcess().getFlowElement(activityImpl2.getActivityId());
                    sameStartTimeNodes.add(sameActivityImpl2);
                }
                else
                {// 有不相同跳出循环
                    break;
                }
            }
            List<SequenceFlow> pvmTransitions = activityImpl.getOutgoingFlows() ; // 取出节点的所有出去的线

            for (SequenceFlow pvmTransition : pvmTransitions)
            {// 对所有的线进行遍历
                FlowNode pvmActivityImpl = (FlowNode)bpmnModel.getMainProcess().getFlowElement( pvmTransition.getTargetRef());// 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
                if (sameStartTimeNodes.contains(pvmActivityImpl)) {
                    highFlows.add(pvmTransition.getId());
                }
            }

        }
        return highFlows;
    }
}
