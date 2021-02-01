package cn.stylefeng.guns.onlineaccess.modular.mapper;

import cn.stylefeng.guns.onlineaccess.modular.entity.Application;
import cn.stylefeng.guns.onlineaccess.modular.result.ApplicationResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApplicationMapper  extends BaseMapper<Application> {


    List<Application> getApplicationByUserIdAndProjectIdResult(Page page, Long projectId, Long userId);


    List<Application> getApplicationByUserId(Page page,Long id);



    List<ApplicationResult> getApplicantByApplicant(Page page,@Param("applicant") Long applicant);

    ApplicationResult getApplicantAndWorkflowRByApplicationId(Page page,@Param("applicationId") String applicationId);
}
