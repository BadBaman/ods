package cn.stylefeng.guns.onlineaccess.modular.entity;

import cn.stylefeng.guns.core.pojo.base.entity.BaseEntity;
import cn.stylefeng.guns.sys.modular.user.entity.SysUser;
import cn.stylefeng.guns.sys.modular.user.result.SysUserResult;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.util.Objects;

@TableName("project")
public class Project {

    /*
     *  项目id id
     * */
    @TableId
    private Long id;

    /*
     *  项目名称 name
     * */
    private String name;

    /*
     *  项目描述 description
     * */
    private String description;

    /*
     *  状态 status
     * */
    private int status;


    /*
     *  创建时间 createTime
     * */
    private Date createTime;

    /*
     *  发表文章数 articleNum
     * */
    private int articleNum;

    /*
     *  申请次数 applyNum
     * */
    private int applyNum;


    /*
     *  批准次数 approvalNum
     * */
    private int approvalNum;

    /*
     *  申请访问次数 visitNum
     * */
    private int visitNum;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    public int getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(int applyNum) {
        this.applyNum = applyNum;
    }

    public int getApprovalNum() {
        return approvalNum;
    }

    public void setApprovalNum(int approvalNum) {
        this.approvalNum = approvalNum;
    }

    public int getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(int visitNum) {
        this.visitNum = visitNum;
    }

    public Project() {
    }

    public Project(long id, String name, String description, int status, Date createTime, int articleNum, int applyNum, int approvalNum, int visitNum) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.createTime = createTime;
        this.articleNum = articleNum;
        this.applyNum = applyNum;
        this.approvalNum = approvalNum;
        this.visitNum = visitNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id &&
                articleNum == project.articleNum &&
                applyNum == project.applyNum &&
                approvalNum == project.approvalNum &&
                visitNum == project.visitNum &&
                Objects.equals(name, project.name) &&
                Objects.equals(description, project.description) &&
                Objects.equals(status, project.status) &&
                Objects.equals(createTime, project.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, status, createTime, articleNum, applyNum, approvalNum, visitNum);
    }
}
