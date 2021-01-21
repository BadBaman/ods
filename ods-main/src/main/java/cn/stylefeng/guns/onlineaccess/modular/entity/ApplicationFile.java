package cn.stylefeng.guns.onlineaccess.modular.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Generated;

@TableName("application_file")
public class ApplicationFile {

    /**
     * 主键 id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @Generated
    private Long id;

    /**
     * 文件id fileId
     */
    private Long fileId;


    /**
     * 申请id applicationId
     */
    private Long applicationId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }
}
