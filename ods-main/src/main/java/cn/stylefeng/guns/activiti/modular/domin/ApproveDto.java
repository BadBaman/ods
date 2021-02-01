package cn.stylefeng.guns.activiti.modular.domin;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * 审批信息
 */
@Data
public class ApproveDto {

    /**
     * 任务id
     */
    @NotNull
    String taskId;

    /**
     * 实例id
     */
    @NotNull
    String instanceId;

    /**
     * 是否同意
     */
    @NotNull
    Boolean isApprove;

    /**
     * 活动名称
     */
    @Null
    String activitiFlag;

    /**
     * 评论信息
     */
    @NotNull
    String comment;

}
