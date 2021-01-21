package cn.stylefeng.guns.onlineaccess.modular.mapper;

import cn.stylefeng.guns.onlineaccess.modular.result.UserResult;
import cn.stylefeng.guns.sys.modular.user.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface UserMapper extends BaseMapper<UserResult> {

    List<UserResult> getProjectByUserIdAndProjectIdResult(Page page, Long projectId, Long userId);

    List<UserResult> getUserById(Page page,Long id);

}
