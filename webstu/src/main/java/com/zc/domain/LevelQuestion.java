package com.zc.domain;

public class LevelQuestion {
    private String lqId;

    private String lqLevelId;

    private String lqContent;

    private Integer lqOrder;

    private Integer lqVersion;

    public String getLqId() {
        return lqId;
    }

    public void setLqId(String lqId) {
        this.lqId = lqId == null ? null : lqId.trim();
    }

    public String getLqLevelId() {
        return lqLevelId;
    }

    public void setLqLevelId(String lqLevelId) {
        this.lqLevelId = lqLevelId == null ? null : lqLevelId.trim();
    }

    public String getLqContent() {
        return lqContent;
    }

    public void setLqContent(String lqContent) {
        this.lqContent = lqContent == null ? null : lqContent.trim();
    }

    public Integer getLqOrder() {
        return lqOrder;
    }

    public void setLqOrder(Integer lqOrder) {
        this.lqOrder = lqOrder;
    }

    public Integer getLqVersion() {
        return lqVersion;
    }

    public void setLqVersion(Integer lqVersion) {
        this.lqVersion = lqVersion;
    }
}