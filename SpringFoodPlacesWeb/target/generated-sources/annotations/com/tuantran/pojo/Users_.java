package com.tuantran.pojo;

import com.tuantran.pojo.Chatmessages;
import com.tuantran.pojo.Comments;
import com.tuantran.pojo.Notifications;
import com.tuantran.pojo.Receipts;
import com.tuantran.pojo.Restaurants;
import com.tuantran.pojo.Roles;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-14T12:02:40")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SetAttribute<Users, Comments> commentsSet;
    public static volatile SetAttribute<Users, Restaurants> restaurantsSet;
    public static volatile SetAttribute<Users, Notifications> notificationsSet;
    public static volatile SingularAttribute<Users, String> firstname;
    public static volatile SetAttribute<Users, Receipts> receiptsSet;
    public static volatile SetAttribute<Users, Chatmessages> chatmessagesSet1;
    public static volatile SetAttribute<Users, Chatmessages> chatmessagesSet;
    public static volatile SingularAttribute<Users, Roles> roleId;
    public static volatile SingularAttribute<Users, String> phonenumber;
    public static volatile SingularAttribute<Users, Boolean> active;
    public static volatile SingularAttribute<Users, String> avatar;
    public static volatile SingularAttribute<Users, Integer> userId;
    public static volatile SingularAttribute<Users, String> lastname;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> location;
    public static volatile SingularAttribute<Users, String> username;

}