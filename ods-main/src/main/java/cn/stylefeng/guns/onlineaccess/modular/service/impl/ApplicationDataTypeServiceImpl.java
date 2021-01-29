package cn.stylefeng.guns.onlineaccess.modular.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.stylefeng.guns.onlineaccess.modular.entity.ApplicationDataType;
import cn.stylefeng.guns.onlineaccess.modular.mapper.ApplcationDataTypeMapper;
import cn.stylefeng.guns.onlineaccess.modular.service.ApplicationDataTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ApplicationDataTypeServiceImpl extends ServiceImpl<ApplcationDataTypeMapper, ApplicationDataType> implements ApplicationDataTypeService {


    @Override
    public void add(ApplicationDataType applicationDataType) {
        ApplicationDataType applicationDataType1=new ApplicationDataType();
        BeanUtil.copyProperties(applicationDataType,applicationDataType1);
        this.save(applicationDataType1);
    }
}
