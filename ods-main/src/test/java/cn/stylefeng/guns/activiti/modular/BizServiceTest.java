package cn.stylefeng.guns.activiti.modular;


import cn.stylefeng.guns.activiti.modular.domin.BizLeaveVo;
import cn.stylefeng.guns.activiti.modular.service.IBizLeaveService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BizServiceTest extends BaseJunit {

    private static final Logger logger = LoggerFactory.getLogger(BizServiceTest.class);
    @Autowired
    IBizLeaveService iBizLeaveService;

    @Test
    public void testConsole(){
        logger.info("启动service测试");
    }

    @Test
    public void testSelectBizLeaveList(){
        BizLeaveVo bizLeaveVo = new BizLeaveVo();
        bizLeaveVo.setType("leave");
        Long userId = 1346705647156162562L;
        bizLeaveVo.setCreateUser(userId);
        List<BizLeaveVo> bizLeaveVos = iBizLeaveService.selectBizLeaveList(bizLeaveVo);
        logger.info("bizLeaveVos = {}",bizLeaveVos);
    }

}
