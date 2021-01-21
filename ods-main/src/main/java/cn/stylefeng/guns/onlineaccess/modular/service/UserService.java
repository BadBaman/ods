package cn.stylefeng.guns.onlineaccess.modular.service;

import cn.stylefeng.guns.onlineaccess.modular.result.UserResult;
import cn.stylefeng.guns.sys.modular.user.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<UserResult> {

    List<UserResult> getProjectByUserIdAndProjectIdResult(Long projectId, Long userId);

    List<UserResult> getUserById(Long id);
}
