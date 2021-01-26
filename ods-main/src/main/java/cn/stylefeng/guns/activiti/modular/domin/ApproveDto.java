package cn.stylefeng.guns.activiti.modular.domin;

import lombok.Data;

/**
 * 审批信息
 */
@Data
public class ApproveDto {

    /**
     * 任务id
     */
    String taskId;

    /**
     * 实例id
     */
    String instanceId;

    /**
     * 是否同意
     */
    Boolean isApprove;

    /**
     * 活动名称
     */
    String activitiFlag;

    /**
     * 评论信息
     */
    String comment;

}
