package com.ptd.apirestaurant.dto;

import com.ptd.apirestaurant.entity.Order;
import jakarta.persistence.*;

public class PaymentDTO {
    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public short getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(short isSuccess) {
        this.isSuccess = isSuccess;
    }

    private Integer paymentId;
    private Double totalPrice;
    private Integer orderId;
    private short isSuccess;
}
