package cn.stylefeng.guns.activiti.modular.service;

import cn.stylefeng.guns.onlineaccess.modular.entity.WorkFlowR;
import com.baomidou.mybatisplus.extension.service.IService;

public interface WorkFlowService extends IService<WorkFlowR> {

    WorkFlowR getWorkFlowByApplicationId(Integer application);
}
