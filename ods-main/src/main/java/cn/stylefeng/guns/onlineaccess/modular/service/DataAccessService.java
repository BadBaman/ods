package cn.stylefeng.guns.onlineaccess.modular.service;

import cn.stylefeng.guns.onlineaccess.modular.param.ConditionParam;
import cn.stylefeng.guns.onlineaccess.modular.param.DataAccessParam;
import cn.stylefeng.guns.onlineaccess.modular.result.DataAccessResult;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 科学数据在线访问平台数据访问申请表单service接口
 *
 * @author likaiyuan
 * @date 2020/12/28 15:51
 */
public interface DataAccessService extends IService<DataAccessResult> {


    /**
     * 根据申请人名字获取访问申请
     *
     * @param proid 项目id
     * @return StatisticResult
     * @author likaiyuan
     * @date 2021/1/4 19:51
     */
//    StatisticResult getStatisticByProid(long proid);

    /**
     * 根据申请人名字获取访问申请
     *
     * @param applicant 账号
     * @return DataAccessResult
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
    DataAccessResult getDataAccessByApplicant(String applicant);

    /**
     * 根据用户名和项目id获取访问申请概要列表
     *
     * @param username 用户名,proid 项目id
     * @return DataAccessSummaryResult
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
    DataAccessResult getDataAccessSummaryByUserNameAndProId(String username, long proid);

    /**
     * 根据条件参数获取访问申请概要列表
     *
     * @param conditionParam 条件参数
     * @return DataAccessSummaryResult
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
    DataAccessResult getDataAccessSummaryByConditionParam(ConditionParam conditionParam);
    /**
     * 根据用户名和项目id获取访问申请概要列表
     *
     * @param username 用户名,proid 项目id
     * @return DataAccessSummaryResult
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
//    DataAccessSummaryResult getDataAccessSummaryByUserNameAndProId(String username, long proid);

    /**
     * 根据条件参数获取访问申请概要列表
     *
     * @param conditionParam 条件参数
     * @return DataAccessSummaryResult
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
//    DataAccessSummaryResult getDataAccessSummaryByConditionParam(ConditionParam conditionParam);


    /**
     * 根据条件参数获取访问申请列表
     *
     * @param conditionParam 条件参数
     * @return DataAccessResult
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
    DataAccessResult getDataAccessByConditionParam(ConditionParam conditionParam);



    /**
     * 查看具体某项申请列表的流程进展
     *
     * @param id 条件参数
     * @return DataAccessResult
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
    DataAccessResult getDataAccessByApplyId(long id);

    /**
     * 根据项目id查看具体某项申请列表的流程进展
     *
     * @param id 条件参数
     * @return DataAccessResult
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
    DataAccessResult getDataManagerByApplyProId(long proId);

//    /**
//     * 查询系统用户
//     *
//     * @param dataAccessFormModel 查询参数
//     * @return 查询分页结果
//     * @author likaiyuan
//     * @date 2020/12/28 15:51
//     */
//    PageResult<SysUserResult> page(DataAccessFormModel dataAccessFormModel);

    /**
     * 根据用户账号模糊搜索系统用户列表
     *
     * @param dataAccessFormModel 查询参数
     * @return 增强版hashMap 格式：[{"id:":123, "firstName":"张三"}]
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
//    List<Dict> list(DataAccessFormModel dataAccessFormModel);

    /**
     * 增加系统用户
     *
     * @param dataAccessParam 添加参数
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
    void add(DataAccessParam dataAccessParam);

    /**
     * 删除系统用户
     *
     * @param dataAccessFormModel 删除参数
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
//    void delete(DataAccessParam dataAccessFormModel);

    /**
     * 编辑系统用户
     *
     * @param dataAccessFormModel 编辑参数
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
//    void edit(DataAccessFormModel dataAccessFormModel);

}
