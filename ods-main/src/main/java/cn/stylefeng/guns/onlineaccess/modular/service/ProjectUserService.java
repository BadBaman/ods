package cn.stylefeng.guns.onlineaccess.modular.service;

import cn.stylefeng.guns.onlineaccess.modular.entity.ProjectUser;
import cn.stylefeng.guns.onlineaccess.modular.result.ProjectUserResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ProjectUserService extends IService<ProjectUser> {

    List<ProjectUserResult> getDatanegotiatorByProjectIdResult(Long id, int type);
}
