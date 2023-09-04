/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tuantran.service;

import com.tuantran.pojo.Fooditems;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface FoodItemsService {
    List<Fooditems> getFoodItems(Map<String, String> params);
    boolean addOrUpdateFoodItem(Fooditems foodItem);
    Fooditems getFoodItemById(int id);
    boolean delFoodItem(int id);
    List<Fooditems> getAllFoodItem();
    int countFoodItems(Map<String, String> params);
}
