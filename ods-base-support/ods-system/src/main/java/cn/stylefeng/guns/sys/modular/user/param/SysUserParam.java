/*
Copyright [2020] [https://www.stylefeng.cn]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Guns采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：

1.请不要删除和修改根目录下的LICENSE文件。
2.请不要删除和修改Guns源码头部的版权声明。
3.请保留源码和相关描述文件的项目出处，作者声明等。
4.分发源码时候，请注明软件出处 https://gitee.com/stylefeng/guns-separation
5.在修改包名，模块名称，项目代码等时，请注明软件出处 https://gitee.com/stylefeng/guns-separation
6.若您的项目无法满足以上几点，可申请商业授权，获取Guns商业授权许可，请在官网购买授权，地址为 https://www.stylefeng.cn
 */
package cn.stylefeng.guns.sys.modular.user.param;

import cn.stylefeng.guns.core.pojo.base.param.BaseParam;
import cn.stylefeng.guns.core.validation.date.DateValue;
import cn.stylefeng.guns.sys.modular.emp.param.SysEmpParam;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;

/**
 * 系统用户参数
 *
 * @author xuyuxiang
 * @date 2020/3/23 9:21
 */
public class SysUserParam extends BaseParam {

    /**
     * 主键
     */
    @NotNull(message = "id不能为空，请检查id参数",
            groups = {edit.class, delete.class, detail.class, start.class,
                    stop.class, grantRole.class, grantData.class, updateInfo.class,
                    updatePwd.class, resetPwd.class, changeStatus.class, updateAvatar.class})
    private Long id;

    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空，请检查account参数", groups = {add.class, edit.class})
    private String account;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空，请检查password参数", groups = {updatePwd.class})
    private String password;

    /**
     * 新密码
     */
    @NotBlank(message = "新密码不能为空，请检查newPassword参数", groups = {updatePwd.class})
    private String newPassword;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空，请检查name参数", groups = {add.class, edit.class})
    private String name;

    /**
     * 头像
     */
    @NotNull(message = "头像不能为空，请检查avatar参数", groups = {updateAvatar.class})
    private Long avatar;

    /**
     * 生日
     */
    @DateValue(message = "生日格式不正确，请检查birthday参数", groups = {add.class, edit.class, updateInfo.class})
    private String birthday;

    /**
     * 性别(字典 1男 2女)
     */
    @NotNull(message = "性别不能为空，请检查sex参数", groups = {updateInfo.class})
    @Min(value = 1, message = "性别格式错误，请检查sex参数", groups = {updateInfo.class})
    @Max(value = 2, message = "性别格式错误，请检查sex参数", groups = {updateInfo.class})
    private Integer sex;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式错误，请检查email参数", groups = {updateInfo.class})
    private String email;

    /**
     * 手机
     */
    @NotNull(message = "手机号码不能为空，请检查phone参数", groups = {add.class, edit.class, updateInfo.class})
    @Size(min = 11, max = 11, message = "手机号码格式错误，请检查phone参数", groups = {add.class, edit.class, updateInfo.class})
    private String phone;

    /**
     * 电话
     */
    private String tel;

    /**
     * 授权角色
     */
    @NotNull(message = "授权角色不能为空，请检查grantRoleIdList参数", groups = {grantRole.class})
    private List<Long> grantRoleIdList;

    /**
     * 授权数据
     */
    @NotNull(message = "授权数据不能为空，请检查grantOrgIdList参数", groups = {grantData.class})
    private List<Long> grantOrgIdList;

    /*==============员工相关信息==========*/

    @NotNull(message = "员工信息不能为空，请检查sysEmpParam参数", groups = {add.class, edit.class})
    @Valid
    private SysEmpParam sysEmpParam;

    /**
     * 状态（字典 0正常 1停用 2删除）
     */
    @NotNull(message = "状态不能为空，请检查status参数", groups = changeStatus.class)
    private Integer status;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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

    public List<Long> getGrantRoleIdList() {
        return grantRoleIdList;
    }

    public void setGrantRoleIdList(List<Long> grantRoleIdList) {
        this.grantRoleIdList = grantRoleIdList;
    }

    public List<Long> getGrantOrgIdList() {
        return grantOrgIdList;
    }

    public void setGrantOrgIdList(List<Long> grantOrgIdList) {
        this.grantOrgIdList = grantOrgIdList;
    }

    public SysEmpParam getSysEmpParam() {
        return sysEmpParam;
    }

    public void setSysEmpParam(SysEmpParam sysEmpParam) {
        this.sysEmpParam = sysEmpParam;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysUserParam that = (SysUserParam) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(account, that.account) &&
                Objects.equals(password, that.password) &&
                Objects.equals(newPassword, that.newPassword) &&
                Objects.equals(nickName, that.nickName) &&
                Objects.equals(name, that.name) &&
                Objects.equals(avatar, that.avatar) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(grantRoleIdList, that.grantRoleIdList) &&
                Objects.equals(grantOrgIdList, that.grantOrgIdList) &&
                Objects.equals(sysEmpParam, that.sysEmpParam) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, account, password, newPassword, nickName, name, avatar, birthday, sex, email, phone, tel, grantRoleIdList, grantOrgIdList, sysEmpParam, status);
    }
}
