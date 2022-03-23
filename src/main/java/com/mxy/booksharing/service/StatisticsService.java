package com.mxy.booksharing.service;

import com.mxy.booksharing.pojo.Notice;
import com.mxy.booksharing.pojo.Statistics;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StatisticsService {
    List<Statistics> statistics();

    int userCount();

    int rentCount();
    int InsertStaByDate(int staUserCount,int staBookCount,int satRentCount);
    List<Statistics> statisticsDate (String staDate);
}
