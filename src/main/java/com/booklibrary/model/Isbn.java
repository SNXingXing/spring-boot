package com.booklibrary.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Isbn {
    private Integer isbnId;

    private String isbn;

    private Integer nId;

    private Integer pId;

    private Integer aId;

    private Integer cId;

    private Date publishtime;

    private String edition;

    private Integer num;
    //查询isbn信息的同时 查询作者
    private Author author;

    //查询isbn信息的同时,查询书名
    private  BookName bookName;

    //查询isbn信息的同时,查询出版社
    private Publisher publisher;

    //查询isbn信息的同时,查询分类信息
    private Category category;


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookName getBookName() {
        return bookName;
    }

    public void setBookName(BookName bookName) {
        this.bookName = bookName;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getIsbnId() {
        return isbnId;
    }

    public void setIsbnId(Integer isbnId) {
        this.isbnId = isbnId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition == null ? null : edition.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Isbn() {
    }

    public Isbn(Integer isbnId, String isbn, Integer nId, Integer pId, Integer aId, Integer cId, Date publishtime, String edition) {
        this.isbnId = isbnId;
        this.isbn = isbn;
        this.nId = nId;
        this.pId = pId;
        this.aId = aId;
        this.cId = cId;
        this.publishtime = publishtime;
        this.edition = edition;
        this.num = num;
    }

    @Override
    public String toString() {
        SimpleDateFormat format=new SimpleDateFormat("YYYY年MM月dd日");
        String format1 = format.format(this.publishtime);
        return "Isbn{" +
                "isbnId=" + isbnId +
                ", isbn='" + isbn + '\'' +
                ", nId=" + nId +
                ", pId=" + pId +
                ", aId=" + aId +
                ", cId=" + cId +
                ", publishtime=" + format1 +
                ", edition='" + edition + '\'' +
                ", num=" + num +
                '}';
    }
}