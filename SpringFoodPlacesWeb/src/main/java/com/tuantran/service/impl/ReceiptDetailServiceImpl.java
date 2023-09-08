/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service.impl;

import com.tuantran.pojo.ReceiptDetail;
import com.tuantran.repository.ReceiptDetailRepository;
import com.tuantran.service.ReceiptDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class ReceiptDetailServiceImpl implements ReceiptDetailService{

    @Autowired
    private ReceiptDetailRepository receiptDetailRepo;
    
    @Override
    public List<ReceiptDetail> getReceiptDetails(int receiptId) {
        return this.receiptDetailRepo.getReceiptDetails(receiptId);
    }

    @Override
    public List<ReceiptDetail> getReceiptDetailsByFoodId(int foodId) {
        return this.receiptDetailRepo.getReceiptDetails(foodId);
    }
    
}
