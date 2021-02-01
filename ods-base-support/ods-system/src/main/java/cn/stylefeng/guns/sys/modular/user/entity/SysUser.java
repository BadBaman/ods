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
package cn.stylefeng.guns.sys.modular.user.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.stylefeng.guns.core.pojo.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.util.Objects;

/**
 * 系统用户表
 *
 * @author xuyuxiang
 * @date 2020/3/5 12:25
 */
@TableName("sys_user")
public class SysUser extends BaseEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 账号
     */
    @Excel(name = "账号", width = 20)
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    @Excel(name = "昵称", width = 20)
    private String nickName;

    /**
     * 姓名
     */
    @Excel(name = "姓名", width = 20)
    private String name;

    /**
     * 头像
     */
    private Long avatar;

    /**
     * 生日
     */
    @Excel(name = "生日", databaseFormat = "yyyy-MM-dd HH:mm:ss", format = "yyyy-MM-dd", width = 20)
    private Date birthday;

    /**
     * 性别(字典 1男 2女 3未知)
     */
    @Excel(name = "性别", replace = {"男_1", "女_2"}, width = 20)
    private Integer sex;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱", width = 30)
    private String email;

    /**
     * 手机
     */
    @Excel(name = "手机", width = 30)
    private String phone;

    /**
     * 电话
     */
    @Excel(name = "电话", width = 30)
    private String tel;

    /**
     * 最后登陆IP
     */
    @Excel(name = "最后登陆IP", width = 30)
    private String lastLoginIp;

    /**
     * 最后登陆时间
     */
    @Excel(name = "最后登陆时间", databaseFormat = "yyyy-MM-dd HH:mm:ss", format = "yyyy-MM-dd HH:mm:ss", width = 30)
    private Date lastLoginTime;

    /**
     * 管理员类型（1超级管理员 2非管理员）
     */
    @Excel(name = "管理员类型", replace = {"超级管理员_1", "非管理员_2"}, width = 20)
    private Integer adminType;

    /**
     * 状态（字典 0正常 1停用 2删除）
     */
    @Excel(name = "状态", replace = {"正常_0", "停用_1", "删除_2"}, width = 20)
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

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getAdminType() {
        return adminType;
    }

    public void setAdminType(Integer adminType) {
        this.adminType = adminType;
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
        SysUser sysUser = (SysUser) o;
        return Objects.equals(id, sysUser.id) &&
                Objects.equals(account, sysUser.account) &&
                Objects.equals(password, sysUser.password) &&
                Objects.equals(nickName, sysUser.nickName) &&
                Objects.equals(name, sysUser.name) &&
                Objects.equals(avatar, sysUser.avatar) &&
                Objects.equals(birthday, sysUser.birthday) &&
                Objects.equals(sex, sysUser.sex) &&
                Objects.equals(email, sysUser.email) &&
                Objects.equals(phone, sysUser.phone) &&
                Objects.equals(tel, sysUser.tel) &&
                Objects.equals(lastLoginIp, sysUser.lastLoginIp) &&
                Objects.equals(lastLoginTime, sysUser.lastLoginTime) &&
                Objects.equals(adminType, sysUser.adminType) &&
                Objects.equals(status, sysUser.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, account, password, nickName, name, avatar, birthday, sex, email, phone, tel, lastLoginIp, lastLoginTime, adminType, status);
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", avatar=" + avatar +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", adminType=" + adminType +
                ", status=" + status +
                '}';
    }
}
