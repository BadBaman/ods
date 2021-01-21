package cn.stylefeng.guns.onlineaccess.modular.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Generated;

@TableName("project_user")
public class ProjectUser {

    /**
     * 主键 id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @Generated
    private Long id;

    /**
     * 用户id userId
     */
    private Long userId;

    /**
     * 项目id projectId
     */
    private Long projectId;

    /**
     * 类型 type
     */
    private int type;

    /**
     * 状态 status
     */
    private int status;


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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
