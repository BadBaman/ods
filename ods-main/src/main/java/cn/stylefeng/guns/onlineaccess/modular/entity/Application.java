package cn.stylefeng.guns.onlineaccess.modular.entity;

import cn.stylefeng.guns.core.pojo.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Generated;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Objects;

@TableName("application")
public class Application {

    /**
     * 主键 id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @Generated
    private Long id;

    /**
     * 状态 status
     */
    private int status;

    /**
     * 申请人id applicantId
     */
    private Long applicantId;

    /**
     * 组织id orgId
     */
    private Long orgId;

    /**
     * 创建时间 createdTime
     */
    private Date createdTime;

    /**
     * 课题名 subjectName
     */
    private String subjectName;

    /**
     * 课题关键字 subjectKeyword
     */
    private String subjectKeyword;


    /**
     * 项目主要参与人 projectParticipants
     */
    private String projectParticipants;

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

    public Application() {
    }

    public Application(Long id, int status, Long applicantId, Long orgId, Date createdTime, String subjectName, String subjectKeyword, String projectParticipants) {
        this.id = id;
        this.status = status;
        this.applicantId = applicantId;
        this.orgId = orgId;
        this.createdTime = createdTime;
        this.subjectName = subjectName;
        this.subjectKeyword = subjectKeyword;
        this.projectParticipants = projectParticipants;
    }

}
