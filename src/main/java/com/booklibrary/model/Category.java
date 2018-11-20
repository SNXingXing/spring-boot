package com.booklibrary.model;

public class Category {
    private Integer cId;

    private String cName;

    public Integer getId() {
        return cId;
    }

    public void setId(Integer id) {
        this.cId = id;
    }

    public String getName() {
        return cName;
    }

    public void setName(String name) {
        this.cName = name == null ? null : name.trim();
    }

    public Category() {
    }

    public Category(Integer id, String name) {
        this.cId = id;
        this.cName = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                '}';
    }
}