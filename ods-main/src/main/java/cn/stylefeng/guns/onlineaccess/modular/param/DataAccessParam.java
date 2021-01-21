package cn.stylefeng.guns.onlineaccess.modular.param;

import cn.stylefeng.guns.core.pojo.base.param.BaseParam;
import cn.stylefeng.guns.core.validation.date.DateValue;
import cn.stylefeng.guns.sys.modular.emp.param.SysEmpParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;

public class DataAccessParam extends BaseParam {

    /**
     * 主键
     */
    @NotNull(message = "id不能为空，请检查id参数",
            groups = {edit.class, delete.class, detail.class, start.class,
                    stop.class, grantRole.class, grantData.class, updateInfo.class,
                    changeStatus.class})
    private Long id;

    /**
     * 申请人
     */
    @NotBlank(message = "申请人不能为空，请检查applicant参数", groups = {add.class, edit.class})
    private String applicant;

    /**
     * 手机
     */
    @NotNull(message = "手机号码不能为空，请检查phone参数", groups = {add.class, edit.class, updateInfo.class})
    @Size(min = 11, max = 11, message = "手机号码格式错误，请检查phone参数", groups = {add.class, edit.class, updateInfo.class})
    private String phonenumber ;

    /**
     * 单位名
     */
    @NotBlank(message = "姓名不能为空，请检查name参数", groups = {add.class, edit.class})
    private String unitname;


    /**
     * 邮箱
     */
    @Email(message = "邮箱格式错误，请检查email参数", groups = {updateInfo.class})
    private String email;



    /**
     * 数据类别
     */
    @NotNull(message = "数据类别不能为空，请检查grantRoleIdList参数", groups = {grantRole.class})
    private int datatype;

    /**
     * 课题名称
     */
    @NotNull(message = "课题名称不能为空，请检查grantRoleIdList参数", groups = {grantRole.class})
    private String taskname;

    /**
     * 关键字
     */
    @NotNull(message = "关键字不能为空，请检查grantOrgIdList参数", groups = {grantData.class})
    private String taskkey;

    /**
     * 主要参与人
     */

    @NotNull(message = "主要参与人不能为空，请检查grantOrgIdList参数", groups = {grantData.class})
    private String mainparticipants;

    /**
     * 申请表文件
     */
    @NotNull(message = "申请表文件不能为空，请检查grantOrgIdList参数", groups = grantData.class)
    private MultipartFile file ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public int getDatatype() {
        return datatype;
    }

    public void setDatatype(int datatype) {
        this.datatype = datatype;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskkey() {
        return taskkey;
    }

    public void setTaskkey(String taskkey) {
        this.taskkey = taskkey;
    }

    public String getMainparticipants() {
        return mainparticipants;
    }

    public void setMainparticipants(String mainparticipants) {
        this.mainparticipants = mainparticipants;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public DataAccessParam(@NotNull(message = "id不能为空，请检查id参数",
            groups = {edit.class, delete.class, detail.class, start.class,
                    stop.class, grantRole.class, grantData.class, updateInfo.class,
                    changeStatus.class}) Long id, @NotBlank(message = "申请人不能为空，请检查applicant参数", groups = {add.class, edit.class}) String applicant, @NotNull(message = "手机号码不能为空，请检查phone参数", groups = {add.class, edit.class, updateInfo.class}) @Size(min = 11, max = 11, message = "手机号码格式错误，请检查phone参数", groups = {add.class, edit.class, updateInfo.class}) String phonenumber, @NotBlank(message = "姓名不能为空，请检查name参数", groups = {add.class, edit.class}) String unitname, @Email(message = "邮箱格式错误，请检查email参数", groups = {updateInfo.class}) String email, @NotNull(message = "数据类别不能为空，请检查grantRoleIdList参数", groups = {grantRole.class}) int datatype, @NotNull(message = "课题名称不能为空，请检查grantRoleIdList参数", groups = {grantRole.class}) String taskname, @NotNull(message = "关键字不能为空，请检查grantOrgIdList参数", groups = {grantData.class}) String taskkey, @NotNull(message = "主要参与人不能为空，请检查grantOrgIdList参数", groups = {grantData.class}) String mainparticipants, @NotNull(message = "申请表文件不能为空，请检查grantOrgIdList参数", groups = grantData.class) MultipartFile file) {
        this.id = id;
        this.applicant = applicant;
        this.phonenumber = phonenumber;
        this.unitname = unitname;
        this.email = email;
        this.datatype = datatype;
        this.taskname = taskname;
        this.taskkey = taskkey;
        this.mainparticipants = mainparticipants;
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DataAccessParam that = (DataAccessParam) o;
        return datatype == that.datatype &&
                Objects.equals(id, that.id) &&
                Objects.equals(applicant, that.applicant) &&
                Objects.equals(phonenumber, that.phonenumber) &&
                Objects.equals(unitname, that.unitname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(taskname, that.taskname) &&
                Objects.equals(taskkey, that.taskkey) &&
                Objects.equals(mainparticipants, that.mainparticipants) &&
                Objects.equals(file, that.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, applicant, phonenumber, unitname, email, datatype, taskname, taskkey, mainparticipants, file);
    }
}
