package cn.stylefeng.guns.onlineaccess.modular.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.stylefeng.guns.onlineaccess.modular.entity.Application;
import cn.stylefeng.guns.onlineaccess.modular.mapper.DataAccessMapper;
import cn.stylefeng.guns.onlineaccess.modular.param.ConditionParam;
import cn.stylefeng.guns.onlineaccess.modular.param.DataAccessParam;
import cn.stylefeng.guns.onlineaccess.modular.result.DataAccessResult;
import cn.stylefeng.guns.onlineaccess.modular.service.DataAccessService;
import cn.stylefeng.guns.sys.modular.emp.param.SysEmpParam;
import cn.stylefeng.guns.sys.modular.user.entity.SysUser;
import cn.stylefeng.guns.sys.modular.user.factory.SysUserFactory;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Service
public class DataAccessServiceImpl extends ServiceImpl<DataAccessMapper, DataAccessResult> implements DataAccessService {

    @Resource
    private DataAccessService dataAccessService;



//    @Override
//    public StatisticModel getStatisticByProid(long proid) {
//        return null;
//    }

    @Override
    public DataAccessResult getDataAccessByApplicant(String applicant) {
        LambdaQueryWrapper<DataAccessResult> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DataAccessResult::getApplicant, applicant);
        return this.getOne(queryWrapper);
    }

    @Override
    public DataAccessResult getDataAccessSummaryByUserNameAndProId(String applicant, long proid) {
        LambdaQueryWrapper<DataAccessResult> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DataAccessResult::getApplicant, applicant).eq(DataAccessResult::getProId, proid);
        return this.getOne(queryWrapper);

    }

    @Override
    public DataAccessResult getDataAccessSummaryByConditionParam(ConditionParam conditionParam) {
        LambdaQueryWrapper<DataAccessResult> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DataAccessResult::getApplicant, conditionParam.getApplicant());
        return this.getOne(queryWrapper);
    }
//    @Override
//    public DataAccessFormSummaryModel getDataAccessSummaryByUserNameAndProId(String username, long proid) {
//        return null;
//    }
//
//    @Override
//    public DataAccessFormSummaryModel getDataAccessSummaryByConditionParam(ConditionParam conditionParam) {
//        return null;
//    }

    @Override
    public DataAccessResult getDataAccessByConditionParam(ConditionParam conditionParam) {
        return null;
    }

    @Override
    public DataAccessResult getDataAccessByApplyId(long id) {
        LambdaQueryWrapper<DataAccessResult> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DataAccessResult::getId, id);
        return this.getOne(queryWrapper);
    }

    @Override
    public DataAccessResult getDataManagerByApplyProId(long proId) {
        LambdaQueryWrapper<DataAccessResult> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DataAccessResult::getProId, proId);
        return this.getOne(queryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(DataAccessParam dataAccessParam) {

    }

//    @Override
//    public List<Dict> list(DataAccessFormModel dataAccessFormModel) {
//        return null;
//    }



//    @Override
//    public void delete(DataAccessParam dataAccessFormModel) {
//
//    }

//    @Override
//    public void edit(DataAccessFormModel dataAccessFormModel) {
//
//    }


//    @Override
//    public boolean save(DataAccessFormModel entity) {
//        return false;
//    }

//    @Override
//    public boolean saveBatch(Collection<DataAccessFormModel> entityList) {
//        return false;
//    }
//
//    @Override
//    public boolean saveOrUpdateBatch(Collection<DataAccessFormModel> entityList) {
//        return false;
//    }
}
