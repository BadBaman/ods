package cn.stylefeng.guns.onlineaccess.modular.service.impl;

import cn.stylefeng.guns.core.factory.PageFactory;
import cn.stylefeng.guns.onlineaccess.modular.mapper.UserMapper;
import cn.stylefeng.guns.onlineaccess.modular.result.UserResult;
import cn.stylefeng.guns.onlineaccess.modular.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserResult> implements UserService {
    @Override
    public List<UserResult> getProjectByUserIdAndProjectIdResult(Long projectId, Long userId) {
        return this.baseMapper.getProjectByUserIdAndProjectIdResult(PageFactory.defaultPage(),projectId,userId);
    }

    @Override
    public List<UserResult> getUserById(Long id) {
        return this.baseMapper.getUserById(PageFactory.defaultPage(),id);
    }
}
