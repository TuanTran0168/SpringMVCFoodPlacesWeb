package com.tuantran.pojo;

import com.tuantran.pojo.CategoriesfoodFooditems;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-21T13:39:55")
@StaticMetamodel(CategoriesFood.class)
public class CategoriesFood_ { 

    public static volatile SingularAttribute<CategoriesFood, Integer> categoryfoodId;
    public static volatile SingularAttribute<CategoriesFood, String> categoryname;
    public static volatile SetAttribute<CategoriesFood, CategoriesfoodFooditems> categoriesfoodFooditemsSet;

}