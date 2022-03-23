package com.mxy.booksharing.pojo;

import java.util.Date;

public class Statistics {
    private Integer staId;

    private Integer staUserCount;

    private Integer staBookCount;

    private Integer staRentCount;

    private Date staDate;

    public Integer getStaId() {
        return staId;
    }

    public void setStaId(Integer staId) {
        this.staId = staId;
    }

    public Integer getStaUserCount() {
        return staUserCount;
    }

    public void setStaUserCount(Integer staUserCount) {
        this.staUserCount = staUserCount;
    }

    public Integer getStaBookCount() {
        return staBookCount;
    }

    public void setStaBookCount(Integer staBookCount) {
        this.staBookCount = staBookCount;
    }

    public Integer getStaRentCount() {
        return staRentCount;
    }

    public void setStaRentCount(Integer staRentCount) {
        this.staRentCount = staRentCount;
    }

    public Date getStaDate() {
        return staDate;
    }

    public void setStaDate(Date staDate) {
        this.staDate = staDate;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "staId=" + staId +
                ", staUserCount=" + staUserCount +
                ", staBookCount=" + staBookCount +
                ", staRentCount=" + staRentCount +
                ", staDate=" + staDate +
                '}';
    }
}