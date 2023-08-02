/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service.impl;

import com.tuantran.pojo.Restaurants;
import com.tuantran.pojo.Users;
import com.tuantran.repository.RestaurantsRepository;
import com.tuantran.service.RestaurantsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class RestaurantsServiceImpl implements RestaurantsService {
 @Autowired
    private RestaurantsRepository restaurantsRepo;
    
    @Override
    public List<Object[]> getRestaurants() {
        return this.restaurantsRepo.getRestaurants();
    }

    @Override
    public boolean addOrUpdateRestaurants(Restaurants restaurant) {
        //Test thôi, tí nữa bỏ user ra :)
        restaurant.setAvatar("http://it.ou.edu.vn/asset/ckfinder/userfiles/5/images/giang_vien/Thanh.png");
        restaurant.setActive(true);
        restaurant.setConfirmationStatus(true);
        Users u = new Users();
        u.setUserId(1);
        restaurant.setUserId(u);
        
        return this.restaurantsRepo.addOrUpdateRestaurants(restaurant);
    }

}
