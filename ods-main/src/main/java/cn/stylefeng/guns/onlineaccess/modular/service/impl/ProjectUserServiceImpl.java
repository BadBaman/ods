package cn.stylefeng.guns.onlineaccess.modular.service.impl;

import cn.stylefeng.guns.core.factory.PageFactory;
import cn.stylefeng.guns.onlineaccess.modular.entity.ProjectUser;
import cn.stylefeng.guns.onlineaccess.modular.mapper.ProjectUserMapper;
import cn.stylefeng.guns.onlineaccess.modular.service.ProjectUserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectUserServiceImpl extends ServiceImpl<ProjectUserMapper,ProjectUser> implements ProjectUserService {

    @Resource
    ProjectUserService projectUserService;

    @Override
    public List<ProjectUser> getDatanegotiatorByProjectIdResult(Long id, int type) {
        return this.baseMapper.getDatanegotiatorByProjectIdResult(PageFactory.defaultPage(),id,type);
    }
}
