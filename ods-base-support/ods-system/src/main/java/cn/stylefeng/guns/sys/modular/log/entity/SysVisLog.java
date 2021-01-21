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
package cn.stylefeng.guns.sys.modular.log.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;

/**
 * 系统访问日志表
 *
 * @author xuyuxiang
 * @date 2020/3/11 11:56
 */
@TableName("sys_vis_log")
public class SysVisLog {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 是否执行成功（Y-是，N-否）
     */
    private String success;

    /**
     * 具体消息
     */
    private String message;

    /**
     * ip
     */
    private String ip;

    /**
     * 地址
     */
    private String location;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 访问类型（字典 1登入 2登出）
     */
    private Integer visType;

    /**
     * 访问时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date visTime;

    /**
     * 访问人
     */
    private String account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Integer getVisType() {
        return visType;
    }

    public void setVisType(Integer visType) {
        this.visType = visType;
    }

    public Date getVisTime() {
        return visTime;
    }

    public void setVisTime(Date visTime) {
        this.visTime = visTime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysVisLog sysVisLog = (SysVisLog) o;
        return Objects.equals(id, sysVisLog.id) &&
                Objects.equals(name, sysVisLog.name) &&
                Objects.equals(success, sysVisLog.success) &&
                Objects.equals(message, sysVisLog.message) &&
                Objects.equals(ip, sysVisLog.ip) &&
                Objects.equals(location, sysVisLog.location) &&
                Objects.equals(browser, sysVisLog.browser) &&
                Objects.equals(os, sysVisLog.os) &&
                Objects.equals(visType, sysVisLog.visType) &&
                Objects.equals(visTime, sysVisLog.visTime) &&
                Objects.equals(account, sysVisLog.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, success, message, ip, location, browser, os, visType, visTime, account);
    }

    @Override
    public String toString() {
        return "SysVisLog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", success='" + success + '\'' +
                ", message='" + message + '\'' +
                ", ip='" + ip + '\'' +
                ", location='" + location + '\'' +
                ", browser='" + browser + '\'' +
                ", os='" + os + '\'' +
                ", visType=" + visType +
                ", visTime=" + visTime +
                ", account='" + account + '\'' +
                '}';
    }
}
