package com.zc.domain;

import java.util.Date;

public class PlayerLevelStatus {
    private String plsId;

    private String plsPlayerId;

    private String plsLevelId;

    private Integer plsStatus;

    private Date plsCreateTm;

    public String getPlsId() {
        return plsId;
    }

    public void setPlsId(String plsId) {
        this.plsId = plsId == null ? null : plsId.trim();
    }

    public String getPlsPlayerId() {
        return plsPlayerId;
    }

    public void setPlsPlayerId(String plsPlayerId) {
        this.plsPlayerId = plsPlayerId == null ? null : plsPlayerId.trim();
    }

    public String getPlsLevelId() {
        return plsLevelId;
    }

    public void setPlsLevelId(String plsLevelId) {
        this.plsLevelId = plsLevelId == null ? null : plsLevelId.trim();
    }

    public Integer getPlsStatus() {
        return plsStatus;
    }

    public void setPlsStatus(Integer plsStatus) {
        this.plsStatus = plsStatus;
    }

    public Date getPlsCreateTm() {
        return plsCreateTm;
    }

    public void setPlsCreateTm(Date plsCreateTm) {
        this.plsCreateTm = plsCreateTm;
    }
}