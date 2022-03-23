package com.mxy.booksharing.dao;

import com.mxy.booksharing.pojo.Book;
import com.mxy.booksharing.pojo.BookAndUser;
import com.mxy.booksharing.pojo.Categories;
import com.mxy.booksharing.pojo.User;
import jdk.jfr.Category;
import org.apache.ibatis.annotations.*;

import java.lang.annotation.Inherited;
import java.util.List;

public interface BookMapper {

    /**
     * 分享图书=插入图书
     * @param isbn
     * @param bookName
     * @param bookAuthor
     * @param bookLocation
     * @param bookDetail
     * @return
     */
    @Insert("INSERT INTO book(isbn,book_name,book_author,book_location,book_detail,book_owner,book_count,book_category_id)VALUES(#{isbn},#{bookName},#{bookAuthor},#{bookLocation},#{bookDetail},#{bookOwner},#{bookCount},#{bookCategoryId})")
    int shareBook(String isbn,String bookName,String bookAuthor,String bookLocation,String bookDetail,int bookOwner,int  bookCount,int bookCategoryId);

    /**
     * 未被租赁的图书列表
     */
    @Results({
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "isbn", column = "isbn"),
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "bookAuthor", column = "book_author"),
            @Result(property = "bookLocation", column = "book_location"),
            @Result(property = "bookDetail", column = "book_detail"),
            @Result(property = "bookStatus", column = "user_status"),
            @Result(property = "bookOwner", column = "book_owner"),
            @Result(property = "bookCount", column = "book_count"),
            @Result(property = "bookCategoryId", column = "book_category_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userTell", column = "user_tell"),
            @Result(property = "userCredit", column = "user_credit")

    })
    @Select("SELECT * FROM book INNER JOIN users ON book.`book_owner` = users.`user_id` WHERE book_status =0")
    List<BookAndUser> bookList();
    /**
     * 所有图书列表
     */
    @Results({
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "isbn", column = "isbn"),
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "bookAuthor", column = "book_author"),
            @Result(property = "bookLocation", column = "book_location"),
            @Result(property = "bookDetail", column = "book_detail"),
            @Result(property = "bookStatus", column = "book_status"),
            @Result(property = "bookOwner", column = "book_owner"),
            @Result(property = "bookCount", column = "book_count"),
            @Result(property = "bookCategoryId", column = "book_category_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userTell", column = "user_tell"),
            @Result(property = "userCredit", column = "user_credit")

    })
    @Select("SELECT * FROM book INNER JOIN users ON book.`book_owner` = users.`user_id`")
    List<BookAndUser> bookListByAdmin();

    /**
     * 图书详细信息
     */
    @Results({
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "isbn", column = "isbn"),
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "bookAuthor", column = "book_author"),
            @Result(property = "bookLocation", column = "book_location"),
            @Result(property = "bookDetail", column = "book_detail"),
            @Result(property = "bookStatus", column = "user_status"),
            @Result(property = "bookOwner", column = "book_owner"),
            @Result(property = "bookCount", column = "book_count"),
            @Result(property = "bookCategoryId", column = "book_category_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userTell", column = "user_tell"),
            @Result(property = "userCredit", column = "user_credit")

    })
    @Select("SELECT * FROM book INNER JOIN users ON book.`book_owner` = users.`user_id` WHERE book_id =#{bookId}")
    BookAndUser bookDetail(int bookId);

    /**
     * 按照图书名称查询
     * @param bookName
     * @return
     */
    @Results({
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "isbn", column = "isbn"),
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "bookAuthor", column = "book_author"),
            @Result(property = "bookLocation", column = "book_location"),
            @Result(property = "bookDetail", column = "book_detail"),
            @Result(property = "bookStatus", column = "user_status"),
            @Result(property = "bookOwner", column = "book_owner"),
            @Result(property = "bookCount", column = "book_count"),
            @Result(property = "bookCategoryId", column = "book_category_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userTell", column = "user_tell"),
            @Result(property = "userCredit", column = "user_credit")

    })
    @Select("SELECT * FROM book INNER JOIN users ON book.`book_owner` = users.`user_id` WHERE book_name= #{bookName}")
    List<BookAndUser> bookListByBookName(String bookName);


    /**
     * 按照图书类别查询
     * @param bookCategoryId
     * @return
     */
    @Results({
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "isbn", column = "isbn"),
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "bookAuthor", column = "book_author"),
            @Result(property = "bookLocation", column = "book_location"),
            @Result(property = "bookDetail", column = "book_detail"),
            @Result(property = "bookStatus", column = "user_status"),
            @Result(property = "bookOwner", column = "book_owner"),
            @Result(property = "bookCount", column = "book_count"),
            @Result(property = "bookCategoryId", column = "book_category_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userTell", column = "user_tell"),
            @Result(property = "userCredit", column = "user_credit")

    })
    @Select("SELECT * FROM book INNER JOIN users ON book.`book_owner` = users.`user_id` WHERE book_category_id = #{bookCategoryId}")
    List<BookAndUser> bookListByCategory(int bookCategoryId);


    /**
     * 图书类别传到Select下拉框中
     */
    @Results({
            @Result(property = "categoryName", column = "category_name"),
            @Result(property = "categoryId", column = "category_id")
    })
    @Select("SELECT * FROM category")
    List<Categories> categoryList();

    @Results({
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "isbn", column = "isbn"),
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "bookAuthor", column = "book_author"),
            @Result(property = "bookLocation", column = "book_location"),
            @Result(property = "bookDetail", column = "book_detail"),
            @Result(property = "bookStatus", column = "book_status"),
            @Result(property = "bookOwner", column = "book_owner"),
            @Result(property = "bookCount", column = "book_count"),
            @Result(property = "bookCategoryId", column = "book_category_id")

    })
    @Select("SELECT * FROM book WHERE book_owner =#{userId}")
    List<Book> myShareBookList(int userId);

    /**
     * 我所分享的图书，随后查看
     * @param bookId
     * @return
     */
    @Results({
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "isbn", column = "isbn"),
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "bookAuthor", column = "book_author"),
            @Result(property = "bookLocation", column = "book_location"),
            @Result(property = "bookDetail", column = "book_detail"),
            @Result(property = "bookStatus", column = "book_status"),
            @Result(property = "bookOwner", column = "book_owner"),
            @Result(property = "bookCount", column = "book_count"),
            @Result(property = "bookCategoryId", column = "book_category_id")
    })
    @Select("SELECT * FROM book WHERE book_id =#{bookId}")
    Book myShareBookDetail(int bookId);

    // 更新图书信息
    @Update("UPDATE book SET isbn=#{isbn},book_name=#{bookName},book_author=#{bookAuthor},book_location=#{bookLocation},book_detail=#{bookDetail},book_count=#{bookCount},book_category_id=${bookCategoryId} WHERE book_id=#{bookId}")
    int updateShareBook(String isbn,String bookName,String bookAuthor,String bookLocation,String bookDetail,int bookCount,int bookCategoryId,int bookId);
    
    //图书信息删除
    @Delete("DELETE FROM book WHERE book_id = #{bookId}")
    int deleteBookById(int bookId);

    //逾期图书归还
    @Update("UPDATE book_rent SET rent_penalty = 1,rent_expire = 1 WHERE rent_id = #{rentId}")
    int bookReturnInViolation(int rentId);
}