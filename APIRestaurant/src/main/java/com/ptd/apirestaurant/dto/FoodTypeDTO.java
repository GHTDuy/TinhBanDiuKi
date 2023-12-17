package com.ptd.apirestaurant.dto;

import jakarta.persistence.*;

public class FoodTypeDTO {
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Boolean getDisabled() {
        return isDisabled;
    }

    public void setDisabled(Boolean disabled) {
        isDisabled = disabled;
    }

    private Integer typeId;
    private String typeName;
    private Boolean isDisabled;
}
