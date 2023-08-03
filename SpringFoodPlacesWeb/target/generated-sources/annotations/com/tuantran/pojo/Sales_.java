package com.tuantran.pojo;

import com.tuantran.pojo.Fooditems;
import com.tuantran.pojo.Restaurants;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-03T20:26:53")
@StaticMetamodel(Sales.class)
public class Sales_ { 

    public static volatile SingularAttribute<Sales, Integer> saleId;
    public static volatile SingularAttribute<Sales, Fooditems> foodId;
    public static volatile SingularAttribute<Sales, Boolean> active;
    public static volatile SingularAttribute<Sales, Date> saleDate;
    public static volatile SingularAttribute<Sales, String> availabilityStatus;
    public static volatile SingularAttribute<Sales, Restaurants> restaurantId;

}