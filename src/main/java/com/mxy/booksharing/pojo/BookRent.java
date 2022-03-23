package com.mxy.booksharing.pojo;

import java.util.Date;

public class BookRent {
    private Integer rentId;

    private Integer rentUserId;

    private Integer rentProviderId;

    private Date rentBeginDate;

    private Date rentFinishDate;

    private Integer rentBookId;

    private Integer rentPenalty;
    private Integer rentExpire;
    private Integer rentStatue;

    public Integer getRentStatue() {
        return rentStatue;
    }

    public void setRentStatue(Integer rentStatue) {
        this.rentStatue = rentStatue;
    }

    public Integer getRentExpire() {
        return rentExpire;
    }

    public void setRentExpire(Integer rentExpire) {
        this.rentExpire = rentExpire;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Integer getRentUserId() {
        return rentUserId;
    }

    public void setRentUserId(Integer rentUserId) {
        this.rentUserId = rentUserId;
    }

    public Integer getRentProviderId() {
        return rentProviderId;
    }

    public void setRentProviderId(Integer rentProviderId) {
        this.rentProviderId = rentProviderId;
    }

    public Date getRentBeginDate() {
        return rentBeginDate;
    }

    public void setRentBeginDate(Date rentBeginDate) {
        this.rentBeginDate = rentBeginDate;
    }

    public Date getRentFinishDate() {
        return rentFinishDate;
    }

    public void setRentFinishDate(Date rentFinishDate) {
        this.rentFinishDate = rentFinishDate;
    }

    public Integer getRentBookId() {
        return rentBookId;
    }

    public void setRentBookId(Integer rentBookId) {
        this.rentBookId = rentBookId;
    }

    public Integer getRentPenalty() {
        return rentPenalty;
    }

    public void setRentPenalty(Integer rentPenalty) {
        this.rentPenalty = rentPenalty;
    }
}