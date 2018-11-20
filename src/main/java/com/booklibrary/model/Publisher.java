package com.booklibrary.model;

public class Publisher {
    private Integer pId;

    private String pName;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Publisher() {
    }

    public Publisher(Integer pId, String pName) {
        this.pId = pId;
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                '}';
    }
}