package cn.stylefeng.guns.onlineaccess.modular.result;

public class ApplicationDataTypeResult {

    /*
     *  申请表和数据类型关联id id
     * */
    private Long id;

    /*
     *  数据类型id id
     * */
    private int dataTypeId;

    /*
     *  申请id id
     * */
    private Long applicationId;

    /*
     *  数据类型一对一映射结果 dataTypeResult
     * */
    private DataTypeResult dataTypeResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(int dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public DataTypeResult getDataTypeResult() {
        return dataTypeResult;
    }

    public void setDataTypeResult(DataTypeResult dataTypeResult) {
        this.dataTypeResult = dataTypeResult;
    }
}
