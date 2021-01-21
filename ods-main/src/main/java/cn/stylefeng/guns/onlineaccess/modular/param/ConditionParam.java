package cn.stylefeng.guns.onlineaccess.modular.param;

import cn.stylefeng.guns.core.pojo.base.param.BaseParam;

import java.util.Objects;

public class ConditionParam extends BaseParam {
    /**
     * 课题名称    Example:'人类调查'
     */
    private String taskname ;//:


    /**
     * 数据申请人  Example: '李媛媛'
     */
    private String applicant ;

    /**
     * 状态       Example: 审批中’
     */
    private String status ;

    /**
     * 开始日期    Example:‘2019-09-08‘
     */
    private String startdate ;

    /**
     * 结束日期    Example:‘2019-10-08‘
     */
    private String enddate ;
    /**
     * 项目ID     Example:1
     */
    private long proid;

    /**
     * 用户名     Example:‘111’
     */
    private String username;

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public long getProid() {
        return proid;
    }

    public void setProid(long proid) {
        this.proid = proid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ConditionParam(String taskname, String applicant, String status, String startdate, String enddate, long proid, String username) {
        this.taskname = taskname;
        this.applicant = applicant;
        this.status = status;
        this.startdate = startdate;
        this.enddate = enddate;
        this.proid = proid;
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ConditionParam that = (ConditionParam) o;
        return status == that.status &&
                proid == that.proid &&
                Objects.equals(taskname, that.taskname) &&
                Objects.equals(applicant, that.applicant) &&
                Objects.equals(startdate, that.startdate) &&
                Objects.equals(enddate, that.enddate) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), taskname, applicant, status, startdate, enddate, proid, username);
    }
}
