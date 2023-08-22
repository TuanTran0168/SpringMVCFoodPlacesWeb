/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service;

import com.tuantran.pojo.Restaurants;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public interface RestaurantsService {

    List<Object[]> getRestaurants(Map<String, String> params);

    boolean addOrUpdateRestaurants(Restaurants restaurant);

    Restaurants getRestaurantById(int id);

    boolean deleteRestaurants(int id);
    
     int countRestaurants(Map<String, String> params);
}
