/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.pojo.ReceiptDetail;
import com.tuantran.service.ReceiptDetailService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api")
public class ApiReceiptDetailController {
    
    @Autowired
    private ReceiptDetailService receiptDetailService;
    
    @GetMapping(path = "/receipt/{receiptId}/receiptDetails/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<List<ReceiptDetail>> listReceiptDetail(@PathVariable(value = "receiptId") int receiptId) {
        return new ResponseEntity<>(this.receiptDetailService.getReceiptDetails(receiptId), HttpStatus.OK);
    }
}
