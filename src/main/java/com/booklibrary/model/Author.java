package com.booklibrary.model;

public class Author {
    private Integer aId;

    private String aName;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName == null ? null : aName.trim();
    }

    public Author() {

    }

    public Author(Integer aId, String aName) {
        this.aId = aId;
        this.aName = aName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                '}';
    }
}