package cn.stylefeng.guns.onlineaccess.modular.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.stylefeng.guns.core.factory.PageFactory;
import cn.stylefeng.guns.onlineaccess.modular.entity.Application;
import cn.stylefeng.guns.onlineaccess.modular.entity.ApplicationDataType;
import cn.stylefeng.guns.onlineaccess.modular.entity.ApplicationFile;
import cn.stylefeng.guns.onlineaccess.modular.mapper.ApplicationMapper;
import cn.stylefeng.guns.onlineaccess.modular.mapper.DataAccessMapper;
import cn.stylefeng.guns.onlineaccess.modular.param.DataAccessParam;
import cn.stylefeng.guns.onlineaccess.modular.result.ApplicationResult;
import cn.stylefeng.guns.onlineaccess.modular.result.DataAccessResult;
import cn.stylefeng.guns.onlineaccess.modular.service.ApplicationDataTypeService;
import cn.stylefeng.guns.onlineaccess.modular.service.ApplicationFileService;
import cn.stylefeng.guns.onlineaccess.modular.service.ApplicationService;
import cn.stylefeng.guns.onlineaccess.modular.service.DataAccessService;
import cn.stylefeng.guns.sys.modular.file.service.SysFileInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

    @Resource
    ApplicationService applicationService;

    @Resource
    SysFileInfoService sysFileInfoService;

    @Resource
    ApplicationDataTypeService applicationDataTypeService;

    @Resource
    ApplicationFileService applicationFileService;

    @Override
    public List<Application> getApplicationByUserIdAndProjectIdResult(Long projectId, Long userId) {
        return this.baseMapper.getApplicationByUserIdAndProjectIdResult(PageFactory.defaultPage(),projectId,userId);
    }

    @Override
    public List<Application> getApplicationByUserId(Long id) {
        return this.baseMapper.getApplicationByUserId(PageFactory.defaultPage(),id);
    }

    @Override
    public List<ApplicationResult> getApplicantAndWorkflowRByApplicant(Long applicant) {
        return this.baseMapper.getApplicantByApplicant(PageFactory.defaultPage(),applicant);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(DataAccessParam dataAccessParam) {
        Application application=new Application();
        BeanUtil.copyProperties(dataAccessParam,application);
        application.setCreatedTime(new Date());
        this.save(application);
        int dataTypeId=dataAccessParam.getDataTypeId();
        Long applicationId=application.getId();
        ApplicationDataType applicationDataType=new ApplicationDataType();
        applicationDataType.setApplicationId(applicationId);
        applicationDataType.setDataTypeId(dataTypeId);
        applicationDataTypeService.add(applicationDataType);
        MultipartFile file=dataAccessParam.getFile();
        if(file!=null){
            Long fileId=sysFileInfoService.uploadFile(file);
            ApplicationFile applicationFile=new ApplicationFile();
            applicationFile.setApplicationId(applicationId);
            applicationFile.setFileId(fileId);
            applicationFileService.add(applicationFile);
        }
    }
}
