package com.zc.condition;

public class LevelCondition {
    private String lId;

    private Integer lOrder;

    private String lName;

    private String lPaperId;

    private String sortRule;

    private Integer start;

    private Integer size;

    public String getlId() {
        return lId;
    }

    public void setlId(String lId) {
        this.lId = lId;
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
        this.lName = lName;
    }

    public String getlPaperId() {
        return lPaperId;
    }

    public void setlPaperId(String lPaperId) {
        this.lPaperId = lPaperId;
    }

    public String getSortRule() {
        return sortRule;
    }

    public void setSortRule(String sortRule) {
        this.sortRule = sortRule;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}