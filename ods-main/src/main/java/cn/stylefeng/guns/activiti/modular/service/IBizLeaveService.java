package cn.stylefeng.guns.activiti.modular.service;


import cn.stylefeng.guns.activiti.modular.domin.ApproveDto;
import cn.stylefeng.guns.activiti.modular.domin.BizLeaveVo;
import cn.stylefeng.guns.activiti.modular.domin.HistoricActivity;
import cn.stylefeng.guns.core.pojo.login.SysLoginUser;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface IBizLeaveService {

    /**
     * 查询请假业务
     *
     * @param id 请假业务ID
     * @return 请假业务
     */
    public BizLeaveVo selectBizLeaveById(Long id);

    /**
     * 修改请假业务
     *
     * @param BizLeaveVo 请假业务
     * @return 结果
     */
    public int updateBizLeave(BizLeaveVo BizLeaveVo);


    /**
     * 查询请假流程列表
     * @param BizLeaveVo
     * @return
     */
    List<BizLeaveVo> selectBizLeaveList(BizLeaveVo BizLeaveVo);

    /**
     * 查询已办任务列表
     * @param bizLeaveVo
     * @param userId
     * @return
     */
    List<BizLeaveVo> findTaskDoneList(BizLeaveVo bizLeaveVo, String userId);

    /**
     * 查询代办任务列表
     * @param bizLeaveVo
     * @param userId
     * @return
     */
    List<BizLeaveVo> findToDoTaskDoneList(BizLeaveVo bizLeaveVo, String userId);

    /**
     * 1 新增请假业务  未加修改和删除
     * @param bizLeaveVo
     * @return
     */
    int insertBizLeave(BizLeaveVo bizLeaveVo, SysLoginUser loginUser);

    /**
     * 启动请假流程
     * @param leave
     * @param loginUser
     * @param key
     * @param variables
     * @return
     */
    String submitApply(BizLeaveVo leave, SysLoginUser loginUser, String key, Map<String, Object> variables);



    /**
     * 完成任务
     */
    /**
     * 完成任务
     * @param approveDto 审批信息
     * @param userId 用户id
     */
    void completeTask(ApproveDto approveDto, String userId);

    /**
     * 查询审批历史列表
     * @param processInstanceId 流程实例id
     * @param historicActivity 封装的查询条件
     * @return
     */
    List<HistoricActivity> selectHistoryList(String processInstanceId, HistoricActivity historicActivity);

    /**
     *  加载审批流程图
     * @param pProcessInstanceId 流程ID
     * @param response 响应
     */
    void resloveProcessDiagram(String pProcessInstanceId, HttpServletResponse response) throws Exception;


}
