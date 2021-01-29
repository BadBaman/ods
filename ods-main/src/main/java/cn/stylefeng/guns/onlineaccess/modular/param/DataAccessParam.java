package cn.stylefeng.guns.onlineaccess.modular.param;

import cn.stylefeng.guns.core.pojo.base.entity.BaseEntity;
import cn.stylefeng.guns.core.pojo.base.param.BaseParam;
import cn.stylefeng.guns.core.validation.date.DateValue;
import cn.stylefeng.guns.sys.modular.emp.param.SysEmpParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;

public class DataAccessParam extends BaseEntity {

    /**
     * 主键
     */
    @NotNull
    private Long id;

    /**
     * 申请人
     */
    private Long applicantId;

    /**
     * 单位orgId
     */
    private Long orgId ;

    /**
     * 单位projectId
     */
    private Long projectId ;

    /**
     * 数据类别
     */
    private int dataTypeId;

    /**
     * 数据类型筛选原则
     */
    private String remark;

    /**
     * 课题名称
     */
    private String subjectName;

    /**
     * 关键字
     */
    private String subjectKeyword;

    /**
     * 主要参与人
     */

    private String projectParticipants;

    /**
     * 申请表文件
     */
    private MultipartFile file ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public int getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(int dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }


}
