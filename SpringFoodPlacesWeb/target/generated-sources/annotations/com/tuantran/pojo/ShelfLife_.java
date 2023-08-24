package com.tuantran.pojo;

import com.tuantran.pojo.ShelflifeFooditems;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-24T11:38:30")
@StaticMetamodel(ShelfLife.class)
public class ShelfLife_ { 

    public static volatile SingularAttribute<ShelfLife, String> shelflifeName;
    public static volatile SingularAttribute<ShelfLife, Date> fromDate;
    public static volatile SingularAttribute<ShelfLife, Date> toDate;
    public static volatile SetAttribute<ShelfLife, ShelflifeFooditems> shelflifeFooditemsSet;
    public static volatile SingularAttribute<ShelfLife, Integer> shelflifeId;

}