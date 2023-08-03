/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.pojo;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "order_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderStatus.findAll", query = "SELECT o FROM OrderStatus o"),
    @NamedQuery(name = "OrderStatus.findByStatusOrderId", query = "SELECT o FROM OrderStatus o WHERE o.statusOrderId = :statusOrderId"),
    @NamedQuery(name = "OrderStatus.findByStatusOrder", query = "SELECT o FROM OrderStatus o WHERE o.statusOrder = :statusOrder"),
    @NamedQuery(name = "OrderStatus.findByActive", query = "SELECT o FROM OrderStatus o WHERE o.active = :active")})
public class OrderStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "status_order_id")
    private Integer statusOrderId;
    @Size(max = 255)
    @Column(name = "status_order")
    private String statusOrder;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne
    private Orders orderId;

    public OrderStatus() {
    }

    public OrderStatus(Integer statusOrderId) {
        this.statusOrderId = statusOrderId;
    }

    public Integer getStatusOrderId() {
        return statusOrderId;
    }

    public void setStatusOrderId(Integer statusOrderId) {
        this.statusOrderId = statusOrderId;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusOrderId != null ? statusOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderStatus)) {
            return false;
        }
        OrderStatus other = (OrderStatus) object;
        if ((this.statusOrderId == null && other.statusOrderId != null) || (this.statusOrderId != null && !this.statusOrderId.equals(other.statusOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tuantran.pojo.OrderStatus[ statusOrderId=" + statusOrderId + " ]";
    }
    
}
