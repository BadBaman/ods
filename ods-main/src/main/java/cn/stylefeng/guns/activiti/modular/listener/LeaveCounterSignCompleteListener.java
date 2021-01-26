package cn.stylefeng.guns.activiti.modular.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 请假会签任务监听器，当会签任务完成时统计同意的数量
 *
 * @author henryyan
 */
@Component
public class LeaveCounterSignCompleteListener implements TaskListener {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(LeaveCounterSignCompleteListener.class);

    @Override
    public void notify(DelegateTask delegateTask) {
        Boolean approved = (Boolean) delegateTask.getVariable("approved");
        logger.info("会签监听器 approved = {}", approved);

        Long signedCounter = (Long) delegateTask.getVariable("signedCounter");
        logger.info("会签监听器 signedCounter = {}", signedCounter);
        delegateTask.setVariable("signedCounter", signedCounter + 1);
    }

}
