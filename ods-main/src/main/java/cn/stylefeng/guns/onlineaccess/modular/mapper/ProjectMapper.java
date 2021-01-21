package cn.stylefeng.guns.onlineaccess.modular.mapper;

import cn.stylefeng.guns.onlineaccess.modular.entity.Project;
import cn.stylefeng.guns.onlineaccess.modular.result.ProjectResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectMapper extends BaseMapper<Project> {


    /**
     * 获取项目分页列表
     *
     * @param page         分页参数
     * @param id 查询参数
     * @return 查询分页结果
     * @author xuyuxiang
     * @date 2020/4/7 21:14
     */
    List<Project> getProjectByProjectIdResult(Page page, long id);

    /**
     * 获取项目分页列表
     *
     * @param page         分页参数
     * @param name 查询参数
     * @return 查询分页结果
     * @author xuyuxiang
     * @date 2020/4/7 21:14
     */
    List<Project> getProjectByUserIdResult(Page page, Long id);

    List<Project> getProjectByUserIdAndStatusResult(Page page, Long id, int status);

}
