/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.formatters;

import com.tuantran.pojo.Restaurants;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Administrator
 */
public class RestaurantsFormatter implements Formatter<Restaurants> {

    @Override
    public String print(Restaurants restaurants, Locale locale) {
        return String.valueOf(restaurants.getRestaurantId());
    }

    @Override
    public Restaurants parse(String restaurantId, Locale locale) throws ParseException {
        return new Restaurants(Integer.parseInt(restaurantId));
    }

}
