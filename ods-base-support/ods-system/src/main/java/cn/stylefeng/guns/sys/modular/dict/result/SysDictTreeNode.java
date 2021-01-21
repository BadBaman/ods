package cn.stylefeng.guns.sys.modular.dict.result;

import cn.stylefeng.guns.core.pojo.base.node.BaseTreeNode;

import java.util.List;

/**
 * 系统字典树
 *
 * @author xuyuxiang
 * @date 2020/3/11 12:08
 */
public class SysDictTreeNode implements BaseTreeNode {

    /**
     * id
     */
    private Long id;

    /**
     * 父id
     */
    private Long pid;

    /**
     * 编码-对应字典值的编码
     */
    private String code;

    /**
     * 名称-对应字典值的value
     */
    private String name;

    /**
     * 子节点集合
     */
    private List<SysDictTreeNode> children;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Long getPid() {
        return this.pid;
    }

    @Override
    public void setChildren(List children) {
        this.children = children;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SysDictTreeNode> getChildren() {
        return children;
    }
}
