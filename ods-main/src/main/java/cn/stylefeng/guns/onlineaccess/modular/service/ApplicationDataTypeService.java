package cn.stylefeng.guns.onlineaccess.modular.service;

import cn.stylefeng.guns.onlineaccess.modular.entity.ApplicationDataType;
import cn.stylefeng.guns.onlineaccess.modular.param.ProjectParam;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ApplicationDataTypeService extends IService<ApplicationDataType> {


    /**
     * 新建ApplicationDataType
     *
     * @param applicationDataType 添加参数
     * @author likaiyua
     * @date 2020/12/28 15:51
     */
    void add(ApplicationDataType applicationDataType);
}
