package cn.stylefeng.guns.onlineaccess.modular.controller;

import cn.stylefeng.guns.core.pojo.response.ResponseData;
import cn.stylefeng.guns.onlineaccess.modular.service.DataTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DataTypeController {

    @Resource
    DataTypeService dataTypeService;

    @GetMapping("/api/user/dataleader")
    public ResponseData getDataManagerByProjectIdResult(Long id){
        return ResponseData.success(dataTypeService.getDataManagerByProjectIdResult(id));
    }
}
