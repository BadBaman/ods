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
package cn.stylefeng.guns.sys.modular.monitor.result;

import java.io.Serializable;
import java.util.Objects;

/**
 * 系统在线用户结果集
 *
 * @author xuyuxiang
 * @date 2020/4/7 17:07
 */
public class SysOnlineUserResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会话id
     */
    private String sessionId;

    /**
     * 账号
     */
    private String account;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 最后登陆IP
     */
    private String lastLoginIp;

    /**
     * 最后登陆时间
     */
    private String lastLoginTime;

    /**
     * 最后登陆地址
     */
    private String lastLoginAddress;

    /**
     * 最后登陆所用浏览器
     */
    private String lastLoginBrowser;

    /**
     * 最后登陆所用系统
     */
    private String lastLoginOs;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
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

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginAddress() {
        return lastLoginAddress;
    }

    public void setLastLoginAddress(String lastLoginAddress) {
        this.lastLoginAddress = lastLoginAddress;
    }

    public String getLastLoginBrowser() {
        return lastLoginBrowser;
    }

    public void setLastLoginBrowser(String lastLoginBrowser) {
        this.lastLoginBrowser = lastLoginBrowser;
    }

    public String getLastLoginOs() {
        return lastLoginOs;
    }

    public void setLastLoginOs(String lastLoginOs) {
        this.lastLoginOs = lastLoginOs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysOnlineUserResult that = (SysOnlineUserResult) o;
        return Objects.equals(sessionId, that.sessionId) &&
                Objects.equals(account, that.account) &&
                Objects.equals(nickName, that.nickName) &&
                Objects.equals(lastLoginIp, that.lastLoginIp) &&
                Objects.equals(lastLoginTime, that.lastLoginTime) &&
                Objects.equals(lastLoginAddress, that.lastLoginAddress) &&
                Objects.equals(lastLoginBrowser, that.lastLoginBrowser) &&
                Objects.equals(lastLoginOs, that.lastLoginOs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, account, nickName, lastLoginIp, lastLoginTime, lastLoginAddress, lastLoginBrowser, lastLoginOs);
    }

    @Override
    public String toString() {
        return "SysOnlineUserResult{" +
                "sessionId='" + sessionId + '\'' +
                ", account='" + account + '\'' +
                ", nickName='" + nickName + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", lastLoginAddress='" + lastLoginAddress + '\'' +
                ", lastLoginBrowser='" + lastLoginBrowser + '\'' +
                ", lastLoginOs='" + lastLoginOs + '\'' +
                '}';
    }
}
