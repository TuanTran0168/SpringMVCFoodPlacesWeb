package com.tuantran.pojo;

import com.tuantran.pojo.Restaurants;
import com.tuantran.pojo.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-07-31T13:38:32")
@StaticMetamodel(Notifications.class)
public class Notifications_ { 

    public static volatile SingularAttribute<Notifications, Boolean> active;
    public static volatile SingularAttribute<Notifications, Integer> notificationId;
    public static volatile SingularAttribute<Notifications, String> notificationType;
    public static volatile SingularAttribute<Notifications, Restaurants> restaurantId;
    public static volatile SingularAttribute<Notifications, Users> userId;
    public static volatile SingularAttribute<Notifications, Date> notificationDate;

}