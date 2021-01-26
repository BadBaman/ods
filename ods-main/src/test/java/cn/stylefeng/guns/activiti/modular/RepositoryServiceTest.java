package cn.stylefeng.guns.activiti.modular;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RepositoryServiceTest extends BaseJunit {
    /*

    流程存储服务RepositoryService主要的功能如下：

    管理流程定义文件xml和静态资源的服务
    对特定流程的暂停和激活
    流程定义启动权限管理
    部署文件构造器DeploymentBuilder
    部署文件查询器DeploymentQuery
    流程定义查询对象ProcessDefinition
    流程定义的java格式BpmnModel
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryServiceTest.class);

    @Autowired
    public RepositoryService repositoryService;

    @Autowired
    RuntimeService runtimeService;
    @Test
    @Transactional
    @Rollback(false)
    public void testRepository() {
        //RepositoryService repositoryService = activitiRule.getRepositoryService();

        DeploymentBuilder deployment = repositoryService.createDeployment();
        deployment.name("会签流程")  //流程名称
                .addClasspathResource("leave-countersign.bpmn20.xml"); //为部署添加资源，可以添加多个

        //创建部署对象
        Deployment deploy = deployment.deploy();

        LOGGER.info("deploy = {}", deploy);

        //创建部署查询对象
        List<Deployment> deployments = repositoryService.createDeploymentQuery().orderByDeploymenTime().asc().listPage(0, 100);
        for (Deployment deploy_ : deployments) {
            LOGGER.info("deployment = {}", deploy_);
        }

        LOGGER.info("deployments.size = {}", deployments.size());

        //查询流程定义
        List<ProcessDefinition> processDefinitions = repositoryService
                .createProcessDefinitionQuery()
                .orderByProcessDefinitionKey()
                .asc().listPage(0, 100);

        for (ProcessDefinition processDefinition : processDefinitions) {
            LOGGER.info("processDefinition = {},version = {},key = {},id = {}"
                    , processDefinition
                    , processDefinition.getVersion()
                    , processDefinition.getKey()
                    , processDefinition.getId());
        }
    }

}
