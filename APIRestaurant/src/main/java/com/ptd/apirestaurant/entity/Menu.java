/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptd.apirestaurant.entity;

import java.io.Serializable;
import java.util.Set;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 *
 * @author DELL
 */
@Entity
@Table(name = "menu")

@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByProductId", query = "SELECT m FROM Menu m WHERE m.productId = :productId"),
    @NamedQuery(name = "Menu.findByProductName", query = "SELECT m FROM Menu m WHERE m.productName = :productName"),
    @NamedQuery(name = "Menu.findByProductAvailable", query = "SELECT m FROM Menu m WHERE m.productAvailable = :productAvailable"),
    @NamedQuery(name = "Menu.findByPrice", query = "SELECT m FROM Menu m WHERE m.price = :price")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_id")
    private Integer productId;
    @Basic(optional = false)
    @Column(name = "product_name")
    private String productName;
    @Basic(optional = false)
    @Column(name = "product_available")
    private short productAvailable;
    @Basic(optional = false)
    @Column(name = "price")
    private String price;

    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
    @ManyToOne(optional = false)
    private FoodType typeId;


    public Menu() {
    }

    public Menu(Integer productId) {
        this.productId = productId;
    }

    public Menu(Integer productId, String productName, short productAvailable, String price) {
        this.productId = productId;
        this.productName = productName;
        this.productAvailable = productAvailable;
        this.price = price;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }




    public FoodType getTypeId() {
        return typeId;
    }

    public void setTypeId(FoodType typeId) {
        this.typeId = typeId;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productAvailable=" + productAvailable +
                ", price='" + price + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}
