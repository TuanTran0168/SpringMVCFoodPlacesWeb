/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.pojo.Cart;
import com.tuantran.service.ReceiptService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api")
public class ApiReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @PostMapping("/pay/")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public void addReceipt(@RequestBody Map<String, Cart> carts) {
        try {
            if (carts != null && !carts.isEmpty()) {
                // Xử lý dữ liệu carts ở đây
                this.receiptService.addReceipt(carts);
            } else {
                // In thông báo nếu carts là null hoặc rỗng
                System.out.println("Không có dữ liệu carts được gửi lên.");
            }
        } catch (Exception e) {
            // In thông báo nếu có lỗi xảy ra trong quá trình xử lý carts
            System.out.println("Đã xảy ra lỗi khi xử lý dữ liệu carts: " + e.getMessage());
        }
    }
}
