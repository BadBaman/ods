package cn.stylefeng.guns.core.pojo.base.validate;

import java.util.Objects;

/**
 * 校验参数时用的方法参数
 *
 * @author fengshuonan
 * @date 2020/8/17 21:43
 */
public class UniqueValidateParam {

    /**
     * 表名称
     */
    String tableName;

    /**
     * 列名称
     */
    String columnName;

    /**
     * 被参数校验时候的字段的值
     */
    String value;

    /**
     * 校验时，是否排除当前的记录
     */
    Boolean excludeCurrentRecord;

    /**
     * 当前记录的主键id
     */
    Long id;

    /**
     * 排除所有被逻辑删除的记录的控制
     */
    Boolean excludeLogicDeleteItems;

    /**
     * 逻辑删除的字段名
     */
    String logicDeleteFieldName;

    /**
     * 逻辑删除的字段的值
     */
    String logicDeleteValue;

    public UniqueValidateParam(String tableName, String columnName, String value, Boolean excludeCurrentRecord, Long id, Boolean excludeLogicDeleteItems, String logicDeleteFieldName, String logicDeleteValue) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.value = value;
        this.excludeCurrentRecord = excludeCurrentRecord;
        this.id = id;
        this.excludeLogicDeleteItems = excludeLogicDeleteItems;
        this.logicDeleteFieldName = logicDeleteFieldName;
        this.logicDeleteValue = logicDeleteValue;
    }
    public static UniqueValidateParam.UniqueValidateParamBuilder builder(){
        return new UniqueValidateParam.UniqueValidateParamBuilder();
    }

    public static class UniqueValidateParamBuilder {

        String tableName;

        String columnName;

        String value;

        Boolean excludeCurrentRecord;

        Long id;

        Boolean excludeLogicDeleteItems;

        String logicDeleteFieldName;

        String logicDeleteValue;

        public UniqueValidateParamBuilder() {}

        public UniqueValidateParam.UniqueValidateParamBuilder tableName(String tableName){
            this.tableName = tableName;
            return this;
        }
        public UniqueValidateParam.UniqueValidateParamBuilder columnName(String columnName){
            this.columnName = columnName;
            return this;
        }
        public UniqueValidateParam.UniqueValidateParamBuilder value(String value){
            this.value = value;
            return this;
        }
        public UniqueValidateParam.UniqueValidateParamBuilder excludeCurrentRecord(Boolean excludeCurrentRecord){
            this.excludeCurrentRecord = excludeCurrentRecord;
            return this;
        }
        public UniqueValidateParam.UniqueValidateParamBuilder id(Long id){
            this.id = id;
            return this;
        }
        public UniqueValidateParam.UniqueValidateParamBuilder excludeLogicDeleteItems(Boolean excludeLogicDeleteItems){
            this.excludeLogicDeleteItems = excludeLogicDeleteItems;
            return this;
        }
        public UniqueValidateParam.UniqueValidateParamBuilder logicDeleteFieldName(String logicDeleteFieldName){
            this.logicDeleteFieldName = logicDeleteFieldName;
            return this;
        }
        public UniqueValidateParam.UniqueValidateParamBuilder logicDeleteValue(String logicDeleteValue){
            this.logicDeleteValue = logicDeleteValue;
            return this;
        }
        public UniqueValidateParam build(){
            return new UniqueValidateParam(this.tableName,this.columnName,this.value,this.excludeCurrentRecord,this.id,this.excludeLogicDeleteItems,this.logicDeleteFieldName,this.logicDeleteValue);
        }

        @Override
        public String toString() {
            return "UniqueValidateParam.UniqueValidateParamBuilder{" +
                    "tableName='" + tableName + '\'' +
                    ", columnName='" + columnName + '\'' +
                    ", value='" + value + '\'' +
                    ", excludeCurrentRecord=" + excludeCurrentRecord +
                    ", id=" + id +
                    ", excludeLogicDeleteItems=" + excludeLogicDeleteItems +
                    ", logicDeleteFieldName='" + logicDeleteFieldName + '\'' +
                    ", logicDeleteValue='" + logicDeleteValue + '\'' +
                    '}';
        }
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getExcludeCurrentRecord() {
        return excludeCurrentRecord;
    }

    public void setExcludeCurrentRecord(Boolean excludeCurrentRecord) {
        this.excludeCurrentRecord = excludeCurrentRecord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getExcludeLogicDeleteItems() {
        return excludeLogicDeleteItems;
    }

    public void setExcludeLogicDeleteItems(Boolean excludeLogicDeleteItems) {
        this.excludeLogicDeleteItems = excludeLogicDeleteItems;
    }

    public String getLogicDeleteFieldName() {
        return logicDeleteFieldName;
    }

    public void setLogicDeleteFieldName(String logicDeleteFieldName) {
        this.logicDeleteFieldName = logicDeleteFieldName;
    }

    public String getLogicDeleteValue() {
        return logicDeleteValue;
    }

    public void setLogicDeleteValue(String logicDeleteValue) {
        this.logicDeleteValue = logicDeleteValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniqueValidateParam that = (UniqueValidateParam) o;
        return Objects.equals(tableName, that.tableName) &&
                Objects.equals(columnName, that.columnName) &&
                Objects.equals(value, that.value) &&
                Objects.equals(excludeCurrentRecord, that.excludeCurrentRecord) &&
                Objects.equals(id, that.id) &&
                Objects.equals(excludeLogicDeleteItems, that.excludeLogicDeleteItems) &&
                Objects.equals(logicDeleteFieldName, that.logicDeleteFieldName) &&
                Objects.equals(logicDeleteValue, that.logicDeleteValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableName, columnName, value, excludeCurrentRecord, id, excludeLogicDeleteItems, logicDeleteFieldName, logicDeleteValue);
    }

    @Override
    public String toString() {
        return "UniqueValidateParam{" +
                "tableName='" + tableName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", value='" + value + '\'' +
                ", excludeCurrentRecord=" + excludeCurrentRecord +
                ", id=" + id +
                ", excludeLogicDeleteItems=" + excludeLogicDeleteItems +
                ", logicDeleteFieldName='" + logicDeleteFieldName + '\'' +
                ", logicDeleteValue='" + logicDeleteValue + '\'' +
                '}';
    }

}
