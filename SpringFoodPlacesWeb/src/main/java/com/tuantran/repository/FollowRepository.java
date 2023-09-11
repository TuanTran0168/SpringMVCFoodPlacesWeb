/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.repository;

import com.tuantran.pojo.Follow;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public interface FollowRepository {
    int addFollow (Follow follow);
    Follow getFollowByUserIdAndRestaurantId (int userId, int restaurantId);
    Follow checkFollow (Follow follow);
    List<Follow> getFollowByRestaurantId (int restaurantId);
}
