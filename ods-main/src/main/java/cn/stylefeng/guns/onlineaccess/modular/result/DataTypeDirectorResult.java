package cn.stylefeng.guns.onlineaccess.modular.result;

import cn.stylefeng.guns.sys.modular.user.entity.SysUser;

public class DataTypeDirectorResult {

    /*
     *  数据类型负责人id id
     * */
    private int id;

    /*
     *  数据类型id dataTypeId
     * */
    private int dataTypeId;

    /*
     *  用户id userId
     * */
    private Long userId;

    /*
     *  数据类型一对一映射结果 dataTypeResult
     * */
    private DataTypeResult dataTypeResult;

    /*
     *  用户一对一映射结果 sysUser
     * */
    private SysUser sysUser;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(int dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public DataTypeResult getDataTypeResult() {
        return dataTypeResult;
    }

    public void setDataTypeResult(DataTypeResult dataTypeResult) {
        this.dataTypeResult = dataTypeResult;
    }
}
