package com.mxy.booksharing.service;

import com.mxy.booksharing.pojo.Book;
import com.mxy.booksharing.pojo.BookAndUser;
import com.mxy.booksharing.pojo.Categories;
import jdk.jfr.Category;

import java.util.List;

public interface BookService {
    int shareBook(String isbn,String bookName,String bookAuthor,String bookLocation,String bookDetail,int bookOwner,int bookCount,int bookCategoryId);
    List<BookAndUser> bookList();
    BookAndUser bookDetail(int bookId);
    List<BookAndUser> bookListByBookName(String bookName);
    List<BookAndUser> bookListByCategory(int bookCategoryId);
    List<Categories> categoryList();
    List<Book> myShareBookList(int userId);
    Book myShareBookDetail (int bookId);
    int updateShareBook(String isbn,String bookName,String bookAuthor,String bookLocation,String bookDetail,int bookCount,int bookCategoryId,int bookId);
    int deleteBookById(int bookId);
    List<BookAndUser> bookListByAdmin();

}
