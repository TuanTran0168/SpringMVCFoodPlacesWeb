package com.tuantran.pojo;

import com.tuantran.pojo.Fooditems;
import com.tuantran.pojo.Receipts;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-11T06:46:37")
@StaticMetamodel(ReceiptDetail.class)
public class ReceiptDetail_ { 

    public static volatile SingularAttribute<ReceiptDetail, BigDecimal> unitPrice;
    public static volatile SingularAttribute<ReceiptDetail, BigDecimal> amount;
    public static volatile SingularAttribute<ReceiptDetail, Integer> quantity;
    public static volatile SingularAttribute<ReceiptDetail, Fooditems> fooditemId;
    public static volatile SingularAttribute<ReceiptDetail, Integer> receiptdetailId;
    public static volatile SingularAttribute<ReceiptDetail, Receipts> receiptId;

}