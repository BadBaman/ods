package cn.stylefeng.guns.activiti.modular;

import cn.stylefeng.guns.activiti.modular.Result.OdsApplicationResult;
import cn.stylefeng.guns.activiti.modular.domin.ApproveDto;
import cn.stylefeng.guns.activiti.modular.domin.HistoricActivity;
import cn.stylefeng.guns.activiti.modular.service.OdsCounterSignService;
import cn.stylefeng.guns.onlineaccess.modular.entity.Application;
import cn.stylefeng.guns.onlineaccess.modular.result.ApplicationResult;
import cn.stylefeng.guns.onlineaccess.modular.service.ApplicationService;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class OdsCounterSignTest extends BaseJunit {

    private static final Logger logger = LoggerFactory.getLogger(OdsCounterSignTest.class);

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    OdsCounterSignService odsCounterSignService;

    @Autowired
    ApplicationService applicationService;

    @Test
    public void deployOdsBpmn() {
        Deployment deploy = repositoryService.createDeployment()
                .name("ods bpmn")
                .addClasspathResource("ODS.bpmn20.xml")
                .deploy();
        logger.info("deploy = {},deploy.id = {}", deploy, deploy.getId());
    }

    @Test
    @Transactional
    @Rollback()
    public void testStartOdsProcess() {

        Long userId = 1346705647156162562L;
        Long orgId = 1265476890651701200L;
        //部署
        Deployment deploy = repositoryService.createDeployment()
                .name("ods bpmn")
                .addClasspathResource("ODS.bpmn20.xml")
                .deploy();
        logger.info("deploy = {},deploy.id = {}", deploy, deploy.getId());

        // 插入application ，拿到application_id
        Application application = new Application();
        application.setApplicantId(userId);
        application.setOrgId(orgId);
        application.setCreatedTime(new Date());
        application.setSubjectName("test");
        application.setSubjectKeyword("test");
        application.setProjectParticipants("test");
        application.setStatus(0);
        applicationService.save(application);

        logger.info("applciation id = {}", application.getId());

        String processInstanceId = odsCounterSignService.startOdsProcess(userId, 1L, application.getId());
        logger.info("processInstanceId = {}", processInstanceId);

    }


    @Test
    @Transactional
    @Rollback()
    public void testGetOdsProcessList() {

        Long userId = 1346705647156162562L;
        Long orgId = 1265476890651701200L;
        //部署
        Deployment deploy = repositoryService.createDeployment()
                .name("ods bpmn")
                .addClasspathResource("ODS.bpmn20.xml")
                .deploy();
        //logger.info("deploy = {},deploy.id = {}", deploy, deploy.getId());

        // 插入application ，拿到application_id
        Application application = new Application();
        application.setApplicantId(userId);
        application.setOrgId(orgId);
        application.setCreatedTime(new Date());
        application.setSubjectName("test");
        application.setSubjectKeyword("test");
        application.setProjectParticipants("test");
        application.setStatus(0);
        applicationService.save(application);

        //logger.info("applciation id = {}", application.getId());

        String processInstanceId = odsCounterSignService.startOdsProcess(userId, 1L, application.getId());
        //logger.info("processId = {}", processInstanceId);

        logger.info("流程已经启动");

        logger.info("流程列表");
        List<ApplicationResult> odsProcessList = odsCounterSignService.getOdsProcessList(userId);
        logger.info("odsProcessList.size = {},odsProcessList = {}", odsProcessList.size(), odsProcessList);
        for (ApplicationResult result : odsProcessList) {
            logger.info("result = {}", result);
            logger.info("current_task = {}", result.getWorkFlowR().getCurrentTask());
        }

        //代办 1346705647156162562
        Long toDoUser = 1346705647156162562L;
        List<OdsApplicationResult> toDoTaskDoneList = odsCounterSignService.findToDoTaskDoneList(1, 100, String.valueOf(toDoUser));

        logger.info("toDoTaskDoneList.size = {}", toDoTaskDoneList.size());
        for (OdsApplicationResult result : toDoTaskDoneList) {
            logger.info("result = {}", result);
        }
        //完成 怎样区分不同用户的表示，用户表的某一件键或者bpmn上找

        logger.info("完成任务");

        ApproveDto approveDto = new ApproveDto();
        approveDto.setTaskId(toDoTaskDoneList.get(0).getTaskId());
        approveDto.setInstanceId(toDoTaskDoneList.get(0).getApplicationResult().getWorkFlowR().getProcId());
        approveDto.setIsApprove(true);
        approveDto.setComment("没问题！");

        boolean completeTask = odsCounterSignService.completeTask(approveDto, String.valueOf(toDoUser));
        logger.info("completeTask = {}", completeTask);

        toDoTaskDoneList = odsCounterSignService.findToDoTaskDoneList(1, 100, String.valueOf(toDoUser));
        logger.info("toDoTaskDoneList.size = {}", toDoTaskDoneList.size());
        //已办
        logger.info("查询已办");
        List<OdsApplicationResult> taskDoneList = odsCounterSignService.findTaskDoneList(1, 100, String.valueOf(toDoUser));
        for (OdsApplicationResult result : taskDoneList) {
            logger.info("taskdoneresult = {}", result);
        }

        //审批历史
        logger.info("查询审批历史");
        List<HistoricActivity> historicActivities = odsCounterSignService.selectHistoryList(taskDoneList.get(0).getApplicationResult().getWorkFlowR().getProcId());
        for (HistoricActivity historicActivity : historicActivities) {

            logger.info("historicActivity = {},taskid={},taskname = {}", historicActivity,historicActivity.getTaskId(),historicActivity.getActivityName());
        }
    }

}


