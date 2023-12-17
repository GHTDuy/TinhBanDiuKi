package com.ptd.apirestaurant.dto;

import jakarta.persistence.*;

public class TableDTO {
    private Integer tableId;

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(String numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public short getIsAvilable() {
        return isAvilable;
    }

    public void setIsAvilable(short isAvilable) {
        this.isAvilable = isAvilable;
    }

    public Boolean getDisabled() {
        return isDisabled;
    }

    public void setDisabled(Boolean disabled) {
        isDisabled = disabled;
    }

    private String numberOfSeat;
    private short isAvilable;
    private Boolean isDisabled;
}
