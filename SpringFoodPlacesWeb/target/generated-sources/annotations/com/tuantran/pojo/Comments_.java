package com.tuantran.pojo;

import com.tuantran.pojo.Fooditems;
import com.tuantran.pojo.Restaurants;
import com.tuantran.pojo.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-11T06:46:37")
@StaticMetamodel(Comments.class)
public class Comments_ { 

    public static volatile SingularAttribute<Comments, Date> createdDate;
    public static volatile SingularAttribute<Comments, Fooditems> foodId;
    public static volatile SingularAttribute<Comments, Integer> rating;
    public static volatile SingularAttribute<Comments, Integer> commentId;
    public static volatile SingularAttribute<Comments, Boolean> active;
    public static volatile SingularAttribute<Comments, String> comment;
    public static volatile SingularAttribute<Comments, String> avatar;
    public static volatile SingularAttribute<Comments, Restaurants> restaurantId;
    public static volatile SingularAttribute<Comments, Users> userId;

}