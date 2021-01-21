package cn.stylefeng.guns.onlineaccess.modular.result;

import cn.stylefeng.guns.onlineaccess.modular.model.DataTypeModel;
import cn.stylefeng.guns.sys.modular.emp.result.SysEmpInfo;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


/**
 * 数据访问申请列表结果
 *
 * @author likaiyuan
 * @date 2020/12/28 15:51
 */
@TableName("application")
@Builder
@AllArgsConstructor //全参构造函数
@NoArgsConstructor  //无参构造函数
public class DataAccessResult {

    /**
     * 申请号id
     */
    private int id;

    /**
     * 申请人applicant
     */
    private String applicant;

    /**
     * 状态status
     */
    private String status;

    /**
     * 申请时间applydate
     */
    private String applydate ;

    /**
     * 数据类型详细描述 datatypedetails
     */
    private String datatypedetails ;

    /**
     * 课题名称taskname
     */
    private String taskname ;

    /*
     *  项目id proId
     * */
    private long proId ;

    /*
     *  数据管理者 dataManager
     * */
    private String dataManager ;

    /**
     * 课题主要参与人mainparticipants
     */
    private String mainparticipants;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatatypedetails() {
        return datatypedetails;
    }

    public void setDatatypedetails(String datatypedetails) {
        this.datatypedetails = datatypedetails;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplydate() {
        return applydate;
    }

    public void setApplydate(String orgAddress) {
        this.applydate = applydate;
    }


    public String getTaskname () {
        return taskname ;
    }

    public void setTaskname (String taskname ) {
        this.taskname  = taskname ;
    }

    public long getProId() {
        return proId;
    }

    public void setProId(long proId) {
        this.proId = proId;
    }

    public String getDataManager() {
        return dataManager;
    }

    public void setDataManager(String dataManager) {
        this.dataManager = dataManager;
    }

    public String getMainparticipants() {
        return mainparticipants;
    }

    public void setMainparticipants(String mainparticipants) {
        this.mainparticipants = mainparticipants;
    }

    public DataAccessResult(int id,String applicant, String status, String orgAddress, String applydate, String  datatypedetails, String taskname , String topicKeyWords, String mainparticipants) {
        this.applicant = applicant;
        this.status = status;
        this.applydate = applydate;
        this.datatypedetails = datatypedetails;
        this.taskname  = taskname ;
        this.mainparticipants = mainparticipants;
    }
}
