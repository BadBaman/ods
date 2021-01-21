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
package cn.stylefeng.guns.sys.modular.notice.result;

import java.util.Date;
import java.util.Objects;

/**
 * 已收系统通知公告结果集
 *
 * @author xuyuxiang
 * @date 2020/6/29 12:20
 */
public class SysNoticeReceiveResult {

    /**
     * 主键
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 类型（字典 1通知 2公告）
     */
    private Integer type;

    /**
     * 发布人id
     */
    private Long publicUserId;

    /**
     * 发布人姓名
     */
    private String publicUserName;

    /**
     * 发布机构id
     */
    private Long publicOrgId;

    /**
     * 发布机构名称
     */
    private String publicOrgName;

    /**
     * 发布时间
     */
    private Date publicTime;

    /**
     * 撤回时间
     */
    private Date cancelTime;

    /**
     * 状态（字典 0草稿 1发布 2撤回 3删除）
     */
    private Integer status;

    /**
     * 阅读状态（字典 0未读 1已读）
     */
    private Integer readStatus;

    /**
     * 阅读时间
     */
    private Date readTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getPublicUserId() {
        return publicUserId;
    }

    public void setPublicUserId(Long publicUserId) {
        this.publicUserId = publicUserId;
    }

    public String getPublicUserName() {
        return publicUserName;
    }

    public void setPublicUserName(String publicUserName) {
        this.publicUserName = publicUserName;
    }

    public Long getPublicOrgId() {
        return publicOrgId;
    }

    public void setPublicOrgId(Long publicOrgId) {
        this.publicOrgId = publicOrgId;
    }

    public String getPublicOrgName() {
        return publicOrgName;
    }

    public void setPublicOrgName(String publicOrgName) {
        this.publicOrgName = publicOrgName;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysNoticeReceiveResult that = (SysNoticeReceiveResult) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(type, that.type) &&
                Objects.equals(publicUserId, that.publicUserId) &&
                Objects.equals(publicUserName, that.publicUserName) &&
                Objects.equals(publicOrgId, that.publicOrgId) &&
                Objects.equals(publicOrgName, that.publicOrgName) &&
                Objects.equals(publicTime, that.publicTime) &&
                Objects.equals(cancelTime, that.cancelTime) &&
                Objects.equals(status, that.status) &&
                Objects.equals(readStatus, that.readStatus) &&
                Objects.equals(readTime, that.readTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, type, publicUserId, publicUserName, publicOrgId, publicOrgName, publicTime, cancelTime, status, readStatus, readTime);
    }

    @Override
    public String toString() {
        return "SysNoticeReceiveResult{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", publicUserId=" + publicUserId +
                ", publicUserName='" + publicUserName + '\'' +
                ", publicOrgId=" + publicOrgId +
                ", publicOrgName='" + publicOrgName + '\'' +
                ", publicTime=" + publicTime +
                ", cancelTime=" + cancelTime +
                ", status=" + status +
                ", readStatus=" + readStatus +
                ", readTime=" + readTime +
                '}';
    }
}
