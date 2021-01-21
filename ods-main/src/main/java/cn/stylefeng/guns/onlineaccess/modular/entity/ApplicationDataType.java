package cn.stylefeng.guns.onlineaccess.modular.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Generated;

@TableName("application_data_type")
public class ApplicationDataType {

    /**
     * 主键 id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @Generated
    private Long id;

    /**
     * 数据类型id dataTypeId
     */
    private int dataTypeId;

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
}
