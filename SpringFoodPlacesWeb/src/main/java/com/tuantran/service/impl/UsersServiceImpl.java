/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service.impl;

import com.tuantran.pojo.Users;
import com.tuantran.repository.UsersRepository;
import com.tuantran.service.UsersService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepo;

//    @Override
//    public List<Object[]> getUsers() {
//        return this.usersRepo.getUsers();
//    }

    @Override
    public List<Object[]> getUsers(Map<String, String> params) {
        return this.usersRepo.getUsers(params);
    }

    @Override
    public int countUsers() {
        return this.usersRepo.countUsers();
    }

    @Override
    public boolean addOrUpdateUsers(Users user) {
        return this.usersRepo.addOrUpdateUsers(user);
    }

    @Override
    public Users getUserById(int id) {
        return this.usersRepo.getUserById(id);
    }

}
