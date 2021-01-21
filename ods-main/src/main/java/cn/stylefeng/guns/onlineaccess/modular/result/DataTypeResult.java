package cn.stylefeng.guns.onlineaccess.modular.result;

import cn.stylefeng.guns.onlineaccess.modular.entity.Project;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


public class DataTypeResult {

    /*
     *  数据类型id id
     * */
    private int id;

    /*
     *  数据类型名称 name
     * */
    private String name;

    /*
     *  组织id orgId
     * */
    private Long orgId;

    /*
     *  邮箱 email
     * */
    private String email;

    /*
     *  数据负责人 dataManager
     * */
    private String dataManager;

    /*
     *  项目id projectId
     * */
    private long projectId;


    /*
     *  项目一对一映射 projectResult
     * */
    private ProjectResult projectResult;


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

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
