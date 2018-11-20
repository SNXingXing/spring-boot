package com.booklibrary.model;

public class BookName {
    private Integer nId;

    private String nName;

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public String getnName() {
        return nName;
    }

    public void setnName(String nName) {
        this.nName = nName == null ? null : nName.trim();
    }

    public BookName() {
    }

    public BookName(Integer nId, String nName) {
        this.nId = nId;
        this.nName = nName;
    }

    @Override
    public String toString() {
        return "BookName{" +
                "nId=" + nId +
                ", nName='" + nName + '\'' +
                '}';
    }
}