package cn.stylefeng.guns.onlineaccess.modular.service;

import cn.stylefeng.guns.onlineaccess.modular.entity.ApplicationFile;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ApplicationFileService extends IService<ApplicationFile> {


    void add(ApplicationFile applicationFile);
}
