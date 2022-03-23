package com.mxy.booksharing.service.serviceIMPL;

import com.mxy.booksharing.dao.BookRentMapper;
import com.mxy.booksharing.pojo.RentAndBook;
import com.mxy.booksharing.service.BookRentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookRentServiceIMPL implements BookRentService {
    @Resource
    private BookRentMapper bookRentMapper;

    @Override
    public int rentBook(int userId, int currentUserId, String rentBeginDate, String rentFinishDate, int bookId) {
        return bookRentMapper.rentBook(userId,currentUserId,rentBeginDate,rentFinishDate,bookId);
    }

    @Override
    public List<RentAndBook> myRentList(int userId) {
        return bookRentMapper.myRentList(userId);
    }

    @Override
    public int SetBookStatue(int bookId) {
        return bookRentMapper.SetBookStatue(bookId);
    }

    @Override
    public int SetRentStatue(int rentId) {
        return bookRentMapper.SetRentStatue(rentId);
    }

    @Override
    public int SetBookStatueYes(int bookId) {
        return bookRentMapper.SetBookStatueYes(bookId);
    }

    @Override
    public int SetRentStatueTo0(int rentId) {
        return bookRentMapper.SetRentStatueTo0(rentId);
    }

    @Override
    public List<RentAndBook> returnBookList(int userId) {
        return bookRentMapper.returnBookList(userId);
    }

    @Override
    public int DeleteRentByRentId(int rentId) {
        return bookRentMapper.DeleteRentByRentId(rentId);
    }

    @Override
    public int SetRentStatueTo1(int rentId) {
        return bookRentMapper.DeleteRentByRentId(rentId);
    }

    @Override
    public List<RentAndBook> violationINFO(int userId) {
        return bookRentMapper.violationINFO(userId);
    }

    @Override
    public int bookReturnInViolation(int rentId) {
        return 0;
    }

    @Override
    public List<RentAndBook> bookRentList() {
        return bookRentMapper.bookRentList();
    }
}
