package cn.stylefeng.guns.activiti.modular.controller;


import cn.stylefeng.guns.activiti.modular.domin.ApproveDto;
import cn.stylefeng.guns.activiti.modular.domin.BizLeaveVo;
import cn.stylefeng.guns.activiti.modular.domin.HistoricActivity;
import cn.stylefeng.guns.activiti.modular.service.IBizLeaveService;
import cn.stylefeng.guns.core.context.login.LoginContextHolder;
import cn.stylefeng.guns.core.pojo.login.SysLoginUser;
import cn.stylefeng.guns.core.pojo.response.ResponseData;
import cn.stylefeng.guns.core.pojo.response.SuccessResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Api(value = "/countersign",tags = "会签流程控制器")
@RestController
@RequestMapping("/countersign")
public class BizLeaveContersignController {

    private static final Logger logger = LoggerFactory.getLogger(BizLeaveContersignController.class);

    @Autowired
    IBizLeaveService bizLeaveService;


    @ApiOperation("会签流程列表")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public ResponseData leaveList(BizLeaveVo bizLeaveVo){
        bizLeaveVo.setType("leave-countersign");
        boolean isSuperAdmin = LoginContextHolder.me().isSuperAdmin();
        if(!isSuperAdmin){//如果登录的用户不是管理员，需要传入当前登录的用户id
            Long id = LoginContextHolder.me().getSysLoginUser().getId();
            logger.info("user id = {}",id);
            bizLeaveVo.setCreateUser(id);//设置创建人，需从系统中获取
        }

        return new SuccessResponseData(bizLeaveService.selectBizLeaveList(bizLeaveVo));
    }

    @ApiOperation("会签已办流程列表")
    @RequestMapping(value = "/taskdonelist",method = RequestMethod.POST)
    public ResponseData leaveTaskDoneList(BizLeaveVo bizLeaveVo){
        bizLeaveVo.setType("leave-countersign");
        String userId = String.valueOf(LoginContextHolder.me().getSysLoginUser().getId());
        return new SuccessResponseData(bizLeaveService.findTaskDoneList(bizLeaveVo,userId));
    }

    @ApiOperation("会签代办流程列表")
    @RequestMapping(value = "/tasktodolist",method = RequestMethod.POST)
    public ResponseData leaveToDoTaskDoneList(BizLeaveVo bizLeaveVo){
        bizLeaveVo.setType("leave-countersign");
        String userId = String.valueOf(LoginContextHolder.me().getSysLoginUser().getId());
        //bizLeaveVo.setCreateUser(1340558619908775937L);//设置创建人，需从系统中获取
        return new SuccessResponseData(bizLeaveService.findToDoTaskDoneList(bizLeaveVo,userId));
    }

    @ApiOperation("获取流程图片")  //这个和请假控制中有重复，可以提取到流程控制器中
    @RequestMapping(value = "/read-resource")
    public void readResource(String pProcessInstanceId, HttpServletResponse response) throws Exception {
        // 设置页面不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        bizLeaveService.resloveProcessDiagram(pProcessInstanceId,response);
    }

    @ApiOperation("新增会签流程")
    @PostMapping("/insertbizleave")
    public ResponseData insertBizLeave(BizLeaveVo bizLeaveVo){
        SysLoginUser user = LoginContextHolder.me().getSysLoginUser();
        bizLeaveVo.setType("leave-countersign");
        return new SuccessResponseData(bizLeaveService.insertBizLeave(bizLeaveVo,user));

    }


    @ApiOperation("开启会签流程")
    @PostMapping("/startprocess")
    public ResponseData startProcess(BizLeaveVo bizLeaveVo){

        SysLoginUser user = LoginContextHolder.me().getSysLoginUser();
        String key = "leave-countersign";
        Map<String,Object> variables = new HashMap<>();
        return new SuccessResponseData(bizLeaveService.submitApply(bizLeaveVo,user,key,variables));
    }



    @ApiOperation("完成会签任务")
    @PostMapping("/completetask")
    public ResponseData completeTask(ApproveDto approveDto){
        String userId = String.valueOf(LoginContextHolder.me().getSysLoginUser().getId());
        bizLeaveService.completeTask(approveDto,userId);
        return new SuccessResponseData();
    }

    @ApiOperation("审批历史列表")
    @PostMapping("/historylist/{processInstanceId}")
    public ResponseData getHistoryListByProcessInstanceId(
            @PathVariable(value = "processInstanceId")String processInstanceId,
            HistoricActivity historicActivity){
        return new SuccessResponseData(bizLeaveService.selectHistoryList(processInstanceId, historicActivity));

    }
}
