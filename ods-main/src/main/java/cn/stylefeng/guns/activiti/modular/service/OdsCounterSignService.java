package cn.stylefeng.guns.activiti.modular.service;

import cn.stylefeng.guns.activiti.modular.Result.OdsApplicationResult;
import cn.stylefeng.guns.activiti.modular.domin.ApproveDto;
import cn.stylefeng.guns.activiti.modular.domin.HistoricActivity;
import cn.stylefeng.guns.onlineaccess.modular.result.ApplicationResult;

import java.util.List;

public interface OdsCounterSignService {

    /**
     * 开启ods工作流
     *
     * @param userId        用户id
     * @param projectId     项目id
     * @param applicationId 申请id
     * @return processInstanceId 流程实例id
     */
    String startOdsProcess(Long userId, Long projectId, Long applicationId);

    /**
     * 访问申请列表
     *
     * @param applicant 流程申请人
     * @return 访问申请列表
     */
    List<ApplicationResult> getOdsProcessList(Long applicant);

    /**
     * 已办任务列表
     * 暂时只有分页，没有复杂搜索
     * @param pageNow 当前页数
     * @param pagesize 页数大小
     * @param userId 用户id
     * @return 已办任务列表
     */
    List<OdsApplicationResult> findTaskDoneList(Integer pageNow, Integer pagesize, String userId);

    /**
     * 代办任务列表
     * @param pageNow 当前页数
     * @param pagesize 页数大小
     * @param userId 用户id
     * @return 代办任务列表
     */
    List<OdsApplicationResult> findToDoTaskDoneList(Integer pageNow, Integer pagesize, String userId);

    /**
     * 完成任务
     * @param approveDto 封装条件
     * @param userId 用户id
     * @return 任务是否完成
     */
    boolean completeTask(ApproveDto approveDto, String userId);

    /**
     * 审批历史
     * @param processInstanceId 流程实例
     * @return 审批历史列表
     */
    List<HistoricActivity> selectHistoryList(String processInstanceId);

}
