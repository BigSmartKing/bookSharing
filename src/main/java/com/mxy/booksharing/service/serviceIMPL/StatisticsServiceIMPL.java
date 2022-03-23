package com.mxy.booksharing.service.serviceIMPL;

import com.mxy.booksharing.dao.StatisticsMapper;
import com.mxy.booksharing.pojo.Notice;
import com.mxy.booksharing.pojo.Statistics;
import com.mxy.booksharing.service.StatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StatisticsServiceIMPL implements StatisticsService {
    @Resource
    private StatisticsMapper statisticsMapper;

    @Override
    public List<Statistics> statistics () {
        return statisticsMapper.statistics();
    }

    @Override
    public int userCount() {
        return statisticsMapper.userCount();
    }

    @Override
    public int rentCount() {
        return statisticsMapper.rentCount();
    }

    @Override
    public int InsertStaByDate(int staUserCount, int staBookCount, int satRentCount) {
        return statisticsMapper.InsertStaByDate(staUserCount,staBookCount,satRentCount);
    }

    @Override
    public List<Statistics> statisticsDate(String staDate) {
        return statisticsMapper.statisticsDate(staDate);
    }
}
