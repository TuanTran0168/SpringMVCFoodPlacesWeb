/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.repository.impl;

import com.tuantran.pojo.Fooditems;
import com.tuantran.pojo.ReceiptDetail;
import com.tuantran.pojo.Receipts;
import com.tuantran.pojo.Restaurants;
import com.tuantran.repository.StatsRepository;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author Administrator
 */
@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Autowired
    private SimpleDateFormat MY_DATE_FORMAT;
    
//    @Autowired
//    private CustomDateEditor MY_CustomDateEditor;
//    
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Date.class, MY_CustomDateEditor);
//    }
    
    @Override
    public List<Object[]> statsRevenue(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
        
        Root rootFoodItems = query.from(Fooditems.class);
        Root rootReceipts = query.from(Receipts.class);
        
        Root rootReceiptDetail = query.from(ReceiptDetail.class);
        
//        Cái này khai báo ra dù không xài nó cũng tự join dô luôn :) U là trời :) làm tốn hết tiếng đồng hồ
//        Root rootRestaurants = query.from(Restaurants.class);

        // SELECT 
        query.multiselect(
                rootFoodItems.get("foodId"),
                rootFoodItems.get("foodName"),
                rootReceiptDetail.get("amount")
//                        criteriaBuilder.sum(
//                                criteriaBuilder.prod(
//                                        rootReceiptDetail.get("unitPrice"),
//                                        rootReceiptDetail.get("quantity"))
//                        )
        );
        
        List<Predicate> predicates = new ArrayList<>();

        // WHERE JOIN BẢNG
        predicates.add(criteriaBuilder.equal(
                rootReceipts.get("receiptId"),
                rootReceiptDetail.get("receiptId"))
        );
        
        predicates.add(criteriaBuilder.equal(
                rootReceiptDetail.get("fooditemId"),
                rootFoodItems.get("foodId"))
        );

        // LỌC
        String restaurantId = params.get("restaurantId");
        
        if (restaurantId != null && !restaurantId.isEmpty()) {
            predicates.add(criteriaBuilder.equal(rootFoodItems.get("restaurantId"), Integer.parseInt(restaurantId)));

        }
        
        
        String fromDate = params.get("fromDate");
        if (fromDate != null && !fromDate.isEmpty()) {
            try {
//                String taoLao = "2023-08-08 00:00:00";
//                Timestamp fromDateStamp = new Timestamp(MY_DATE_FORMAT.parse(fromDate).getTime());
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(rootReceipts.get("receiptDate"), MY_DATE_FORMAT.parse(fromDate)));
            } catch (ParseException ex) {
                Logger.getLogger(StatsRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        String toDate = params.get("toDate");
        if (toDate != null && !toDate.isEmpty()) {
            try {
//                String taoLao = "2023-08-11 00:00:00";
//                Timestamp toDateStamp = new Timestamp(MY_DATE_FORMAT.parse(toDate).getTime());
                predicates.add(criteriaBuilder.lessThanOrEqualTo(rootReceipts.get("receiptDate"), MY_DATE_FORMAT.parse(toDate)));
            } catch (ParseException ex) {
                Logger.getLogger(StatsRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // Phần sau WHERE
        query.orderBy(criteriaBuilder.desc(rootReceiptDetail.get("amount")));
        query.where(predicates.toArray(Predicate[]::new));
        
//        query.groupBy(rootFoodItems.get("foodId"));
        
        
        Query final_query = session.createQuery(query);
        return final_query.getResultList();
    }
}
