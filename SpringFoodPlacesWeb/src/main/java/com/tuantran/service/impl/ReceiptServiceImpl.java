/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service.impl;

import com.tuantran.pojo.Cart;
import com.tuantran.pojo.Receipts;
import com.tuantran.repository.ReceiptRepository;
import com.tuantran.service.ReceiptService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class ReceiptServiceImpl implements ReceiptService{

    @Autowired
    private ReceiptRepository receiptRepo;
    
    @Override
    public boolean addReceipt(Map<String, Cart> carts) {
        return this.receiptRepo.addReceipt(carts);
    }

    @Override
    public List<Receipts> getReceipts(Map<String, String> params) {
        return this.receiptRepo.getReceipts(params);
    }

    @Override
    public Receipts getReceiptById(int id) {
        return this.receiptRepo.getReceiptById(id);
    }
}
