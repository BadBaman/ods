package cn.stylefeng.guns.onlineaccess.modular.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.stylefeng.guns.core.factory.PageFactory;
import cn.stylefeng.guns.onlineaccess.modular.entity.Application;
import cn.stylefeng.guns.onlineaccess.modular.mapper.ApplicationMapper;
import cn.stylefeng.guns.onlineaccess.modular.mapper.DataAccessMapper;
import cn.stylefeng.guns.onlineaccess.modular.param.DataAccessParam;
import cn.stylefeng.guns.onlineaccess.modular.result.ApplicationResult;
import cn.stylefeng.guns.onlineaccess.modular.result.DataAccessResult;
import cn.stylefeng.guns.onlineaccess.modular.service.ApplicationService;
import cn.stylefeng.guns.onlineaccess.modular.service.DataAccessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

    @Resource
    ApplicationService applicationService;


    @Override
    public List<Application> getApplicationByUserIdAndProjectIdResult(Long projectId, Long userId) {
        return this.baseMapper.getApplicationByUserIdAndProjectIdResult(PageFactory.defaultPage(),projectId,userId);
    }

    @Override
    public List<Application> getApplicationByUserId(Long id) {
        return this.baseMapper.getApplicationByUserId(PageFactory.defaultPage(),id);
    }

    @Override
    public List<ApplicationResult> getApplicantAndWorkflowRByApplicant(Long applicant) {
        return this.baseMapper.getApplicantByApplicant(PageFactory.defaultPage(),applicant);
    }
}
