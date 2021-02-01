package cn.stylefeng.guns.activiti.modular;

import com.google.common.collect.Maps;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OdsServiceTest extends BaseJunit {
    private static final Logger logger = LoggerFactory.getLogger(OdsServiceTest.class);

//    @Rule
//    public ActivitiRule activitiRule = new ActivitiRule();

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    IdentityService identityService;

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    HistoryService historyService;

    @Autowired
    TaskService taskService;

    /**
     * ods bpmn 测试
     */
    @Test
    @Transactional
    @Rollback()
    public void testTaskServiceUser() {

        Deployment deploy = repositoryService.createDeployment()
                .name("ods bpmn")
                .addClasspathResource("ODS.bpmn20.xml")
                .deploy();

        Map<String, Object> variables = Maps.newHashMap();

        String applyUserId = "applyUser";
        String secretaryId = "secretaryId";
        String dataDeliverUserId = "dataDeliverUserId";
        String dataCoordinatorId = "dataCoordinatorId";

        variables.put("applyUserId", applyUserId);
        variables.put("secretaryId", secretaryId);
        variables.put("dataDeliverUserId", dataDeliverUserId);
        variables.put("dataCoordinatorId", dataCoordinatorId);

        boolean needSuggestion = true;
        variables.put("needSuggestion", needSuggestion);


        if (needSuggestion) {
            List<String> users = new ArrayList<String>();
            users.add("shenpiuser1");
            users.add("shenpiuser2");
            users.add("shenpiuser3");
            variables.put("users", users);
        }

        //设置流程开启人
        identityService.setAuthenticatedUserId(applyUserId);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("ods", variables);

        //TaskService taskService = activitiRule.getTaskService();

        //Task task = taskService.createTaskQuery().singleResult();
        //logger.info("task(default style) = {}", ToStringBuilder.reflectionToString(task, ToStringStyle.DEFAULT_STYLE));

        //提交申请
        List<Task> taskList = taskService.createTaskQuery().processDefinitionKey("ods").taskAssignee(applyUserId).listPage(0, 100);
        for (Task task : taskList) {
            logger.info("task = {}", task);
            logger.info("task.name = {},task.Assignee = {}", task.getName(), task.getAssignee());
            //完成任务
            taskService.complete(task.getId());
        }
        logger.info("----------");

        //如果 needSuggestion 为true，则是进行会签任务
        List<Task> taskList1 = taskService.createTaskQuery().processDefinitionKey("ods").listPage(0, 100);
        for (Task task : taskList1) {
            logger.info("task = {}", task);
            //logger.info("task = {}", task.);
            logger.info("task.name = {},task.Assignee = {}", task.getName(), task.getAssignee());
            taskService.complete(task.getId());
        }
        logger.info("----------");

        List<Task> taskList2 = taskService.createTaskQuery().processDefinitionKey("ods").listPage(0, 100);

        //秘书确认 需要传入是否召开 评审会议变量 needJudgeMeeting
        for (Task task : taskList2) {
            logger.info("task = {}", task);
            logger.info("task.formkey = {}", task.getFormKey());
            logger.info("task.name = {},task.Assignee = {}", task.getName(), task.getAssignee());
            Map<String, Object> var = Maps.newHashMap();
            var.put("needJudgeMeeting", true);
            taskService.complete(task.getId(), var);
        }

        List<Task> taskList3 = taskService.createTaskQuery().processDefinitionKey("ods").listPage(0, 100);
        //秘书录入评审意见 需要传入是否通过评审变量 passReview
        for (Task task : taskList3) {
            logger.info("task = {}", task);
            logger.info("task.formkey = {}", task.getFormKey());
            logger.info("task.name = {},task.Assignee = {}", task.getName(), task.getAssignee());
            Map<String, Object> var = Maps.newHashMap();
            var.put("passReview", true);
            taskService.complete(task.getId(), var);
        }

        //数据交付
        List<Task> taskList4 = taskService.createTaskQuery().processDefinitionKey("ods").listPage(0, 100);
        for (Task task : taskList4) {
            logger.info("task = {}", task);
            logger.info("task.name = {},task.Assignee = {}", task.getName(), task.getAssignee());
            taskService.complete(task.getId());
        }

//        //提交疑问申请
//        List<Task> taskList5 = taskService.createTaskQuery().processDefinitionKey("ods").listPage(0, 100);
//        for (Task task : taskList5) {
//            logger.info("task = {}", task);
//            logger.info("task.name = {},task.Assignee = {}", task.getName(), task.getAssignee());
//            taskService.complete(task.getId());
//        }

        //提交疑问申请，用户是否有疑问
        List<Task> taskList6 = taskService.createTaskQuery().processDefinitionKey("ods").listPage(0, 100);
        for (Task task : taskList6) {
            logger.info("task = {}", task);
            logger.info("task.formkey = {}", task.getFormKey());
            logger.info("task.name = {},task.Assignee = {}", task.getName(), task.getAssignee());
            Map<String, Object> var = Maps.newHashMap();
            var.put("havaDoubt", true);
            taskService.complete(task.getId(), var);
        }

        //协调员确认
        List<Task> taskList7 = taskService.createTaskQuery().processDefinitionKey("ods").listPage(0, 100);
        for (Task task : taskList7) {
            logger.info("task = {}", task);
            logger.info("task.formkey = {}", task.getFormKey());
            logger.info("task.name = {},task.Assignee = {}", task.getName(), task.getAssignee());
            Map<String, Object> var = Maps.newHashMap();
            var.put("needReDeliver", false);
            taskService.complete(task.getId(), var);
        }

        Execution execution = runtimeService.createExecutionQuery().processInstanceId(processInstance.getId()).singleResult();
        logger.info("execution = {}",execution);

        HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult();

        if(historicProcessInstance!=null){
            logger.info("endTime = {}",historicProcessInstance.getEndTime());
        }
//        ProcessInstanceQuery active = runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).or()
//        logger.info("active = {}", active);

    }
}
