package cn.stylefeng.guns.onlineaccess.modular.result;

import cn.stylefeng.guns.sys.modular.user.entity.SysUser;
import cn.stylefeng.guns.sys.modular.user.result.DataCoordinatorResult;

import java.util.Date;

public class ProjectResult {

    /*
     *  项目id id
     * */
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
    private String status;

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

    /*
     *  项目用户关联信息 projectUserResult
     * */
    private ProjectUserResult projectUserResult;

    public Long getId() {
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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectUserResult getProjectUserResult() {
        return projectUserResult;
    }

    public void setProjectUserResult(ProjectUserResult projectUserResult) {
        this.projectUserResult = projectUserResult;
    }
}
