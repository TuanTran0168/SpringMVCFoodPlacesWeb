/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.pojo.CategoriesFood;
import com.tuantran.pojo.Fooditems;
import com.tuantran.service.FoodItemsService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
public class FoodItemsController {
    @Autowired
    private FoodItemsService foodItemSer;
    
    @GetMapping("/restaurantManager/foodItems")
    public String indexFoodItems(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("foodItems", this.foodItemSer.getFoodItems(params));
        model.addAttribute("msg", "Chào");
        return "indexFoodItems";
    }
    
//    @RequestMapping("/restaurantManager/foodItems")
//    public String indexFoodItemsTest(Model model, @RequestParam Map<String, String> params){
//        model.addAttribute("foodItems", this.foodItemSer.getFoodItems(params));
//        model.addAttribute("msg", "Chào");
//        return "indexFoodItems";
//    }
    
    @GetMapping("/restaurantManager/foodItems/newFoodItems")
    public String newFoodItems(Model model){
        model.addAttribute("foodItem", new Fooditems());
        return "newFoodItems";
    }
    
    @PostMapping("/restaurantManager/foodItems/newFoodItems")
    public String addFood(@ModelAttribute(value = "foodItem") @Valid Fooditems food, BindingResult rs){
        if (!rs.hasErrors()) {
            if (this.foodItemSer.addOrUpdateFoodItem(food) == true) {
                return "redirect:/restaurantManager/foodItems";
            }
        }
        return "newFoodItems";
    }
    
    @GetMapping("/restaurantManager/foodItems/newFoodItems/{foodId}")
    public String update(Model model, @PathVariable(value = "foodId") int foodId) {
        model.addAttribute("foodItem", this.foodItemSer.getFoodItemById(foodId));
        return "newFoodItems";
    }
}
