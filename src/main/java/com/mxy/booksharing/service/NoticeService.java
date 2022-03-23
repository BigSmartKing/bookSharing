package com.mxy.booksharing.service;

import com.mxy.booksharing.pojo.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NoticeService {
    List<Notice> noticeList();
    int addNotice(String noticeTitle,String noticeContent);
    int deleteNotice(int noticeId);
    int updateNotice(String noticeTitle,String noticeContent,int noticeId);
    Notice noticeListById(int noticeId);
}
