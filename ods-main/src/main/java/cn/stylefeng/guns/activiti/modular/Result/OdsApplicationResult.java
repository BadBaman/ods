package cn.stylefeng.guns.activiti.modular.Result;

import cn.stylefeng.guns.onlineaccess.modular.result.ApplicationResult;
import lombok.Data;

import java.util.Date;

@Data
public class OdsApplicationResult  {

    /**
     * 用户姓名
     */
    String username;

    /**
     * 流程id
     */
    String taskId;

    /**
     * 流程名称
     */
    String taskName;
    /**
     * 完成时间
     */
    Date doneTime;

    ApplicationResult applicationResult;

}
