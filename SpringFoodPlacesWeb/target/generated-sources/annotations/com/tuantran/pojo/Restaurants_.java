package com.tuantran.pojo;

import com.tuantran.pojo.Comments;
import com.tuantran.pojo.Fooditems;
import com.tuantran.pojo.Notifications;
import com.tuantran.pojo.RestaurantStatus;
import com.tuantran.pojo.Revenue;
import com.tuantran.pojo.Sales;
import com.tuantran.pojo.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-03T18:28:22")
@StaticMetamodel(Restaurants.class)
public class Restaurants_ { 

    public static volatile SetAttribute<Restaurants, Comments> commentsSet;
    public static volatile SetAttribute<Restaurants, Notifications> notificationsSet;
    public static volatile SetAttribute<Restaurants, Fooditems> fooditemsSet;
    public static volatile SingularAttribute<Restaurants, Boolean> confirmationStatus;
    public static volatile SetAttribute<Restaurants, Sales> salesSet;
    public static volatile SingularAttribute<Restaurants, Boolean> active;
    public static volatile SingularAttribute<Restaurants, String> avatar;
    public static volatile SingularAttribute<Restaurants, RestaurantStatus> restaurantStatus;
    public static volatile SingularAttribute<Restaurants, Integer> restaurantId;
    public static volatile SingularAttribute<Restaurants, String> mapLink;
    public static volatile SingularAttribute<Restaurants, Users> userId;
    public static volatile SetAttribute<Restaurants, Revenue> revenueSet;
    public static volatile SingularAttribute<Restaurants, String> restaurantName;
    public static volatile SingularAttribute<Restaurants, String> location;

}