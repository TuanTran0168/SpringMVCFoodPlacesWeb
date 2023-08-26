package com.tuantran.pojo;

import com.tuantran.pojo.Receipts;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-08-26T15:16:27")
@StaticMetamodel(ReceiptStatus.class)
public class ReceiptStatus_ { 

    public static volatile SingularAttribute<ReceiptStatus, String> statusReceipt;
    public static volatile SingularAttribute<ReceiptStatus, Integer> statusReceiptId;
    public static volatile SingularAttribute<ReceiptStatus, Boolean> active;
    public static volatile SingularAttribute<ReceiptStatus, Receipts> receiptId;

}