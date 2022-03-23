package com.mxy.booksharing.dao;

import com.mxy.booksharing.pojo.Notice;
import com.mxy.booksharing.pojo.Statistics;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StatisticsMapper {
    int deleteByPrimaryKey(Integer staId);

    int insert(Statistics record);

    int insertSelective(Statistics record);

    Statistics selectByPrimaryKey(Integer staId);

    int updateByPrimaryKeySelective(Statistics record);

    int updateByPrimaryKey(Statistics record);

    @Results({
            @Result(property = "staId", column = "sta_id"),
            @Result(property = "staUserCount", column = "sta_user_count"),
            @Result(property = "staBookCount", column = "sta_book_count"),
            @Result(property = "staRentCount", column = "sta_rent_count"),
            @Result(property = "staDate", column = "sta_date")
    })
    @Select("SELECT * FROM statistics  ORDER BY sta_id DESC LIMIT 7")
    List<Statistics> statistics ();


    @Select("SELECT COUNT(*) FROM users")
    int userCount();

    @Select("SELECT COUNT(*) FROM book_rent")
    int rentCount();

    @Insert("INSERT INTO statistics(sta_user_count,sta_book_count,sta_rent_count,sta_date)" +
            "VALUES(#{staUserCount},#{staBookCount},#{satRentCount},NOW())")
    int InsertStaByDate(int staUserCount,int staBookCount,int satRentCount);

    @Results({
            @Result(property = "staId", column = "sta_id"),
            @Result(property = "staUserCount", column = "sta_user_count"),
            @Result(property = "staBookCount", column = "sta_book_count"),
            @Result(property = "staRentCount", column = "sta_rent_count"),
            @Result(property = "staDate", column = "sta_date")
    })
    @Select("SELECT * FROM statistics WHERE sta_date = #{staDate}")
    List<Statistics> statisticsDate (String staDate);

}