package cn.stylefeng.guns.onlineaccess.modular.result;

import cn.stylefeng.guns.onlineaccess.modular.entity.Application;
import cn.stylefeng.guns.sys.modular.emp.result.SysEmpInfo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class UserResult {

    /**
     * 主键 id
     */
    private Long id;

    /**
     * 账号 account
     */
    private String account;

    /**
     * 昵称 nickName
     */
    private String nickName;

    /**
     * 姓名 name
     */
    private String name;

    /**
     * 头像 avatar
     */
    private Long avatar;

    /**
     * 生日 birthday
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 性别(字典 1男 2女 3未知) sex
     */
    private Integer sex;

    /**
     * 邮箱 email
     */
    private String email;

    /**
     * 手机 phone
     */
    private String phone;

    /**
     * 电话 tel
     */
    private String tel;


    /**
     * 申请和用户一对一映射 applicationResult
     */
    private List<ApplicationResult> applicationResultList;

    /**
     * 数据负责人一对一映射结果 dataTypeDirectorResultList
     */
    private List<DataTypeDirectorResult> dataTypeDirectorResultList;

    /**
     * 项目用户一对多映射结果 projectUserResultList
     */
    private List<ProjectUserResult> projectUserResultList;

    /**
     * 状态（字典 0正常 1停用 2删除） status
     */
    private Integer status;

    public List<ApplicationResult> getApplicationResultList() {
        return applicationResultList;
    }

    public void setApplicationResultList(List<ApplicationResult> applicationResultList) {
        this.applicationResultList = applicationResultList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAvatar() {
        return avatar;
    }

    public void setAvatar(Long avatar) {
        this.avatar = avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<DataTypeDirectorResult> getDataTypeDirectorResultList() {
        return dataTypeDirectorResultList;
    }

    public void setDataTypeDirectorResultList(List<DataTypeDirectorResult> dataTypeDirectorResultList) {
        this.dataTypeDirectorResultList = dataTypeDirectorResultList;
    }

    public List<ProjectUserResult> getProjectUserResultList() {
        return projectUserResultList;
    }

    public void setProjectUserResultList(List<ProjectUserResult> projectUserResultList) {
        this.projectUserResultList = projectUserResultList;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
