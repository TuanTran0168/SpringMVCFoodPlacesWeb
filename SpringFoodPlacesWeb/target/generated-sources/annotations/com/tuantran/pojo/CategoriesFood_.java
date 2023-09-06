package com.tuantran.pojo;

import com.tuantran.pojo.Fooditems;
import com.tuantran.pojo.Restaurants;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-06T13:23:30")
@StaticMetamodel(CategoriesFood.class)
public class CategoriesFood_ { 

    public static volatile SetAttribute<CategoriesFood, Fooditems> fooditemsSet;
    public static volatile SingularAttribute<CategoriesFood, Integer> categoryfoodId;
    public static volatile SingularAttribute<CategoriesFood, Boolean> active;
    public static volatile SingularAttribute<CategoriesFood, String> categoryname;
    public static volatile SingularAttribute<CategoriesFood, Restaurants> restaurantId;

}