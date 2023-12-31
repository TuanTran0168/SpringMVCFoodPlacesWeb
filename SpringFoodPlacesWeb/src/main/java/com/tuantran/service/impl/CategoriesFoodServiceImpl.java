/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service.impl;

import com.tuantran.pojo.CategoriesFood;
import com.tuantran.repository.CategoryFoodRepository;
import com.tuantran.service.CategoriesFoodService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class CategoriesFoodServiceImpl implements CategoriesFoodService{
    @Autowired
    private CategoryFoodRepository categoryFoodRepo;
    @Override
    public List<CategoriesFood> getCategoriesFood(Map<String, String> params) {
        return this.categoryFoodRepo.getCategoriesFood(params);
    }

    @Override
    public int countCategoriesFood() {
        return this.categoryFoodRepo.countCategoriesFood();
    }

    @Override
    public boolean addOrUpdateCate(CategoriesFood cate) {
        return this.categoryFoodRepo.addOrUpdateCate(cate);
    }

    @Override
    public CategoriesFood getCategoryById(int id) {
        return this.categoryFoodRepo.getCategoryById(id);
    }

    @Override
    public boolean delCategory(int id) {
        return this.categoryFoodRepo.delCategory(id);
    }

    @Override
    public List<CategoriesFood> getCategoriesFoodByRestaurantId(int restaurantId) {
        return this.categoryFoodRepo.getCategoriesFoodByRestaurantId(restaurantId);
    }
    
}
