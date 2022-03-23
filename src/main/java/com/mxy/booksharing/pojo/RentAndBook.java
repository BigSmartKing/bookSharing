package com.mxy.booksharing.pojo;

import java.util.Date;

public class RentAndBook {
    private int rentId;
    //租赁者
    private int rentUserId;
    //提供人
    private int bookOwner;

    private Date rentBeginDate;
    private Date rentFinishDate;

    private int rentBookId;
    //private int rentPenalty;
    private String bookId;
    private String isbn;
    private String bookName;
    private String bookAuthor;
    private String bookLocation;
    private String bookDetail;
    private int bookCategoryId;
    //是否到期
    private int rentExpire;
    private int rentStatue;

    // 违约天数
    private  int violationDate;

    public int getViolationDate() {
        return violationDate;
    }

    public void setViolationDate(int violationDate) {
        this.violationDate = violationDate;
    }

    public int getRentStatue() {
        return rentStatue;
    }

    public void setRentStatue(int rentStatue) {
        this.rentStatue = rentStatue;
    }

    public RentAndBook() {
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public int getRentUserId() {
        return rentUserId;
    }

    public void setRentUserId(int rentUserId) {
        this.rentUserId = rentUserId;
    }

    public int getBookOwner() {
        return bookOwner;
    }

    public void setBookOwner(int bookOwner) {
        this.bookOwner = bookOwner;
    }

    public Date getRentBeginDate() {
        return rentBeginDate;
    }

    public void setRentBeginDate(Date rentBeginDate) {
        this.rentBeginDate = rentBeginDate;
    }

    public Date getRentFinishDate() {
        return rentFinishDate;
    }

    public void setRentFinishDate(Date rentFinishDate) {
        this.rentFinishDate = rentFinishDate;
    }

    public int getRentBookId() {
        return rentBookId;
    }

    public void setRentBookId(int rentBookId) {
        this.rentBookId = rentBookId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookLocation() {
        return bookLocation;
    }

    public void setBookLocation(String bookLocation) {
        this.bookLocation = bookLocation;
    }

    public String getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(String bookDetail) {
        this.bookDetail = bookDetail;
    }

    public int getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(int bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public int getRentExpire() {
        return rentExpire;
    }

    public void setRentExpire(int rentExpire) {
        this.rentExpire = rentExpire;
    }
}
