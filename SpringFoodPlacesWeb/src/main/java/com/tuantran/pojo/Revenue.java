/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "revenue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revenue.findAll", query = "SELECT r FROM Revenue r"),
    @NamedQuery(name = "Revenue.findByRevenueId", query = "SELECT r FROM Revenue r WHERE r.revenueId = :revenueId"),
    @NamedQuery(name = "Revenue.findBySaleDate", query = "SELECT r FROM Revenue r WHERE r.saleDate = :saleDate"),
    @NamedQuery(name = "Revenue.findByQuantitySold", query = "SELECT r FROM Revenue r WHERE r.quantitySold = :quantitySold"),
    @NamedQuery(name = "Revenue.findByActive", query = "SELECT r FROM Revenue r WHERE r.active = :active")})
public class Revenue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "revenue_id")
    private Integer revenueId;
    @Column(name = "sale_date")
    @Temporal(TemporalType.DATE)
    private Date saleDate;
    @Column(name = "quantity_sold")
    private Integer quantitySold;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "food_id", referencedColumnName = "food_id")
    @ManyToOne
    private Fooditems foodId;
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    @ManyToOne
    private Restaurants restaurantId;

    public Revenue() {
    }

    public Revenue(Integer revenueId) {
        this.revenueId = revenueId;
    }

    public Integer getRevenueId() {
        return revenueId;
    }

    public void setRevenueId(Integer revenueId) {
        this.revenueId = revenueId;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Integer getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(Integer quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Fooditems getFoodId() {
        return foodId;
    }

    public void setFoodId(Fooditems foodId) {
        this.foodId = foodId;
    }

    public Restaurants getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Restaurants restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (revenueId != null ? revenueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revenue)) {
            return false;
        }
        Revenue other = (Revenue) object;
        if ((this.revenueId == null && other.revenueId != null) || (this.revenueId != null && !this.revenueId.equals(other.revenueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tuantran.pojo.Revenue[ revenueId=" + revenueId + " ]";
    }
    
}
