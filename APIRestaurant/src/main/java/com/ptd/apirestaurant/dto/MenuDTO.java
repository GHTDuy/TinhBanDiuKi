package com.ptd.apirestaurant.dto;

import com.ptd.apirestaurant.entity.FoodType;
import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

public class MenuDTO {
    private Integer productId;
    private String productName;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public short getProductAvailable() {
        return productAvailable;
    }

    public void setProductAvailable(short productAvailable) {
        this.productAvailable = productAvailable;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Boolean getDisabled() {
        return isDisabled;
    }

    public void setDisabled(Boolean disabled) {
        isDisabled = disabled;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    private short productAvailable;
    private Double price;
    private Integer typeId;
    private Boolean isDisabled;
    private  String image;
    private MultipartFile file;
}
