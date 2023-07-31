package com.tuantran.pojo;

import com.tuantran.pojo.Comments;
import com.tuantran.pojo.Orders;
import com.tuantran.pojo.Restaurants;
import com.tuantran.pojo.Revenue;
import com.tuantran.pojo.Sales;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-07-31T13:38:32")
@StaticMetamodel(Fooditems.class)
public class Fooditems_ { 

    public static volatile SetAttribute<Fooditems, Comments> commentsSet;
    public static volatile SingularAttribute<Fooditems, String> foodName;
    public static volatile SetAttribute<Fooditems, Sales> salesSet;
    public static volatile SingularAttribute<Fooditems, BigDecimal> price;
    public static volatile SingularAttribute<Fooditems, String> foodType;
    public static volatile SingularAttribute<Fooditems, Integer> foodId;
    public static volatile SingularAttribute<Fooditems, Boolean> active;
    public static volatile SetAttribute<Fooditems, Orders> ordersSet;
    public static volatile SingularAttribute<Fooditems, Restaurants> restaurantId;
    public static volatile SetAttribute<Fooditems, Revenue> revenueSet;

}