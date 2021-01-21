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
package cn.stylefeng.guns.core.pojo.page;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.PageUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 分页结果集
 *
 * @author xuyuxiang
 * @date 2020/3/30 15:44
 */
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 默认分页彩虹展示数量
     */
    public static final int RAINBOW_NUM = 5;

    /**
     * 第几页
     */
    private Integer pageNo = 1;

    /**
     * 每页条数
     */
    private Integer pageSize = 20;

    /**
     * 总页数
     */
    private Integer totalPage = 0;

    /**
     * 总记录数
     */
    private Integer totalRows = 0;

    /**
     * 结果集
     */
    private List<T> rows;

    /**
     * 分页彩虹
     */
    private int[] rainbow;

    public PageResult() {
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int[] getRainbow() {
        return rainbow;
    }

    public void setRainbow(int[] rainbow) {
        this.rainbow = rainbow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageResult<?> that = (PageResult<?>) o;
        return Objects.equals(pageNo, that.pageNo) &&
                Objects.equals(pageSize, that.pageSize) &&
                Objects.equals(totalPage, that.totalPage) &&
                Objects.equals(totalRows, that.totalRows) &&
                Objects.equals(rows, that.rows) &&
                Arrays.equals(rainbow, that.rainbow);
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalRows=" + totalRows +
                ", rows=" + rows +
                ", rainbow=" + Arrays.toString(rainbow) +
                '}';
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(pageNo, pageSize, totalPage, totalRows, rows);
        result = 31 * result + Arrays.hashCode(rainbow);
        return result;
    }

    /**
     * 将mybatis-plus的page转成自定义的PageResult，扩展了totalPage总页数，和rainBow彩虹条
     *
     * @author xuyuxiang
     * @date 2020/4/8 19:20
     */
    public PageResult(Page<T> page) {
        this.setRows(page.getRecords());
        this.setTotalRows(Convert.toInt(page.getTotal()));
        this.setPageNo(Convert.toInt(page.getCurrent()));
        this.setPageSize(Convert.toInt(page.getSize()));
        this.setTotalPage(PageUtil.totalPage(Convert.toInt(page.getTotal()),
                Convert.toInt(page.getSize())));
        this.setRainbow(PageUtil.rainbow(Convert.toInt(page.getCurrent()),
                Convert.toInt(this.getTotalPage()), RAINBOW_NUM));
    }

    /**
     * 将mybatis-plus的page转成自定义的PageResult，扩展了totalPage总页数，和rainBow彩虹条
     * 可单独设置rows
     *
     * @author xuyuxiang
     * @date 2020/4/14 20:55
     */
    public PageResult(Page<T> page, List<T> t) {
        this.setRows(t);
        this.setTotalRows(Convert.toInt(page.getTotal()));
        this.setPageNo(Convert.toInt(page.getCurrent()));
        this.setPageSize(Convert.toInt(page.getSize()));
        this.setTotalPage(PageUtil.totalPage(Convert.toInt(page.getTotal()),
                Convert.toInt(page.getSize())));
        this.setRainbow(PageUtil.rainbow(Convert.toInt(page.getCurrent()),
                Convert.toInt(this.getTotalPage()), RAINBOW_NUM));
    }
}
