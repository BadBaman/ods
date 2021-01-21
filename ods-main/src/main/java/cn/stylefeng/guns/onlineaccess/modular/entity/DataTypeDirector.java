package cn.stylefeng.guns.onlineaccess.modular.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Generated;

@TableName("data_type_director")
public class DataTypeDirector {

    /**
     * 主键 id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @Generated
    private int id;

    /**
     * 数据类型id dataTypeId
     */
    private int dataTypeId;

    /**
     * 用户id userId
     */
    private Long userId;

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
}
