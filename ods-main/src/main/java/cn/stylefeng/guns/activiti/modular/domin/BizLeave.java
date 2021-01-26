package cn.stylefeng.guns.activiti.modular.domin;

import cn.stylefeng.guns.core.pojo.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 请假业务对象 biz_leave
 *
 * @author Xianlu Tech
 * @date 2019-10-11
 */
@Data
public class BizLeave extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 请假类型 */
    //@Excel(name = "请假类型")
    private String type;

    /** 标题 */
    //@Excel(name = "标题")
    private String title;

    /** 原因 */
    //@Excel(name = "原因")
    private String reason;

    /** 开始时间 */
    //@Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** 结束时间 */
    //@Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /** 请假时长，单位秒 */
    //@Excel(name = "请假时长，单位秒")
    private Long totalTime;

    /** 流程实例ID */
    //@Excel(name = "流程实例ID")
    private String instanceId;

    /** 申请人 */
    //@Excel(name = "申请人")
    private String applyUser;

    /** 申请时间 */
   // @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyTime;

    /** 实际开始时间 */
    private Date realityStartTime;

    /** 实际结束时间 */
    private Date realityEndTime;

    public void setId(Long id) {
        this.id = id;
    }


}
