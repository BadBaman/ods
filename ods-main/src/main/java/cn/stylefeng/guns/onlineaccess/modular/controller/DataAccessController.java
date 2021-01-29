package cn.stylefeng.guns.onlineaccess.modular.controller;

import cn.stylefeng.guns.core.pojo.response.ResponseData;
import cn.stylefeng.guns.core.pojo.response.SuccessResponseData;
import cn.stylefeng.guns.onlineaccess.modular.param.ConditionParam;
import cn.stylefeng.guns.onlineaccess.modular.param.DataAccessParam;
import cn.stylefeng.guns.onlineaccess.modular.service.ApplicationService;
import cn.stylefeng.guns.onlineaccess.modular.service.DataAccessService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DataAccessController {

    @Resource
    private DataAccessService dataAccessService;


    @Resource
    private ApplicationService applicationService;

    /**
     * 根据项目id获取项目统计信息
     *
     * @author likaiyuan
     * @date 2020/1/4 21:11
     */
//    @GetMapping("/api/user/prostat")
//    public ResponseData getStatisticByProid(long proid) {
//        return new SuccessResponseData(dataAccessService.getStatisticByProid(proid));
//    }



    /**
     * 根据名称查询数据访问申请列表
     *
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
    @GetMapping("/api/user/applylistdetailsByName")
    public ResponseData searchApplyListDetails(String name) {
        return ResponseData.success(dataAccessService.getDataAccessByApplicant(name));
    }

    /**
     * 获取该用户和项目id对应的在该项目下的所有申请列表
     *
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */



    /**
     * 根据条件参数查询该项目下的所有申请概要列表
     *
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */

    @GetMapping("/api/user/applylist")
    public ResponseData searchApplyListSummaryDetailsByCondition(ConditionParam conditionParam) {
        return ResponseData.success(dataAccessService.getDataAccessSummaryByConditionParam(conditionParam));
    }



    /**
     * 根据条件参数查询数据访问申请列表
     *
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */

    @GetMapping("/api/user/applylistdetailsByConditionParam")
    public ResponseData searchApplyListDetailsByCondition(ConditionParam conditionParam) {
        return ResponseData.success(dataAccessService.getDataAccessByConditionParam(conditionParam));
    }



    /**
     * 根据项目id查看具体某项申请列表的流程进展
     *
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
    @GetMapping("/api/user/applyprocess/applyid")
    public ResponseData searchApplyListDetailsByApplyId(long id) {
        return ResponseData.success(dataAccessService.getDataAccessByApplyId(id));
    }
    /**
     * 删除数据访问申请
     *
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
//    @PostMapping("/dataAccess/delete")
//    public ResponseData delete(@RequestBody @Validated(DataAccessParam.delete.class) DataAccessParam dataAccessParam) {
//        dataAccessService.delete(dataAccessParam);
//        return new SuccessResponseData();
//    }


}
