package com.tuantran.pojo;

import com.tuantran.pojo.Fooditems;
import com.tuantran.pojo.Restaurants;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-30T11:05:48")
@StaticMetamodel(ShelfLife.class)
public class ShelfLife_ { 

    public static volatile SingularAttribute<ShelfLife, String> shelflifeName;
    public static volatile SingularAttribute<ShelfLife, Date> fromDate;
    public static volatile SetAttribute<ShelfLife, Fooditems> fooditemsSet;
    public static volatile SingularAttribute<ShelfLife, Date> toDate;
    public static volatile SingularAttribute<ShelfLife, Restaurants> restaurantId;
    public static volatile SingularAttribute<ShelfLife, Integer> shelflifeId;

}