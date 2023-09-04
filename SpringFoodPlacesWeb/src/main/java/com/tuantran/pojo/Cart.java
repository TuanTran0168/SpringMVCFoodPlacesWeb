/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.pojo;

import lombok.Data;

/**
 *
 * @author Administrator
 */

@Data
public class Cart {
    private Long foodId;
    private String foodName;
    private int quantity;
    private Double unitPrice;
    private Double amount;
}
