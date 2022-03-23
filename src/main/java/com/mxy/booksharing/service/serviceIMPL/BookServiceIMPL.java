package com.mxy.booksharing.service.serviceIMPL;

import com.mxy.booksharing.dao.BookMapper;
import com.mxy.booksharing.pojo.Book;
import com.mxy.booksharing.pojo.BookAndUser;
import com.mxy.booksharing.pojo.Categories;
import com.mxy.booksharing.service.BookService;
import jdk.jfr.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class BookServiceIMPL implements BookService {
    @Resource
    private BookMapper bookMapper;

    @Override
    public int shareBook(String isbn, String bookName, String bookAuthor, String bookLocation, String bookDetail,int bookOwner,int bookCount,int bookCategoryId) {
        return bookMapper.shareBook(isbn,bookName,bookAuthor,bookLocation,bookDetail,bookOwner,bookCount,bookCategoryId);
    }

    @Override
    public List<BookAndUser> bookList() {
        return bookMapper.bookList();
    }


    @Override
    public BookAndUser bookDetail(int bookId) {
        return bookMapper.bookDetail(bookId);
    }

    @Override
    public List<BookAndUser> bookListByBookName(String bookName) {
        return bookMapper.bookListByBookName(bookName);
    }

    @Override
    public List<BookAndUser> bookListByCategory(int bookCategoryId) {
        return bookMapper.bookListByCategory(bookCategoryId);
    }

    @Override
    public List<Categories> categoryList() {
        return bookMapper.categoryList();
    }

    @Override
    public List<Book> myShareBookList(int userId) {
        return bookMapper.myShareBookList(userId);
    }

    @Override
    public Book myShareBookDetail(int bookId) {
        return bookMapper.myShareBookDetail(bookId);
    }

    @Override
    public int updateShareBook(String isbn, String bookName, String bookAuthor, String bookLocation, String bookDetail, int bookCount, int bookCategoryId, int bookId) {
        return bookMapper.updateShareBook(isbn,bookName,bookAuthor,bookLocation,bookDetail,bookCount,bookCategoryId,bookId);
    }

    @Override
    public int deleteBookById(int bookId) {
        return bookMapper.deleteBookById(bookId);
    }

    @Override
    public List<BookAndUser> bookListByAdmin() {
        return bookMapper.bookListByAdmin();
    }

}
