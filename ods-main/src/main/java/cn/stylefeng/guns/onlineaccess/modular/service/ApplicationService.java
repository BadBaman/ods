package cn.stylefeng.guns.onlineaccess.modular.service;

import cn.stylefeng.guns.onlineaccess.modular.entity.Application;
import cn.stylefeng.guns.onlineaccess.modular.param.DataAccessParam;
import cn.stylefeng.guns.onlineaccess.modular.result.ApplicationResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ApplicationService extends IService<Application> {

    List<Application> getApplicationByUserIdAndProjectIdResult(Long projectId,Long userId);

    List<Application> getApplicationByUserId(Long id);

    List<ApplicationResult> getApplicantAndWorkflowRByApplicant(Long applicant);
}
