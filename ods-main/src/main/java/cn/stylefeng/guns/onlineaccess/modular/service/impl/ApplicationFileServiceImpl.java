package cn.stylefeng.guns.onlineaccess.modular.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.stylefeng.guns.onlineaccess.modular.entity.ApplicationFile;
import cn.stylefeng.guns.onlineaccess.modular.mapper.ApplicationFileMapper;
import cn.stylefeng.guns.onlineaccess.modular.service.ApplicationFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ApplicationFileServiceImpl extends ServiceImpl<ApplicationFileMapper, ApplicationFile> implements ApplicationFileService {


    @Override
    public void add(ApplicationFile applicationFile) {
        ApplicationFile applicationFile2=new ApplicationFile();
        BeanUtil.copyProperties(applicationFile,applicationFile2);
        this.save(applicationFile2);
    }
}
