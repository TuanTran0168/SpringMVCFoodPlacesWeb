/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.pojo.Restaurants;
import com.tuantran.service.RestaurantStatusService;
import com.tuantran.service.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Administrator
 */
@Controller
public class RestaurantsController {

    @Autowired
    private RestaurantsService restaurantsService;
    
    @Autowired
    private RestaurantStatusService restaurantStatusService;
    
    @GetMapping("/restaurants")

    public String list(Model model) {
        model.addAttribute("restaurant", new Restaurants());
        model.addAttribute("restaurantStatus_list", this.restaurantStatusService.getRestaurantsStatus());
        return "restaurants";
    }
    
    @PostMapping("/restaurants")
    public String add(@ModelAttribute(value = "restaurants") Restaurants restaurant) {
        if (restaurantsService.addOrUpdateRestaurants(restaurant) == true) {
            return "redirect:/";
        }
        return "restaurants";
    }
}
