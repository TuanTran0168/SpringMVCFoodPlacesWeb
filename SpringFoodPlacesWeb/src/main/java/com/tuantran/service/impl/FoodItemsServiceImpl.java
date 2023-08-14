/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service.impl;

import com.tuantran.pojo.Fooditems;
import com.tuantran.repository.FoodItemsRepository;
import com.tuantran.service.FoodItemsService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class FoodItemsServiceImpl implements FoodItemsService{
    @Autowired
    private FoodItemsRepository foodItemRepo;
    

    @Override
    public List<Object[]> getFoodItems(Map<String, String> params) {
        return this.foodItemRepo.getFoodItems(params);
    }

    @Override
    public boolean addOrUpdateFoodItem(Fooditems foodItem) {
        return this.foodItemRepo.addOrUpdateFoodItem(foodItem);
    }

    @Override
    public Fooditems getFoodItemById(int id) {
        return this.foodItemRepo.getFoodItemById(id);
    }

    @Override
    public boolean delFoodItem(int id) {
        return this.foodItemRepo.delFoodItem(id);
    }
    
}
