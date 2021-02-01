package cn.stylefeng.guns.activiti.modular.domin;

import org.activiti.engine.impl.persistence.entity.HistoricActivityInstanceEntityImpl;

/**
 * 历史审批类
 * 继承自 历史活动实例实体
 */
public class HistoricActivity extends HistoricActivityInstanceEntityImpl {

    /** 审批批注 */
    private String comment;

    /** 办理人姓名 */
    private String assigneeName;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    @Override
    public String toString() {
        return "HistoricActivity{" +
                "comment='" + comment + '\'' +
                ", assigneeName='" + assigneeName + '\'' +
                '}';
    }
}
