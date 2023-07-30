/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public interface UsersRepository {

    List<Object[]> getUsers(Map<String, String> params);
    int countUsers();
}
