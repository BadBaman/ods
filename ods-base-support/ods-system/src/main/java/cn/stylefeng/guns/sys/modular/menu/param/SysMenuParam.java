/*
Copyright [2020] [https://www.stylefeng.cn]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Guns采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：

1.请不要删除和修改根目录下的LICENSE文件。
2.请不要删除和修改Guns源码头部的版权声明。
3.请保留源码和相关描述文件的项目出处，作者声明等。
4.分发源码时候，请注明软件出处 https://gitee.com/stylefeng/guns-separation
5.在修改包名，模块名称，项目代码等时，请注明软件出处 https://gitee.com/stylefeng/guns-separation
6.若您的项目无法满足以上几点，可申请商业授权，获取Guns商业授权许可，请在官网购买授权，地址为 https://www.stylefeng.cn
 */
package cn.stylefeng.guns.sys.modular.menu.param;

import cn.stylefeng.guns.core.pojo.base.param.BaseParam;
import cn.stylefeng.guns.core.validation.flag.FlagValue;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * 系统菜单参数
 *
 * @author xuyuxiang
 * @date 2020/3/26 20:42
 */
public class SysMenuParam extends BaseParam {

    /**
     * 主键
     */
    @NotNull(message = "id不能为空，请检查id参数", groups = {edit.class, delete.class, detail.class})
    private Long id;

    /**
     * 父id
     */
    @NotNull(message = "pid不能为空，请检查pid参数", groups = {add.class, edit.class})
    private Long pid;

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空，请检查name参数", groups = {add.class, edit.class})
    private String name;

    /**
     * 编码
     */
    @NotBlank(message = "编码不能为空，请检查code参数", groups = {add.class, edit.class})
    private String code;

    /**
     * 菜单类型（字典 0目录 1菜单 2按钮）
     */
    @NotNull(message = "菜单类型不能为空，请检查type参数", groups = {add.class, edit.class})
    @Min(value = 0, message = "菜单类型格式错误，请检查type参数", groups = {add.class, edit.class})
    @Max(value = 2, message = "菜单类型格式错误，请检查type参数", groups = {add.class, edit.class})
    private Integer type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 路由地址
     */
    private String router;

    /**
     * 组件地址
     */
    private String component;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 应用分类（应用编码）
     */
    @NotBlank(message = "应用分类不能为空，请检查application参数", groups = {add.class, edit.class, change.class})
    private String application;

    /**
     * 打开方式（字典 0无 1组件 2内链 3外链）
     */
    @NotNull(message = "打开方式不能为空，请检查openType参数", groups = {add.class, edit.class})
    @Min(value = 0, message = "打开方式格式错误，请检查openType参数", groups = {add.class, edit.class})
    @Max(value = 3, message = "打开方式格式错误，请检查openType参数", groups = {add.class, edit.class})
    private Integer openType;

    /**
     * 是否可见（Y-是，N-否）
     */
    @NotBlank(message = "是否可见不能为空，请检查visible参数", groups = {add.class, edit.class})
    @FlagValue(message = "是否可见格式错误，正确格式应该Y或者N，请检查visible参数", groups = {add.class, edit.class})
    private String visible;

    /**
     * 内链地址
     */
    private String link;

    /**
     * 重定向地址
     */
    private String redirect;

    /**
     * 权重（字典 1系统权重 2业务权重）
     */
    @NotNull(message = "权重不能为空，请检查weight参数", groups = {add.class, edit.class})
    @Min(value = 0, message = "权重格式错误，请检查weight参数", groups = {add.class, edit.class})
    @Max(value = 2, message = "权重格式错误，请检查weight参数", groups = {add.class, edit.class})
    private Integer weight;

    /**
     * 排序
     */
    @NotNull(message = "排序不能为空，请检查sort参数", groups = {add.class, edit.class})
    private Integer sort;

    /**
     * 备注
     */
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public Integer getOpenType() {
        return openType;
    }

    public void setOpenType(Integer openType) {
        this.openType = openType;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SysMenuParam that = (SysMenuParam) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(pid, that.pid) &&
                Objects.equals(name, that.name) &&
                Objects.equals(code, that.code) &&
                Objects.equals(type, that.type) &&
                Objects.equals(icon, that.icon) &&
                Objects.equals(router, that.router) &&
                Objects.equals(component, that.component) &&
                Objects.equals(permission, that.permission) &&
                Objects.equals(application, that.application) &&
                Objects.equals(openType, that.openType) &&
                Objects.equals(visible, that.visible) &&
                Objects.equals(link, that.link) &&
                Objects.equals(redirect, that.redirect) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(sort, that.sort) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, pid, name, code, type, icon, router, component, permission, application, openType, visible, link, redirect, weight, sort, remark);
    }
}
