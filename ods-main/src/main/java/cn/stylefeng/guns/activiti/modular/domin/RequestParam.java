package cn.stylefeng.guns.activiti.modular.domin;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class RequestParam {

    @Min(1)
    Integer pageNow;
    @Min(1)
    Integer pageSize;

}
