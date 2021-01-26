package cn.stylefeng.guns.onlineaccess.modular.service;

import cn.stylefeng.guns.core.pojo.page.PageResult;
import cn.stylefeng.guns.onlineaccess.modular.entity.Project;
import cn.stylefeng.guns.onlineaccess.modular.param.ConditionParam;
import cn.stylefeng.guns.onlineaccess.modular.param.DataAccessParam;
import cn.stylefeng.guns.onlineaccess.modular.param.ProjectParam;
import cn.stylefeng.guns.onlineaccess.modular.result.DataAccessResult;
import cn.stylefeng.guns.onlineaccess.modular.result.ProjectResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ProjectService extends IService<Project> {

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
     * @param name 用户名
     * @return ProjectResult
     * @author likaiyuan
     * @date 2021/1/6 15:51
     */
    Project getProjectDetailsResultByName(String name);

    /**
     * 根据项目id获取项目统计信息
     *
     * @param id 项目id
     * @return ProjectResult
     * @author likaiyuan
     * @date 2021/1/6 15:51
     */
    Project getProjectStatisticResultById(Long id);

    /**
     * 根据项目id获取项目概要列表
     *
     * @param id 项目id
     * @return ProjectResult
     * @author likaiyuan
     * @date 2021/1/6 15:51
     */
    Project getProjectDetailsResultById(long id);
    /**
     * 根据条件参数获取访问申请统计信息
     *
     * @param name 用户名
     * @return ProjectResult
     * @author likaiyuan
     * @date 2021/1/6 15:51
     */
    Project getProjectStatisticResultByName(String name);
    /**
     * 根据用户名和项目id获取访问申请概要列表
     *
     * @param username 用户名,proid 项目id
     * @return DataAccessSummaryResult
     * @author likaiyuan
     * @date 2021/1/6 15:51
     */
//    DataAccessSummaryResult getDataAccessSummaryByUserNameAndProId(String username, long proid);

    /**
     * 根据条件参数获取访问申请概要列表
     *
     * @param conditionParam 条件参数
     * @return DataAccessSummaryResult
     * @author likaiyuan
     * @date 2021/1/6 15:51
     */
//    DataAccessSummaryResult getDataAccessSummaryByConditionParam(ConditionParam conditionParam);


    /**
     * 根据用户名获取项目全部统计信息
     *
     * @param name 用户名
     * @return ProjectResult
     * @author likaiyuan
     * @date 2020/1/6 15:51
     */
    Project getAllProjectStatisticResultByName(String name);



    /**
     * 根据用户名获取项目全部概要信息
     *
     * @param name 用户名
     * @return ProjectResult
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
    List<Project> getProjectDetailsResultByUserId(Long id);


    /**
     * 根据项目id查询项目信息
     *
     * @param id 查询参数
     * @return 查询分页结果
     * @author likaiyuan
     * @date 2020/12/28 15:51
     */
    List<Project> getProjectDetails(Long id);



    List<Project> getProjectByUserIdAndStatusResult(Long id,int status);

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
     * 新建项目
     *
     * @param projectParam 添加参数
     * @author likaiyua
     * @date 2020/12/28 15:51
     */
    void add(ProjectParam projectParam);

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
