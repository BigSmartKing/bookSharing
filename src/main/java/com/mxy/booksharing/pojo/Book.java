package com.mxy.booksharing.pojo;

public class Book {
    private Integer bookId;

    private String isbn;

    private String bookName;

    private String bookAuthor;

    private String bookLocation;

    private String bookDetail;

    private Integer bookStatus;

    private Integer bookOwner;

    private Integer bookCategoryId;


    private  Integer bookCount;

    public Integer getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(Integer bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public Integer getBookOwner() {
        return bookOwner;
    }

    public void setBookOwner(Integer bookOwner) {
        this.bookOwner = bookOwner;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    public String getBookLocation() {
        return bookLocation;
    }

    public void setBookLocation(String bookLocation) {
        this.bookLocation = bookLocation == null ? null : bookLocation.trim();
    }

    public String getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(String bookDetail) {
        this.bookDetail = bookDetail == null ? null : bookDetail.trim();
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookLocation='" + bookLocation + '\'' +
                ", bookDetail='" + bookDetail + '\'' +
                ", bookStatus=" + bookStatus +
                ", bookOwner=" + bookOwner +
                ", bookCategoryId=" + bookCategoryId +
                ", bookCount=" + bookCount +
                '}';
    }
}