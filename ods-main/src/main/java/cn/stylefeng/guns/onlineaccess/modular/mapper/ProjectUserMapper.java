package cn.stylefeng.guns.onlineaccess.modular.mapper;

import cn.stylefeng.guns.onlineaccess.modular.entity.ProjectUser;
import cn.stylefeng.guns.onlineaccess.modular.result.ProjectUserResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectUserMapper extends BaseMapper<ProjectUser> {

    List<ProjectUserResult> getDatanegotiatorByProjectIdResult(Page page, Long id,int type);
}
