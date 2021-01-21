package cn.stylefeng.guns.onlineaccess.modular.controller;

import cn.stylefeng.guns.core.pojo.response.ResponseData;
import cn.stylefeng.guns.onlineaccess.modular.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/api/user/userinfo")
    public ResponseData getUserById(Long id){
        return ResponseData.success(userService.getUserById(id));
    }

}
