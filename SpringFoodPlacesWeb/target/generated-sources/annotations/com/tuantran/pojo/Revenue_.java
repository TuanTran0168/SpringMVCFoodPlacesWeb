package com.tuantran.pojo;

import com.tuantran.pojo.Fooditems;
import com.tuantran.pojo.Restaurants;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-03T20:26:53")
@StaticMetamodel(Revenue.class)
public class Revenue_ { 

    public static volatile SingularAttribute<Revenue, Fooditems> foodId;
    public static volatile SingularAttribute<Revenue, Boolean> active;
    public static volatile SingularAttribute<Revenue, Integer> revenueId;
    public static volatile SingularAttribute<Revenue, Date> saleDate;
    public static volatile SingularAttribute<Revenue, Integer> quantitySold;
    public static volatile SingularAttribute<Revenue, Restaurants> restaurantId;

}