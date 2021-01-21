package cn.stylefeng.guns.onlineaccess.modular.result;

import java.util.Date;

public class DataPreparationResult {

    /*
     *  数据制备id id
     * */
    private int id;

    /*
     *  申请id applicationId
     * */
    private Long applicationId;

    /*
     *  ftp账号 ftpAccount
     * */
    private String ftpAccount;


    /*
     *  ftp密码 ftpPassword
     * */
    private String ftpPassword;

    /*
     *  文件url url
     * */
    private String url;

    /*
     *  交付日期 dueTime
     * */
    private Date dueTime;

    /*
     *  文件类型 type
     * */
    private int type;

    /*
     *  状态 status
     * */
    private int status;

    /*
     *  申请映射 applicationResult
     * */
    private ApplicationResult applicationResult;
}
