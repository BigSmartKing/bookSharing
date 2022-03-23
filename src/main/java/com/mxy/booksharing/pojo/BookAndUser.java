package com.mxy.booksharing.pojo;

public class BookAndUser {


    private int bookId;
    private String isbn;
    private String bookName;
    private String bookAuthor;
    private String bookLocation;
    private String bookDetail;
    private int bookStatus;
    private int bookOwner;
    private int bookCount;
    private int bookCategoryId;
    private String  userName;
    private String userTell;
    private int userCredit;

    @Override
    public String toString() {
        return "BookAndUser{" +
                "bookId=" + bookId +
                ", isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookLocation='" + bookLocation + '\'' +
                ", bookDetail='" + bookDetail + '\'' +
                ", bookStatus=" + bookStatus +
                ", bookOwner=" + bookOwner +
                ", bookCount=" + bookCount +
                ", bookCategoryId=" + bookCategoryId +
                ", userName='" + userName + '\'' +
                ", userTell='" + userTell + '\'' +
                ", userCredit=" + userCredit +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BookAndUser() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
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

    public int getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(int bookStatus) {
        this.bookStatus = bookStatus;
    }

    public int getBookOwner() {
        return bookOwner;
    }

    public void setBookOwner(int bookOwner) {
        this.bookOwner = bookOwner;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public int getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(int bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }



    public String getUserTell() {
        return userTell;
    }

    public void setUserTell(String userTell) {
        this.userTell = userTell;
    }

    public int getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(int userCredit) {
        this.userCredit = userCredit;
    }
}
