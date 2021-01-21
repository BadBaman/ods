package cn.stylefeng.guns.onlineaccess.modular.param;

import cn.stylefeng.guns.core.pojo.base.param.BaseParam;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ProjectParam extends BaseParam {

    /**
     * 主键
     */
    @NotNull(message = "id不能为空，请检查id参数",
            groups = {edit.class, delete.class, detail.class, start.class,
                    stop.class, grantRole.class, grantData.class, updateInfo.class,
                    changeStatus.class})
    private Long id;

    /**
     * 项目名
     */
    @NotNull(message = "name不能为空，请检查name参数",
            groups = {edit.class, delete.class, detail.class, start.class,
                    stop.class, grantRole.class, grantData.class, updateInfo.class,
                    changeStatus.class})
    private String name;

    /**
     * 项目主页
     */
    @NotNull(message = "url不能为空，请检查url参数",
            groups = {edit.class, delete.class, detail.class, start.class,
                    stop.class, grantRole.class, grantData.class, updateInfo.class,
                    changeStatus.class})
    private String url;

    /**
     * 项目简介
     */
    @NotNull(message = "description不能为空，请检查description参数",
            groups = {edit.class, delete.class, detail.class, start.class,
                    stop.class, grantRole.class, grantData.class, updateInfo.class,
                    changeStatus.class})
    private String description;

    /**
     * 可访问的数据类型
     */
    @NotNull(message = "datatypedetails不能为空，请检查datatypedetails参数",
            groups = {edit.class, delete.class, detail.class, start.class,
                    stop.class, grantRole.class, grantData.class, updateInfo.class,
                    changeStatus.class})
    private String datatypedetails;

    /**
     * 项目秘书名
     */
    @NotNull(message = "projectSecretaryId不能为空，请检查projectSecretaryId参数",
            groups = {edit.class, delete.class, detail.class, start.class,
                    stop.class, grantRole.class, grantData.class, updateInfo.class,
                    changeStatus.class})
    private long projectSecretaryId;

    /**
     * 项目协调员名
     */
    @NotNull(message = "dataCoordinatorId不能为空，请检查dataCoordinatorId参数",
            groups = {edit.class, delete.class, detail.class, start.class,
                    stop.class, grantRole.class, grantData.class, updateInfo.class,
                    changeStatus.class})
    private long dataCoordinatorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatatypedetails() {
        return datatypedetails;
    }

    public void setDatatypedetails(String datatypedetails) {
        this.datatypedetails = datatypedetails;
    }

    public long getProjectSecretaryId() {
        return projectSecretaryId;
    }

    public void setProjectSecretaryId(long projectSecretaryId) {
        this.projectSecretaryId = projectSecretaryId;
    }

    public long getDataCoordinatorId() {
        return dataCoordinatorId;
    }

    public void setDataCoordinatorId(long dataCoordinatorId) {
        this.dataCoordinatorId = dataCoordinatorId;
    }

    public ProjectParam() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProjectParam that = (ProjectParam) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(url, that.url) &&
                Objects.equals(description, that.description) &&
                Objects.equals(datatypedetails, that.datatypedetails) &&
                Objects.equals(projectSecretaryId, that.projectSecretaryId) &&
                Objects.equals(dataCoordinatorId, that.dataCoordinatorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, name, url, description, datatypedetails, projectSecretaryId, dataCoordinatorId);
    }
}
