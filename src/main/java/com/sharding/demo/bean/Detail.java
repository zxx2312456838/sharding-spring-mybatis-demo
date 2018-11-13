package com.sharding.demo.bean;

import java.util.Date;

public class Detail {

    private Integer detailId;
    private Integer usrId;
    private String detailJs;
    private Date billTm;


    public Detail(Integer detailId, Integer usrId, String detailJs, Date billTm) {
        this.detailId = detailId;
        this.usrId = usrId;
        this.detailJs = detailJs;
        this.billTm = billTm;
    }
    public Detail() {
    }

    public Integer getUsrId() {
        return usrId;
    }
    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }
    public Integer getDetailId() {
        return detailId;
    }
    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }
    public String getDetailJs() {
        return detailJs;
    }
    public void setDetailJs(String detailJs) {
        this.detailJs = detailJs == null ? null : detailJs.trim();
    }
    public Date getBillTm() {
        return billTm;
    }
    public void setBillTm(Date billTm) {
        this.billTm = billTm;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "detailId=" + detailId +
                ", usrId=" + usrId +
                ", detailJs='" + detailJs + '\'' +
                ", billTm=" + billTm +
                '}';
    }
}