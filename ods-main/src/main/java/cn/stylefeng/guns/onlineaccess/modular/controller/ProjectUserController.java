package cn.stylefeng.guns.onlineaccess.modular.controller;

import cn.stylefeng.guns.core.pojo.response.ResponseData;
import cn.stylefeng.guns.onlineaccess.modular.service.ProjectUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProjectUserController {

    @Resource
    ProjectUserService projectUserService;

    @GetMapping("/api/user/datanegotiator")
    public ResponseData getDatanegotiatorByProjectIdResult(Long id,int type){
        return ResponseData.success(projectUserService.getDatanegotiatorByProjectIdResult(id,type));
    }
}
