package cn.stylefeng.guns.onlineaccess.modular.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.NoArgsConstructor;

@TableName("data_type")
@Builder
@AllArgsConstructor //全参构造函数
@NoArgsConstructor
public class DataType {

    /**
     * 主键 id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @Generated
    private int id;

    /**
     * 数据类型名称 dataTypeName
     */
    private String name;

    /**
     * 组织id dataTypeOrgId
     */
    private Long orgId;

    /**
     * 邮箱 dataTypeEmail
     */
    private String email;

    /**
     * 数据负责人 dataTypeDataManager
     */
    private String dataManager;
    /**
     * 项目id dataTypeProjectId
     */
    private Long projectId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataManager() {
        return dataManager;
    }

    public void setDataManager(String dataManager) {
        this.dataManager = dataManager;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }


}
