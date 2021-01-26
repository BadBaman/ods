package cn.stylefeng.guns.onlineaccess.modular.controller;

import cn.stylefeng.guns.core.pojo.response.ResponseData;
import cn.stylefeng.guns.onlineaccess.modular.entity.Application;
import cn.stylefeng.guns.onlineaccess.modular.result.ApplicationResult;
import cn.stylefeng.guns.onlineaccess.modular.service.ApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ApplicationController {
    @Resource
    ApplicationService applicationService;

    @GetMapping("/api/user/applylistdefault")
    public ResponseData getApplicationByUserIdAndProjectIdResult(Long projectId,Long userId){
        return ResponseData.success(applicationService.getApplicationByUserIdAndProjectIdResult(projectId,userId));
    }

    @GetMapping("/api/user/applylistdetails")
    public ResponseData getapplylistdetailsByUserId(Long id){
        return ResponseData.success(applicationService.getApplicationByUserId(id));
    }

    @GetMapping("/api/user/getApplicantAndWorkflowRByApplicant")
    public ResponseData getApplicantAndWorkflowRByApplicant(Long applicant){
        return ResponseData.success(applicationService.getApplicantAndWorkflowRByApplicant(applicant));
    }
}
