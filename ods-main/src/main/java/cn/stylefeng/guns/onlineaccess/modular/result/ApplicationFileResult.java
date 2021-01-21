package cn.stylefeng.guns.onlineaccess.modular.result;

import cn.stylefeng.guns.sys.modular.file.entity.SysFileInfo;
import cn.stylefeng.guns.sys.modular.user.entity.SysUser;

import java.util.List;

public class ApplicationFileResult {

    /*
     *  申请表和文件关联id id
     * */
    private Long id;

    /*
     *  文件id id
     * */
    private Long fileId;

    /*
     *  申请id id
     * */
    private Long applicationId;

    /*
     *  项目用户关联状态 id
     * */
    private int status;

    /*
     *  项目用户关联类型 type
     * */
    private int type;

    /*
     *  一对多映射关联的文件列表 sysUser
     * */
    private List<SysFileInfo> sysFileInfoList;

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

    public List<SysFileInfo> getSysFileInfoList() {
        return sysFileInfoList;
    }

    public void setSysFileInfoList(List<SysFileInfo> sysFileInfoList) {
        this.sysFileInfoList = sysFileInfoList;
    }
}
