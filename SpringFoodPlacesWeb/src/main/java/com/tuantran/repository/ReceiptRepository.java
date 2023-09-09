/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.repository;

import com.tuantran.pojo.Cart;
import com.tuantran.pojo.Receipts;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public interface ReceiptRepository {
    boolean addReceipt(Map<String, Cart> carts);
    List<Receipts> getReceipts(Map<String, String> params);
    Receipts getReceiptById(int id);
}
