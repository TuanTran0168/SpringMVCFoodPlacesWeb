/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service;

import com.tuantran.pojo.Cart;
import com.tuantran.pojo.Receipts;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */

public interface ReceiptService {
    boolean addReceipt(Map<String, Cart> carts);
    List<Receipts> getReceipts(Map<String, String> params);
}
