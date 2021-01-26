package cn.stylefeng.guns.activiti.modular.controller;

import cn.stylefeng.guns.core.pojo.response.ResponseData;
import cn.stylefeng.guns.core.pojo.response.SuccessResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value="/leave",tags = "测试Activiti控制器")
@RestController
@RequestMapping("/leave")
public class ActController {

    @Autowired
    private TaskService taskService;
    @ApiOperation("test接口")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ResponseData gettest(ModelAndView view){
        Map<String,Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("user1");
        list.add("user2");
        map.put("code","200");
        map.put("msg","请求ok");
        map.put("list",list);

        return new SuccessResponseData(map);
    }


}
