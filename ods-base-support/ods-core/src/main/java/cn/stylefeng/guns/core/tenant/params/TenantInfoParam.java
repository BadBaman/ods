package cn.stylefeng.guns.core.tenant.params;

import cn.stylefeng.guns.core.pojo.base.param.BaseParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 租户表
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-16
 */
public class TenantInfoParam extends BaseParam {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @NotNull(message = "id不能为空，请检查id参数", groups = {edit.class, delete.class, detail.class})
    private Long id;

    /**
     * 租户名称
     */
    @NotBlank(message = "租户名称不能为空，请检查name参数", groups = {add.class, edit.class})
    private String name;

    /**
     * 租户的编码
     */
    @NotBlank(message = "租户的编码不能为空，请检查code参数", groups = {add.class, edit.class})
    private String code;

    /**
     * 租户管理员账号
     */
    @NotBlank(message = "租户管理员账号不能为空，请检查adminUsername参数", groups = {add.class})
    private String adminUsername;

    /**
     * 租户管理员密码
     */
    @NotBlank(message = "租户管理员账号不能为空，请检查adminPassword参数", groups = {add.class})
    private String adminPassword;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
