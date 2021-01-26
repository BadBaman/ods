package cn.stylefeng.guns.onlineaccess.modular.mapper;

import cn.stylefeng.guns.onlineaccess.modular.entity.Application;
import cn.stylefeng.guns.onlineaccess.modular.result.ApplicationResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplicationMapper  extends BaseMapper<Application> {

    List<Application> getApplicationByUserIdAndProjectIdResult(Page page, Long projectId, Long userId);

    List<Application> getApplicationByUserId(Page page,Long id);

    List<Application> getApplicantByApplicant(Page page,Long applicant);
}
