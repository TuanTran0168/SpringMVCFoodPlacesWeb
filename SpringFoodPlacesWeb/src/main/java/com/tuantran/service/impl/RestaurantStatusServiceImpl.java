/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service.impl;

import com.tuantran.repository.RestaurantStatusRepository;
import com.tuantran.service.RestaurantStatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */

@Service
public class RestaurantStatusServiceImpl implements RestaurantStatusService{

    @Autowired
    private RestaurantStatusRepository RestaurantStatusRepo;
    
    @Override
    public List<Object[]> getRestaurantsStatus() {
        return this.RestaurantStatusRepo.getRestaurantsStatus();
    }
    
}
