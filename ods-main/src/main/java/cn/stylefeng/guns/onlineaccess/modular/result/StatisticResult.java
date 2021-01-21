package cn.stylefeng.guns.onlineaccess.modular.result;

import java.util.Objects;

public class StatisticResult {

    /*
     *  申请次数 applytime
     * */
    private int applytime;

    /*
     *  论文产出数量 articlenum
     * */
    private int articlenum;

    /*
     *  批准次数 approvaltime
     * */
    private int approvaltime;

    public int getApplytime() {
        return applytime;
    }

    public void setApplytime(int applytime) {
        this.applytime = applytime;
    }

    public int getArticlenum() {
        return articlenum;
    }

    public void setArticlenum(int articlenum) {
        this.articlenum = articlenum;
    }

    public int getApprovaltime() {
        return approvaltime;
    }

    public void setApprovaltime(int approvaltime) {
        this.approvaltime = approvaltime;
    }

    public StatisticResult(int applytime, int articlenum, int approvaltime) {
        this.applytime = applytime;
        this.articlenum = articlenum;
        this.approvaltime = approvaltime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticResult that = (StatisticResult) o;
        return applytime == that.applytime &&
                articlenum == that.articlenum &&
                approvaltime == that.approvaltime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(applytime, articlenum, approvaltime);
    }
}
