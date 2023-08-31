/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.service.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */

@RestController
@RequestMapping("/api")
public class ApiRestaurantsController {
    
    @Autowired
    private RestaurantsService restaurantsService;
    
    @DeleteMapping("/restaurantManager/restaurants/{restaurantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "restaurantId") int id) {
        this.restaurantsService.deleteRestaurants(id);
    }
    
    @DeleteMapping("/admin/restaurants/{restaurantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete_admin(@PathVariable(value = "restaurantId") int id) {
        this.restaurantsService.deleteRestaurants(id);
    }
    
    @DeleteMapping("/server/restaurantManager/restaurants/{restaurantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete_no_token(@PathVariable(value = "restaurantId") int id) {
        this.restaurantsService.deleteRestaurants(id);
    }
    
    @DeleteMapping("/server/admin/restaurants/{restaurantId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete_admin_no_token(@PathVariable(value = "restaurantId") int id) {
        this.restaurantsService.deleteRestaurants(id);
    }
}
