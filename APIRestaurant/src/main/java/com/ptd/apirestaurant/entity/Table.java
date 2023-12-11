/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptd.apirestaurant.entity;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;


/**
 *
 * @author DELL
 */
@Entity
@jakarta.persistence.Table(name = "table")
@NamedQueries({
    @NamedQuery(name = "Table.findAll", query = "SELECT t FROM Table t"),
    @NamedQuery(name = "Table.findByTableId", query = "SELECT t FROM Table t WHERE t.tableId = :tableId"),
    @NamedQuery(name = "Table.findByNumberOfSeat", query = "SELECT t FROM Table t WHERE t.numberOfSeat = :numberOfSeat"),
    @NamedQuery(name = "Table.findByIsAvilable", query = "SELECT t FROM Table t WHERE t.isAvilable = :isAvilable")})
public class Table implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "table_id")
    private Integer tableId;
    @Basic(optional = false)
    @Column(name = "number_of_seat")
    private String numberOfSeat;
    @Basic(optional = false)
    @Column(name = "is_avilable")
    private short isAvilable;


    public Table() {
    }

    public Table(Integer tableId) {
        this.tableId = tableId;
    }

    public Table(Integer tableId, String numberOfSeat, short isAvilable) {
        this.tableId = tableId;
        this.numberOfSeat = numberOfSeat;
        this.isAvilable = isAvilable;
    }

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



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tableId != null ? tableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Table)) {
            return false;
        }
        Table other = (Table) object;
        if ((this.tableId == null && other.tableId != null) || (this.tableId != null && !this.tableId.equals(other.tableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dht.pojo.Table[ tableId=" + tableId + " ]";
    }
    
}
