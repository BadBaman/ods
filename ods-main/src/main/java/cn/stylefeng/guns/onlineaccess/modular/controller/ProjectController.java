package cn.stylefeng.guns.onlineaccess.modular.controller;

import cn.stylefeng.guns.core.pojo.response.ResponseData;
import cn.stylefeng.guns.onlineaccess.modular.service.ProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProjectController {

    @Resource
    private ProjectService projectService;

    /**
     * 根据用户名查询用户参与的项目概要信息
     *
     * @author likaiyuan
     * @date 2020/1/6 15:51
     */
    @GetMapping("/api/user/prolist")
    public ResponseData getProjectDetailsResultByUserId(Long id) {
        return ResponseData.success(projectService.getProjectDetailsResultByUserId(id));
    }

    /**
     * 根据项目id查询项目统计信息
     *
     * @author likaiyuan
     * @date 2020/1/6 15:51
     */
    @GetMapping("/api/user/prostat")
    public ResponseData getProjectStatisticResultById(Long id) {
        return ResponseData.success(projectService.getProjectStatisticResultById(id));
    }


    /**
     * 根据项目id查询项目概要信息列表
     *
     * @author likaiyuan
     * @date 2020/1/6 15:51
     */
    @GetMapping("/api/user/da")
    public ResponseData getProjectDetailsResultById(long id) {
        return ResponseData.success(projectService.getProjectDetailsResultById(id));
    }

    /**
     * 根据项目id查询项目概要信息列表
     *
     * @author likaiyuan
     * @date 2020/1/6 15:51
     */
    @GetMapping("/api/user/allprostat")
    public ResponseData getAllProjectStatisticResultByName(String name) {
        return ResponseData.success(projectService.getAllProjectStatisticResultByName(name));
    }

    /**
     * 根据项目id查询项目概要信息列表
     *
     * @author likaiyuan
     * @date 2020/1/6 15:51
     */
    @GetMapping("/api/user/prolistdetails")
    public ResponseData getAllProjectDetailsResultByName(String name) {
        return ResponseData.success(projectService.getAllProjectStatisticResultByName(name));
    }

    @GetMapping("/api/user/prodetail")
    public ResponseData getProjectDetailsByProjectId(Long id){
        return ResponseData.success(projectService.getProjectDetails(id));
    }

    @GetMapping("/api/user/getProjectByUserIdAndStatus")
    public ResponseData getProjectByUserIdAndStatusResult(Long id,int status){
        return ResponseData.success(projectService.getProjectByUserIdAndStatusResult(id,status));
    }
}
