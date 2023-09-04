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
import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
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

}
