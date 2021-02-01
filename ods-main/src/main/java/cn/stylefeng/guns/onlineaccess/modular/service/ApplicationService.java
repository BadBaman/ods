package cn.stylefeng.guns.onlineaccess.modular.service;

import cn.stylefeng.guns.onlineaccess.modular.entity.Application;
import cn.stylefeng.guns.onlineaccess.modular.param.DataAccessParam;
import cn.stylefeng.guns.onlineaccess.modular.result.ApplicationResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ApplicationService extends IService<Application> {

    /**
     * 根据项目id和用户id查询申请
     *
     * @param projectId,userId 查询参数
     * @author 李开元
     * @date 2021/1/27 9:26
     */
    List<Application> getApplicationByUserIdAndProjectIdResult(Long projectId, Long userId);

    /**
     * 根据用户id查询申请
     *
     * @param id 查询参数
     * @author 李开元
     * @date 2021/1/27 9:26
     */
    List<Application> getApplicationByUserId(Long id);

    /**
     * 根据申请人id查询申请
     *
     * @param applicant 查询参数
     * @author 李开元
     * @date 2021/1/27 9:26
     */
    List<ApplicationResult> getApplicantAndWorkflowRByApplicant(Long applicant);

    /**
     * 添加申请表
     *
     * @param dataAccessParam 添加参数
     * @author 李开元
     * @date 2021/1/27 9:26
     */
    void add(DataAccessParam dataAccessParam);


    ApplicationResult getApplicantAndWorkflowRByApplicationId(String applicationId);
}
