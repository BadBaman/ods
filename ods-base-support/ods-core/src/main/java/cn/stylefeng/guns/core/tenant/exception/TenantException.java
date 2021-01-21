package cn.stylefeng.guns.core.tenant.exception;

import cn.stylefeng.guns.core.exception.ServiceException;
import cn.stylefeng.guns.core.exception.enums.abs.AbstractBaseExceptionEnum;

/**
 * 多租户的异常
 *
 * @author fengshuonan
 * @date 2020/9/3
 */
public class TenantException extends ServiceException {

    public TenantException(AbstractBaseExceptionEnum exception) {
        super(exception);
    }

}
