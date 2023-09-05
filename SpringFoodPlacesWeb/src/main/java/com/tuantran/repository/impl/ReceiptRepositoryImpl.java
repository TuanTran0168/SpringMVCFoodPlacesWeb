/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.repository.impl;

import com.tuantran.pojo.Cart;
import com.tuantran.pojo.ReceiptDetail;
import com.tuantran.pojo.Receipts;
import com.tuantran.pojo.Users;
import com.tuantran.repository.FoodItemsRepository;
import com.tuantran.repository.ReceiptRepository;
import com.tuantran.repository.UsersRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */

@Transactional
@Repository
public class ReceiptRepositoryImpl implements ReceiptRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Autowired
    private UsersRepository userRepo;
    
    @Autowired
    private FoodItemsRepository foodItemsRepo;
    
    @Autowired
    private Environment env;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addReceipt(Map<String, Cart> carts) {
        Session session = this.factory.getObject().getCurrentSession();
        Receipts receipt = new Receipts();

        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Users user = this.userRepo.getUserByUsername_new(authentication.getName());
            
            receipt.setUserId(user);
            receipt.setReceiptDate(new Date());
            session.save(user);
            
            for (Cart cart : carts.values()) {
                ReceiptDetail receiptDetail = new ReceiptDetail();
                receiptDetail.setFooditemId(this.foodItemsRepo.getFoodItemById(Integer.parseInt(cart.getFoodId().toString())));
                receiptDetail.setReceiptId(receipt);
                receiptDetail.setQuantity(cart.getQuantity());
                receiptDetail.setUnitPrice(BigDecimal.valueOf(cart.getUnitPrice()));
                double amount = cart.getQuantity() * cart.getUnitPrice();
                receiptDetail.setAmount(BigDecimal.valueOf(amount));
                
                session.save(receiptDetail);
            }
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Receipts> getReceipts(Map<String, String> params) {
         Session session = this.factory.getObject().getCurrentSession();
//        Query query = session.createQuery("From Fooditems");
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Receipts> q = b.createQuery(Receipts.class);
        Root root = q.from(Receipts.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("userId");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("userId"), String.format("%%%s%%", kw)));
            }
//
//            String fromPrice = params.get("fromPrice");
//            if (fromPrice != null && !fromPrice.isEmpty()) {
//                predicates.add(b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(fromPrice)));
//            }
//
//            String toPrice = params.get("toPrice");
//            if (toPrice != null && !toPrice.isEmpty()) {
//                predicates.add(b.lessThanOrEqualTo(root.get("price"), Double.parseDouble(toPrice)));
//            }
//
//            String cateFoodId = params.get("cateFoodId");
//            if (cateFoodId != null && !cateFoodId.isEmpty()) {
//                predicates.add(b.equal(root.get("categoryfoodId"), Integer.valueOf(cateFoodId)));
//            }
//
//            String restaurantId = params.get("restaurantId");
//            if (restaurantId != null && !restaurantId.isEmpty()) {
//                predicates.add(b.equal(root.get("restaurantId"), Integer.valueOf(restaurantId)));
//            }
//
            q.where(predicates.toArray(Predicate[]::new));

        }

        q.orderBy(b.desc(root.get("receiptDate")));
        Query query = session.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

                query.setMaxResults(pageSize);
                query.setFirstResult((p - 1) * pageSize);
            }
        }

        return query.getResultList();
    }

}
