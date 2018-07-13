package com.zc.domain;

import java.util.Date;

public class Level {
    private String lId;

    private Integer lOrder;

    private String lName;

    private String lPaperId;

    private Date lCreateTm;

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId == null ? null : lId.trim();
    }

    public Integer getlOrder() {
        return lOrder;
    }

    public void setlOrder(Integer lOrder) {
        this.lOrder = lOrder;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName == null ? null : lName.trim();
    }

    public String getlPaperId() {
        return lPaperId;
    }

    public void setlPaperId(String lPaperId) {
        this.lPaperId = lPaperId == null ? null : lPaperId.trim();
    }

    public Date getlCreateTm() {
        return lCreateTm;
    }

    public void setlCreateTm(Date lCreateTm) {
        this.lCreateTm = lCreateTm;
    }
}