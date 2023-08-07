package com.tuantran.pojo;

import com.tuantran.pojo.Fooditems;
import com.tuantran.pojo.OrderStatus;
import com.tuantran.pojo.Users;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-06T15:54:25")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, BigDecimal> totalPayment;
    public static volatile SingularAttribute<Orders, Integer> orderId;
    public static volatile SetAttribute<Orders, OrderStatus> orderStatusSet;
    public static volatile SingularAttribute<Orders, Fooditems> foodId;
    public static volatile SingularAttribute<Orders, String> paymentMethod;
    public static volatile SingularAttribute<Orders, Boolean> active;
    public static volatile SingularAttribute<Orders, Date> orderDate;
    public static volatile SingularAttribute<Orders, Users> userId;

}