package cn.stylefeng.guns.activiti.modular.controller;

import cn.stylefeng.guns.activiti.modular.Result.OdsApplicationResult;
import cn.stylefeng.guns.activiti.modular.domin.ApproveDto;
import cn.stylefeng.guns.activiti.modular.domin.HistoricActivity;
import cn.stylefeng.guns.activiti.modular.domin.RequestParam;
import cn.stylefeng.guns.activiti.modular.service.OdsCounterSignService;
import cn.stylefeng.guns.core.context.login.LoginContextHolder;
import cn.stylefeng.guns.core.pojo.response.ResponseData;
import cn.stylefeng.guns.core.pojo.response.SuccessResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "/ods",tags = "ods会签控制器")
@RequestMapping("/odscountersign")
public class OdsCounterSignController {
    @Autowired
    OdsCounterSignService odsCounterSignService;

    @ApiOperation("查询代办列表")
    @RequestMapping(value = "/tasktodolist",method = RequestMethod.POST)
    public ResponseData todoList(RequestParam requestParam){
        String userId = String.valueOf(LoginContextHolder.me().getSysLoginUser().getId());
        List<OdsApplicationResult> toDoTaskDoneList = odsCounterSignService.findToDoTaskDoneList(requestParam.getPageNow(), requestParam.getPageSize(), userId);
        return new SuccessResponseData(toDoTaskDoneList);
    }

    @ApiOperation("查询已办列表")
    @RequestMapping(value = "/taskdonelist",method = RequestMethod.POST)
    public ResponseData doneList(RequestParam requestParam){
        String userId = String.valueOf(LoginContextHolder.me().getSysLoginUser().getId());
        List<OdsApplicationResult> taskDoneList = odsCounterSignService.findTaskDoneList(requestParam.getPageNow(), requestParam.getPageSize(), userId);
        return new SuccessResponseData(taskDoneList);
    }

    @ApiOperation("完成任务")
    @RequestMapping(value = "/completetask",method = RequestMethod.POST)
    public ResponseData completeTask(ApproveDto approveDto){
        String userId = String.valueOf(LoginContextHolder.me().getSysLoginUser().getId());
        boolean historicActivities = odsCounterSignService.completeTask(approveDto, userId);
        return new SuccessResponseData(historicActivities);
    }

    @ApiOperation("审批历史")
    @RequestMapping(value = "/historylist/{processInstanceId}",method = RequestMethod.POST)
    public ResponseData odsHistoryList(@PathVariable(value = "processInstanceId")String processInstanceId){
        List<HistoricActivity> historicActivities = odsCounterSignService.selectHistoryList(processInstanceId);
        return new SuccessResponseData(historicActivities);
    }

}
