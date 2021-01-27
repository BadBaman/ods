package cn.stylefeng.guns.activiti.modular.service;

import cn.stylefeng.guns.onlineaccess.modular.result.ApplicationResult;

import java.util.List;

public interface OdsCounterSignService {

    /**
     * 开启ods工作流
     * @param userId 用户id
     * @param projectId 项目id
     * @param applicationId 申请id
     * @return
     */
    String startOdsProcess(Long userId,Long projectId,Long applicationId);

    /**
     * 访问申请列表
     * @param applicant 流程申请人
     * @return
     */
    List<ApplicationResult> getOdsProcessList(Long applicant);
}
