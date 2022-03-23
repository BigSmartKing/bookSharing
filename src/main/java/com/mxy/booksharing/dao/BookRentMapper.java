package com.mxy.booksharing.dao;

import com.mxy.booksharing.pojo.BookRent;
import com.mxy.booksharing.pojo.RentAndBook;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookRentMapper {
    int deleteByPrimaryKey(Integer rentId);

    int insert(BookRent record);

    int insertSelective(BookRent record);

    BookRent selectByPrimaryKey(Integer rentId);

    int updateByPrimaryKeySelective(BookRent record);

    int updateByPrimaryKey(BookRent record);

    /**
     * 租赁图书
     */
    @Insert("INSERT INTO book_rent(rent_provider_id,rent_user_id,rent_begin_date,rent_finish_date,rent_book_id)" +
            "VALUES(#{userId},#{currentUserId},#{rentBeginDate},#{rentFinishDate},#{bookId})")
    int rentBook(int userId,int currentUserId, String rentBeginDate,String rentFinishDate,int bookId);

    //我的租赁列表
    @Results({
            @Result(property = "rentId", column = "rent_id"),
            @Result(property = "rentUserId", column = "rent_userId"),
            @Result(property = "bookOwner", column = "book_owner"),
            @Result(property = "rentBeginDate", column = "rent_begin_date"),
            @Result(property = "rentFinishDate", column = "rent_finish_date"),
            @Result(property = "rentBookId", column = "rent_book_id"),
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "isbn", column = "isbn"),
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "bookAuthor", column = "book_author"),
            @Result(property = "bookLocation", column = "book_location"),
            @Result(property = "bookDetail", column = "book_detail"),
            @Result(property = "bookCategoryId", column = "book_category_id"),
            @Result(property = "rentStatue", column = "rent_statue"),
            @Result(property = "rentExpire", column = "rent_expire")
    })
    @Select("SELECT * FROM book_rent INNER JOIN book ON book_id =rent_book_id WHERE rent_user_id = #{userId}  AND rent_statue =0")
    List<RentAndBook> myRentList(int userId);

    @Update("UPDATE book SET book_status = 1 WHERE book_id = #{bookId}")
    int SetBookStatue(int bookId);


    // 提交归还申请
    @Update("UPDATE book_rent SET rent_statue =1  WHERE rent_id=#{rentId}")
    int SetRentStatue(int rentId);

    /**
     * book_status置0，rent_statue置0
     */
    //提交 置0 表示 提交申请结束
    @Update("UPDATE book_rent SET rent_statue =0  WHERE rent_id=#{rentId}")
    int SetRentStatueTo0(int rentId);
    // 置1，代表有问题，暂时不知道该怎么做，所以先考虑打回
    @Update("UPDATE book_rent SET rent_statue =1  WHERE rent_id=#{rentId}")
    int SetRentStatueTo1(int rentId);

    // 归还后，图书可租赁
    @Update("UPDATE book SET book_status = 0 WHERE book_id = #{bookId}")
    int SetBookStatueYes(int bookId);

    //审查图书归还列表
    @Results({
            @Result(property = "rentId", column = "rent_id"),
            @Result(property = "rentUserId", column = "rent_userId"),
            @Result(property = "bookOwner", column = "book_owner"),
            @Result(property = "rentBeginDate", column = "rent_begin_date"),
            @Result(property = "rentFinishDate", column = "rent_finish_date"),
            @Result(property = "rentBookId", column = "rent_book_id"),
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "isbn", column = "isbn"),
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "bookAuthor", column = "book_author"),
            @Result(property = "bookLocation", column = "book_location"),
            @Result(property = "bookDetail", column = "book_detail"),
            @Result(property = "bookCategoryId", column = "book_category_id"),
            @Result(property = "rentStatue", column = "rent_statue"),
            @Result(property = "rentExpire", column = "rent_expire")
    })
    @Select("SELECT * FROM book_rent INNER JOIN book ON book_id =rent_book_id WHERE rent_provider_id = #{userId} AND rent_statue =1")
    List<RentAndBook> returnBookList(int userId);

    // 从租赁表中删除
    @Delete("DELETE FROM book_rent WHERE rent_id = #{rentId}")
    int DeleteRentByRentId(int rentId);

    //违约天数
    @Results({
            @Result(property = "rentId", column = "rent_id"),
            @Result(property = "rentUserId", column = "rent_userId"),
            @Result(property = "bookOwner", column = "book_owner"),
            @Result(property = "rentBeginDate", column = "rent_begin_date"),
            @Result(property = "rentFinishDate", column = "rent_finish_date"),
            @Result(property = "rentBookId", column = "rent_book_id"),
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "isbn", column = "isbn"),
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "bookAuthor", column = "book_author"),
            @Result(property = "bookLocation", column = "book_location"),
            @Result(property = "bookDetail", column = "book_detail"),
            @Result(property = "bookCategoryId", column = "book_category_id"),
            @Result(property = "rentStatue", column = "rent_statue"),
            @Result(property = "rentExpire", column = "rent_expire")
    })
    @Select("SELECT * FROM book_rent INNER JOIN book ON book_id =rent_book_id " +
            "WHERE rent_user_id = #{userId}  AND rent_statue =0 AND TO_DAYS(NOW()) - TO_DAYS(rent_finish_date) >= 0")
    List<RentAndBook> violationINFO(int userId);


    //租赁列表
    @Results({
            @Result(property = "rentId", column = "rent_id"),
            @Result(property = "rentUserId", column = "rent_userId"),
            @Result(property = "bookOwner", column = "book_owner"),
            @Result(property = "rentBeginDate", column = "rent_begin_date"),
            @Result(property = "rentFinishDate", column = "rent_finish_date"),
            @Result(property = "rentBookId", column = "rent_book_id"),
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "isbn", column = "isbn"),
            @Result(property = "bookName", column = "book_name"),
            @Result(property = "bookAuthor", column = "book_author"),
            @Result(property = "bookLocation", column = "book_location"),
            @Result(property = "bookDetail", column = "book_detail"),
            @Result(property = "bookCategoryId", column = "book_category_id"),
            @Result(property = "rentStatue", column = "rent_statue"),
            @Result(property = "rentExpire", column = "rent_expire")
    })
    @Select("SELECT * FROM book_rent INNER JOIN book ON book_id =rent_book_id WHERE  rent_statue =0")
    List<RentAndBook> bookRentList();

}