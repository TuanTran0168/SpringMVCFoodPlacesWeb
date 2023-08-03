package com.tuantran.pojo;

import com.tuantran.pojo.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-03T18:28:22")
@StaticMetamodel(OrderStatus.class)
public class OrderStatus_ { 

    public static volatile SingularAttribute<OrderStatus, String> statusOrder;
    public static volatile SingularAttribute<OrderStatus, Orders> orderId;
    public static volatile SingularAttribute<OrderStatus, Boolean> active;
    public static volatile SingularAttribute<OrderStatus, Integer> statusOrderId;

}