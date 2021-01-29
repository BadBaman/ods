package cn.stylefeng.guns.onlineaccess.modular.service;

import cn.stylefeng.guns.onlineaccess.modular.entity.ApplicationDataType;
import cn.stylefeng.guns.onlineaccess.modular.entity.DataType;
import cn.stylefeng.guns.onlineaccess.modular.result.DataTypeResult;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DataTypeService extends IService<DataType> {


    /**
     * 通过项目id查询数据负责人
     *
     * @param id 查询参数
     * @author likaiyua
     * @date 2020/12/28 15:51
     */
    DataType getDataManagerByProjectIdResult(Long id);

    /**
     * 通过项目id查询数据类型数据负责人
     *
     * @param id 查询参数
     * @author likaiyua
     * @date 2020/12/28 15:51
     */
    List<DataType> getDataTypeByProjectIdResult(Long id);

    /**
     * 新建ApplicationDataType
     *
     * @param applicationDataType 添加参数
     * @author likaiyua
     * @date 2020/12/28 15:51
     */
    void add(ApplicationDataType applicationDataType);
}
