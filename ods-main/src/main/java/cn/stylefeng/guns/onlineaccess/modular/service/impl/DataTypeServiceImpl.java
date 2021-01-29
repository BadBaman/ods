package cn.stylefeng.guns.onlineaccess.modular.service.impl;

import cn.stylefeng.guns.core.factory.PageFactory;
import cn.stylefeng.guns.onlineaccess.modular.entity.ApplicationDataType;
import cn.stylefeng.guns.onlineaccess.modular.entity.DataType;
import cn.stylefeng.guns.onlineaccess.modular.entity.Project;
import cn.stylefeng.guns.onlineaccess.modular.mapper.DataTypeMapper;
import cn.stylefeng.guns.onlineaccess.modular.result.DataTypeResult;
import cn.stylefeng.guns.onlineaccess.modular.service.DataTypeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataTypeServiceImpl extends ServiceImpl<DataTypeMapper, DataType> implements DataTypeService {

    @Resource
    DataTypeService dataTypeService;


    @Override
    public DataType getDataManagerByProjectIdResult(Long id) {
        LambdaQueryWrapper<DataType> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DataType::getProjectId, id);
        return this.getOne(queryWrapper);
    }

    @Override
    public List<DataType> getDataTypeByProjectIdResult(Long id) {
        return this.baseMapper.getDataTypeByProjectIdResult(PageFactory.defaultPage(),id);
    }

    @Override
    public void add(ApplicationDataType applicationDataType) {

    }
}
