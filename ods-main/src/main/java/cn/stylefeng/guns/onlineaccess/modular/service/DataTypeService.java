package cn.stylefeng.guns.onlineaccess.modular.service;

import cn.stylefeng.guns.onlineaccess.modular.entity.DataType;
import cn.stylefeng.guns.onlineaccess.modular.result.DataTypeResult;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DataTypeService extends IService<DataType> {

    DataType getDataManagerByProjectIdResult(Long id);
}
