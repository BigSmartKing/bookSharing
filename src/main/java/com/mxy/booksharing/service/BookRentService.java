package com.mxy.booksharing.service;

import com.mxy.booksharing.pojo.RentAndBook;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookRentService {

    int rentBook(int userId,int currentUserId, String rentBeginDate,String rentFinishDate,int bookId);
    List<RentAndBook> myRentList(int userId);
    int SetBookStatue(int bookId);
    int SetRentStatue(int rentId);
    // 归还后，图书可租赁
    int SetBookStatueYes(int bookId);
    int SetRentStatueTo0(int rentId);
    List<RentAndBook> returnBookList(int userId);
    int DeleteRentByRentId(int rentId);
    int SetRentStatueTo1(int rentId);
    List<RentAndBook> violationINFO(int userId);
    int bookReturnInViolation(int rentId);
    List<RentAndBook> bookRentList();

}
