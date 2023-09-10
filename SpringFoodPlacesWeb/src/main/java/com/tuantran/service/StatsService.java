/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */

public interface StatsService {
    List<Object[]> statsRevenue(Map<String, String> params);
        List<Object[]> statsRevenueByCate(Map<String, String> params);
}
