package com.ptd.apirestaurant.dto;

import jakarta.persistence.*;

import java.util.Date;

public class ShiftDTO {
    private Integer shiftId;

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public Date getShiftTimeStart() {
        return shiftTimeStart;
    }

    public void setShiftTimeStart(Date shiftTimeStart) {
        this.shiftTimeStart = shiftTimeStart;
    }

    public Date getShiftTimeEnd() {
        return shiftTimeEnd;
    }

    public void setShiftTimeEnd(Date shiftTimeEnd) {
        this.shiftTimeEnd = shiftTimeEnd;
    }

    public Boolean getDisabled() {
        return isDisabled;
    }

    public void setDisabled(Boolean disabled) {
        isDisabled = disabled;
    }

    private Date shiftTimeStart;
    private Date shiftTimeEnd;
    private Boolean isDisabled;
}
