/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptd.apirestaurant.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 *
 * @author DELL
 */
@Entity
@Table(name = "shift")

@NamedQueries({
    @NamedQuery(name = "Shift.findAll", query = "SELECT s FROM Shift s"),
    @NamedQuery(name = "Shift.findByShiftId", query = "SELECT s FROM Shift s WHERE s.shiftId = :shiftId"),
    @NamedQuery(name = "Shift.findByShiftTimeStart", query = "SELECT s FROM Shift s WHERE s.shiftTimeStart = :shiftTimeStart"),
    @NamedQuery(name = "Shift.findByShiftTimeEnd", query = "SELECT s FROM Shift s WHERE s.shiftTimeEnd = :shiftTimeEnd")})
public class Shift implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shift_id")
    private Integer shiftId;
    @Basic(optional = false)
    @Column(name = "shift_time_start")
    @Temporal(TemporalType.TIME)
    private Date shiftTimeStart;
    @Basic(optional = false)
    @Column(name = "shift_time_end")
    @Temporal(TemporalType.TIME)
    private Date shiftTimeEnd;


    public Shift() {
    }

    public Shift(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public Shift(Integer shiftId, Date shiftTimeStart, Date shiftTimeEnd) {
        this.shiftId = shiftId;
        this.shiftTimeStart = shiftTimeStart;
        this.shiftTimeEnd = shiftTimeEnd;
    }

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



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shiftId != null ? shiftId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shift)) {
            return false;
        }
        Shift other = (Shift) object;
        if ((this.shiftId == null && other.shiftId != null) || (this.shiftId != null && !this.shiftId.equals(other.shiftId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dht.pojo.Shift[ shiftId=" + shiftId + " ]";
    }
    
}
