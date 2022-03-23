package com.mxy.booksharing.dao;

import com.mxy.booksharing.pojo.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer noticeId);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer noticeId);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);

    /**
     * common
     * 列表
     */
    @Results({
            @Result(property = "noticeId", column = "notice_id"),
            @Result(property = "noticeTime", column = "notice_time"),
            @Result(property = "noticeTitle", column = "notice_title"),
            @Result(property = "noticeRead", column = "notice_read"),
            @Result(property = "noticeContent", column = "notice_content")
    })
    @Select("SELECT * FROM notice")
    List<Notice> noticeList();
    @Results({
            @Result(property = "noticeId", column = "notice_id"),
            @Result(property = "noticeTime", column = "notice_time"),
            @Result(property = "noticeTitle", column = "notice_title"),
            @Result(property = "noticeRead", column = "notice_read"),
            @Result(property = "noticeContent", column = "notice_content")
    })
    @Select("SELECT * FROM notice where notice_id=#{noticeId}")
    Notice noticeListById(int noticeId);

    /**
     *
     * 管理员
     * CRUD
     */
    @Insert("INSERT INTO notice(notice_time,notice_title,notice_content)VALUES(NOW(),#{noticeTitle},#{noticeContent})")
    int addNotice(String noticeTitle,String noticeContent);
    @Delete("DELETE FROM notice WHERE notice_id =#{noticeId}")
    int deleteNotice(int noticeId);
    @Update("UPDATE notice SET notice_title = #{noticeTitle},notice_content =#{noticeContent} WHERE notice_id=#{noticeId}")
    int updateNotice(String noticeTitle,String noticeContent,int noticeId);

}