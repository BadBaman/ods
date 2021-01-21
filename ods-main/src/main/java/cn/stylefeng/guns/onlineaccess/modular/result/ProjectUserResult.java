package cn.stylefeng.guns.onlineaccess.modular.result;


import cn.stylefeng.guns.onlineaccess.modular.entity.Project;
import cn.stylefeng.guns.sys.modular.user.entity.SysUser;

import java.util.Date;
import java.util.List;

public class ProjectUserResult {

    /*
     *  项目用户关联id id
     * */
    private Long id;

    /*
     *  用户id id
     * */
    private Long userId;

    /*
     *  项目id id
     * */
    private Long projectId;

    /*
     *  项目用户关联状态 id
     * */
    private int status;

    /*
     *  项目用户关联类型 type
     * */
    private int type;

    /*
     *  一对多映射关联的用户列表 sysUser
     * */
    private SysUser userResult;

    private ProjectResult projectResult;

    public ProjectResult getProjectResult() {
        return projectResult;
    }

    public void setProjectResult(ProjectResult projectResult) {
        this.projectResult = projectResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public SysUser getUserResult() {
        return userResult;
    }

    public void setUserResult(SysUser userResult) {
        this.userResult = userResult;
    }
}
