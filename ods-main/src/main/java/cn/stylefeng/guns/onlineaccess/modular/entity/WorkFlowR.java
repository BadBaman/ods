package cn.stylefeng.guns.onlineaccess.modular.entity;

import cn.stylefeng.guns.onlineaccess.modular.result.ApplicationResult;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("workflow_r")
public class WorkFlowR {

    /*
     *  申请id id
     * */
    private Long id;

    /*
     *  状态 status
     * */
    private int status;

    /*
     *  申请人id applicant
     * */
    private Long applicationId;


    /*
     *  proc id procId
     * */
    private String procId;

    /*
     *  当前任务 currentTask
     * */
    private String currentTask;

    /*
     *  申请结果一对一映射 applicationResult
     * */
    private ApplicationResult applicationResult;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getProcId() {
        return procId;
    }

    public void setProcId(String procId) {
        this.procId = procId;
    }

    public String getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(String currentTask) {
        this.currentTask = currentTask;
    }

    public ApplicationResult getApplicationResult() {
        return applicationResult;
    }

    public void setApplicationResult(ApplicationResult applicationResult) {
        this.applicationResult = applicationResult;
    }

    @Override
    public String toString() {
        return "WorkFlowR{" +
                "id=" + id +
                ", status=" + status +
                ", applicationId=" + applicationId +
                ", procId='" + procId + '\'' +
                ", currentTask='" + currentTask + '\'' +
                ", applicationResult=" + applicationResult +
                '}';
    }
}
