package com.tuantran.pojo;

import com.tuantran.pojo.ReceiptDetail;
import com.tuantran.pojo.ReceiptStatus;
import com.tuantran.pojo.Users;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-03T14:15:40")
@StaticMetamodel(Receipts.class)
public class Receipts_ { 

    public static volatile SingularAttribute<Receipts, BigDecimal> totalPayment;
    public static volatile SetAttribute<Receipts, ReceiptStatus> receiptStatusSet;
    public static volatile SingularAttribute<Receipts, Date> receiptDate;
    public static volatile SingularAttribute<Receipts, String> paymentMethod;
    public static volatile SingularAttribute<Receipts, Boolean> active;
    public static volatile SetAttribute<Receipts, ReceiptDetail> receiptDetailSet;
    public static volatile SingularAttribute<Receipts, Integer> receiptId;
    public static volatile SingularAttribute<Receipts, Users> userId;

}