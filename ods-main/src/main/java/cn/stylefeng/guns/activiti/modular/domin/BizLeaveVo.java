package cn.stylefeng.guns.activiti.modular.domin;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

@Data
public class BizLeaveVo extends BizLeave {

    /** 申请人姓名 */
    private String applyUserName;

    /** 任务ID */
    private String taskId;

    /** 任务名称 */
    private String taskName;

    /** 办理时间 */
    private Date doneTime;

    /** 创建人 */
    private String createUserName;

    /** 流程实例状态 1 激活 2 挂起 */
    private String suspendState;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("type", getType())
                .append("title", getTitle())
                .append("reason", getReason())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("totalTime", getTotalTime())
                .append("instanceId", getInstanceId())
                .append("createBy", getCreateUser())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateUser())
                .append("updateTime", getUpdateTime())
                .append("applyUser", getApplyUser())
                .append("applyTime", getApplyTime())
                .append("taskId", getTaskId())
                .append("taskName", getTaskName())
                .toString();
    }
}
