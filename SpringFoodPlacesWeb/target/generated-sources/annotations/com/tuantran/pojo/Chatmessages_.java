package com.tuantran.pojo;

import com.tuantran.pojo.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-11T06:46:37")
@StaticMetamodel(Chatmessages.class)
public class Chatmessages_ { 

    public static volatile SingularAttribute<Chatmessages, Users> senderId;
    public static volatile SingularAttribute<Chatmessages, Date> createdDate;
    public static volatile SingularAttribute<Chatmessages, Users> receiverId;
    public static volatile SingularAttribute<Chatmessages, Integer> messageId;
    public static volatile SingularAttribute<Chatmessages, Boolean> active;
    public static volatile SingularAttribute<Chatmessages, String> messageContent;

}