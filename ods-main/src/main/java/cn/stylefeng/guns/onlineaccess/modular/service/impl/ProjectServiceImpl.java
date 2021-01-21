package cn.stylefeng.guns.onlineaccess.modular.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.stylefeng.guns.core.context.login.LoginContextHolder;
import cn.stylefeng.guns.core.enums.CommonStatusEnum;
import cn.stylefeng.guns.core.factory.PageFactory;
import cn.stylefeng.guns.core.pojo.page.PageResult;
import cn.stylefeng.guns.onlineaccess.modular.entity.Project;
import cn.stylefeng.guns.onlineaccess.modular.mapper.ProjectMapper;
import cn.stylefeng.guns.onlineaccess.modular.param.ProjectParam;
import cn.stylefeng.guns.onlineaccess.modular.result.DataAccessResult;
import cn.stylefeng.guns.onlineaccess.modular.result.ProjectResult;
import cn.stylefeng.guns.onlineaccess.modular.service.DataAccessService;
import cn.stylefeng.guns.onlineaccess.modular.service.ProjectService;
import cn.stylefeng.guns.sys.core.enums.AdminTypeEnum;
import cn.stylefeng.guns.sys.modular.emp.param.SysEmpParam;
import cn.stylefeng.guns.sys.modular.user.result.SysUserResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

    @Resource
    ProjectService projectService;


    @Override
    public Project getProjectDetailsResultByName(String name) {
        LambdaQueryWrapper<Project> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Project::getName, name);
        return this.getOne(queryWrapper);
    }

    @Override
    public Project getProjectStatisticResultById(Long id) {
        LambdaQueryWrapper<Project> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Project::getId, id);
        return this.getOne(queryWrapper);
    }

    @Override
    public Project getProjectDetailsResultById(long id) {
        LambdaQueryWrapper<Project> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Project::getId, id);
        return this.getOne(queryWrapper);
    }

    @Override
    public Project getProjectStatisticResultByName(String name) {
        LambdaQueryWrapper<Project> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Project::getName, name);
        return this.getOne(queryWrapper);
    }

    @Override
    public Project getAllProjectStatisticResultByName(String name) {
        LambdaQueryWrapper<Project> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Project::getName, name);
        return this.getOne(queryWrapper);
    }

    @Override
    public List<Project> getProjectDetailsResultByUserId(Long id) {
        return this.baseMapper.getProjectByUserIdResult(PageFactory.defaultPage(),id);

    }

    @Override
    public List<Project> getProjectDetails(Long id) {
        return this.baseMapper.getProjectByProjectIdResult(PageFactory.defaultPage(),id);
    }

    @Override
    public List<Project> getProjectByUserIdAndStatusResult(Long id, int status) {
        return this.baseMapper.getProjectByUserIdAndStatusResult(PageFactory.defaultPage(),id,status);
    }

    @Override
    public void add(ProjectParam projectParam) {

    }
}
