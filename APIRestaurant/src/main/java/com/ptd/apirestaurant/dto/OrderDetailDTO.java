package com.ptd.apirestaurant.dto;

import com.ptd.apirestaurant.entity.Menu;
import com.ptd.apirestaurant.entity.Order;
import com.ptd.apirestaurant.entity.OrderDetailPK;
import jakarta.persistence.*;

public class OrderDetailDTO {
    private Integer orderID;
    private Integer menuID;
    private int amount;



    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getMenuID() {
        return menuID;
    }

    public void setMenuID(Integer menuID) {
        this.menuID = menuID;
    }

    private Order order;
}
