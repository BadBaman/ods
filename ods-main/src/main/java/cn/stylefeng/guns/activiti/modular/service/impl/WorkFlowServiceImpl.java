package cn.stylefeng.guns.activiti.modular.service.impl;

import cn.stylefeng.guns.activiti.modular.mapper.WorkFlowMapper;
import cn.stylefeng.guns.activiti.modular.service.WorkFlowService;
import cn.stylefeng.guns.onlineaccess.modular.entity.WorkFlowR;
import cn.stylefeng.guns.onlineaccess.modular.result.DataAccessResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WorkFlowServiceImpl extends ServiceImpl<WorkFlowMapper, WorkFlowR> implements WorkFlowService {
    @Override
    public WorkFlowR getWorkFlowByApplicationId(Integer application) {
        LambdaQueryWrapper<WorkFlowR> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(WorkFlowR::getApplicationId, application);
        return this.getOne(queryWrapper);
    }
}
