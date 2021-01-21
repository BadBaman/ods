package cn.stylefeng.guns.onlineaccess.modular.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Data
@TableName("application")
public class DataAccessFormModel {

    /**
     * 申请号id
     */
    private long id;

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
    private List<DataTypeModel> datatypedetails ;

    /**
     * 课题名称taskname
     */
    private String taskname ;


    /**
     * 课题主要参与人mainparticipants
     */
    private String mainparticipants;

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


    public List<DataTypeModel> getDataType() {
        return datatypedetails;
    }

    public void setDataType(List<DataTypeModel> datatypedetails) {
        this.datatypedetails = datatypedetails;
    }

    public String getTaskname () {
        return taskname ;
    }

    public void setTaskname (String taskname ) {
        this.taskname  = taskname ;
    }


    public String getMainparticipants() {
        return mainparticipants;
    }

    public void setMainparticipants(String mainparticipants) {
        this.mainparticipants = mainparticipants;
    }

    public DataAccessFormModel(String applicant, String status, String orgAddress, String applydate, List<DataTypeModel>  datatypedetails, String taskname , String topicKeyWords, String mainparticipants) {
        this.applicant = applicant;
        this.status = status;
        this.applydate = applydate;
        this.datatypedetails = datatypedetails;
        this.taskname  = taskname ;
        this.mainparticipants = mainparticipants;
    }
}
