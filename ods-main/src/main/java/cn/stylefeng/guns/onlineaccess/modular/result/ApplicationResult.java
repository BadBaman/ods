package cn.stylefeng.guns.onlineaccess.modular.result;

import cn.stylefeng.guns.onlineaccess.modular.entity.WorkFlowR;
import cn.stylefeng.guns.sys.modular.org.entity.SysOrg;
import cn.stylefeng.guns.sys.modular.user.entity.SysUser;

import java.util.Date;
import java.util.List;

public class ApplicationResult {

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
    private Long applicantId;

    /*
     *  组织id orgId
     * */
    private Long orgId;

    /*
     *  申请时间 createdTime
     * */
    private Date createdTime;

    /*
     *  课题名称 subjectName
     * */
    private String subjectName;

    /*
     *  课题关键字 subjectKeyword
     * */
    private String subjectKeyword;

    /*
     *  项目参与人 projectParticipants
     * */
    private String projectParticipants;

    /*
     *  申请表和文件一对一映射信息 applicationFileResult
     * */
    private ApplicationFileResult applicationFileResult;


    /*
     *  申请和数据类型一对多映射信息 applicationDataTypeResultList
     * */
    private List<ApplicationDataTypeResult> applicationDataTypeResultList;





    public List<ApplicationDataTypeResult> getApplicationDataTypeResultList() {
        return applicationDataTypeResultList;
    }

    public void setApplicationDataTypeResultList(List<ApplicationDataTypeResult> applicationDataTypeResultList) {
        this.applicationDataTypeResultList = applicationDataTypeResultList;
    }

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

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectKeyword() {
        return subjectKeyword;
    }

    public void setSubjectKeyword(String subjectKeyword) {
        this.subjectKeyword = subjectKeyword;
    }

    public String getProjectParticipants() {
        return projectParticipants;
    }

    public void setProjectParticipants(String projectParticipants) {
        this.projectParticipants = projectParticipants;
    }

    public ApplicationFileResult getApplicationFileResult() {
        return applicationFileResult;
    }

    public void setApplicationFileResult(ApplicationFileResult applicationFileResult) {
        this.applicationFileResult = applicationFileResult;
    }

}
