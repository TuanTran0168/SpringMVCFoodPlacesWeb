/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tuantran.pojo.Restaurants;
import com.tuantran.pojo.Users;
import com.tuantran.repository.RestaurantsRepository;
import com.tuantran.service.RestaurantsService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Object[]> getRestaurants(Map<String, String> params) {
        return this.restaurantsRepo.getRestaurants(params);
    }

    @Override
    public boolean addOrUpdateRestaurants(Restaurants restaurant) {
        //Test thôi, tí nữa bỏ user ra :)
//        restaurant.setAvatar("http://it.ou.edu.vn/asset/ckfinder/userfiles/5/images/giang_vien/Thanh.png");
//        restaurant.setActive(true);
//        restaurant.setConfirmationStatus(true);
//        Users u = new Users();
//        u.setUserId(1);
//        restaurant.setUserId(u);

        if (!restaurant.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(restaurant.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                restaurant.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(RestaurantsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return this.restaurantsRepo.addOrUpdateRestaurants(restaurant);
    }

    @Override
    public Restaurants getRestaurantById(int id) {
        return this.restaurantsRepo.getRestaurantById(id);
    }

    @Override
    public boolean deleteRestaurants(int id) {
        return this.restaurantsRepo.deleteRestaurants(id);
    }

}
