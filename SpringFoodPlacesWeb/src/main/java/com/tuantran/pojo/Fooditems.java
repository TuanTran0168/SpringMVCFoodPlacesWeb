/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "fooditems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fooditems.findAll", query = "SELECT f FROM Fooditems f"),
    @NamedQuery(name = "Fooditems.findByFoodId", query = "SELECT f FROM Fooditems f WHERE f.foodId = :foodId"),
    @NamedQuery(name = "Fooditems.findByFoodName", query = "SELECT f FROM Fooditems f WHERE f.foodName = :foodName"),
    @NamedQuery(name = "Fooditems.findByAvatar", query = "SELECT f FROM Fooditems f WHERE f.avatar = :avatar"),
    @NamedQuery(name = "Fooditems.findByPrice", query = "SELECT f FROM Fooditems f WHERE f.price = :price"),
    @NamedQuery(name = "Fooditems.findByFoodType", query = "SELECT f FROM Fooditems f WHERE f.foodType = :foodType"),
    @NamedQuery(name = "Fooditems.findByActive", query = "SELECT f FROM Fooditems f WHERE f.active = :active")})
public class Fooditems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "food_id")
    private Integer foodId;
    @Size(max = 255)
    @Column(name = "food_name")
    private String foodName;
    @Size(max = 255)
    @Column(name = "avatar")
    private String avatar;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Size(max = 255)
    @Column(name = "food_type")
    private String foodType;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "foodId")
    private Set<Revenue> revenueSet;
    @OneToMany(mappedBy = "foodId")
    private Set<Comments> commentsSet;
    @OneToMany(mappedBy = "foodId")
    private Set<Orders> ordersSet;
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    @ManyToOne
    private Restaurants restaurantId;
    @OneToMany(mappedBy = "foodId")
    private Set<Sales> salesSet;

    public Fooditems() {
    }

    public Fooditems(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Set<Revenue> getRevenueSet() {
        return revenueSet;
    }

    public void setRevenueSet(Set<Revenue> revenueSet) {
        this.revenueSet = revenueSet;
    }

    @XmlTransient
    public Set<Comments> getCommentsSet() {
        return commentsSet;
    }

    public void setCommentsSet(Set<Comments> commentsSet) {
        this.commentsSet = commentsSet;
    }

    @XmlTransient
    public Set<Orders> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<Orders> ordersSet) {
        this.ordersSet = ordersSet;
    }

    public Restaurants getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Restaurants restaurantId) {
        this.restaurantId = restaurantId;
    }

    @XmlTransient
    public Set<Sales> getSalesSet() {
        return salesSet;
    }

    public void setSalesSet(Set<Sales> salesSet) {
        this.salesSet = salesSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodId != null ? foodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fooditems)) {
            return false;
        }
        Fooditems other = (Fooditems) object;
        if ((this.foodId == null && other.foodId != null) || (this.foodId != null && !this.foodId.equals(other.foodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tuantran.pojo.Fooditems[ foodId=" + foodId + " ]";
    }
    
}
