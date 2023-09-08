/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service;

import com.tuantran.pojo.ReceiptDetail;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface ReceiptDetailService {

    List<ReceiptDetail> getReceiptDetails(int receiptId);

    List<ReceiptDetail> getReceiptDetailsByFoodId(int foodId);
}
