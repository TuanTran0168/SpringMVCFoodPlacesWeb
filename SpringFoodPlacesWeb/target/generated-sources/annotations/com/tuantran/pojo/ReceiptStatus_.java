package com.tuantran.pojo;

import com.tuantran.pojo.Receipts;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-05T16:36:35")
@StaticMetamodel(ReceiptStatus.class)
public class ReceiptStatus_ { 

    public static volatile SetAttribute<ReceiptStatus, Receipts> receiptsSet;
    public static volatile SingularAttribute<ReceiptStatus, String> statusReceipt;
    public static volatile SingularAttribute<ReceiptStatus, Integer> statusReceiptId;
    public static volatile SingularAttribute<ReceiptStatus, Boolean> active;

}