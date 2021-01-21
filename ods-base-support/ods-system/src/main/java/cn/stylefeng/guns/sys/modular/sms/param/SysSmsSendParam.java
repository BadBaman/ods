/*
Copyright [2020] [https://www.stylefeng.cn]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Guns采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：

1.请不要删除和修改根目录下的LICENSE文件。
2.请不要删除和修改Guns源码头部的版权声明。
3.请保留源码和相关描述文件的项目出处，作者声明等。
4.分发源码时候，请注明软件出处 https://gitee.com/stylefeng/guns-separation
5.在修改包名，模块名称，项目代码等时，请注明软件出处 https://gitee.com/stylefeng/guns-separation
6.若您的项目无法满足以上几点，可申请商业授权，获取Guns商业授权许可，请在官网购买授权，地址为 https://www.stylefeng.cn
 */
package cn.stylefeng.guns.sys.modular.sms.param;

import cn.stylefeng.guns.sys.modular.sms.enums.SmsSendSourceEnum;
import cn.stylefeng.guns.sys.modular.sms.enums.SmsTypeEnum;

import javax.validation.constraints.NotBlank;
import java.util.Map;
import java.util.Objects;

/**
 * 发送短信的参数
 *
 * @author stylefeng
 * @date 2018/7/5 21:19
 */
public class SysSmsSendParam {

    /**
     * 手机号
     */
    @NotBlank(message = "手机号码为空，请检查phoneNumbers参数")
    private String phoneNumbers;

    /**
     * 模板号
     */
    @NotBlank(message = "模板号为空，请检查templateCode参数")
    private String templateCode;

    /**
     * 模板中的参数
     */
    private Map<String, Object> params;

    /**
     * 发送源
     */
    private SmsSendSourceEnum smsSendSourceEnum = SmsSendSourceEnum.PC;

    /**
     * 消息类型，1验证码，2消息，默认不传为验证码
     */
    private SmsTypeEnum smsTypeEnum = SmsTypeEnum.SMS;

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public SmsSendSourceEnum getSmsSendSourceEnum() {
        return smsSendSourceEnum;
    }

    public void setSmsSendSourceEnum(SmsSendSourceEnum smsSendSourceEnum) {
        this.smsSendSourceEnum = smsSendSourceEnum;
    }

    public SmsTypeEnum getSmsTypeEnum() {
        return smsTypeEnum;
    }

    public void setSmsTypeEnum(SmsTypeEnum smsTypeEnum) {
        this.smsTypeEnum = smsTypeEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysSmsSendParam that = (SysSmsSendParam) o;
        return Objects.equals(phoneNumbers, that.phoneNumbers) &&
                Objects.equals(templateCode, that.templateCode) &&
                Objects.equals(params, that.params) &&
                smsSendSourceEnum == that.smsSendSourceEnum &&
                smsTypeEnum == that.smsTypeEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumbers, templateCode, params, smsSendSourceEnum, smsTypeEnum);
    }
}
