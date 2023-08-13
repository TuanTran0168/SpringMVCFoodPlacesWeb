/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service.impl;

import com.tuantran.pojo.Roles;
import com.tuantran.pojo.Users;
import com.tuantran.repository.UsersRepository;
import com.tuantran.service.UsersService;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service("userDetailsService")
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.usersRepo.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("LỖI XÁC THỰC NHA");
        } else {
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority(user.getRoleId().getRoleName()));
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(), authorities);
        }

    }

    @Override
    public boolean registerUser(Users user) {
        user.setFirstname("firstname");
        user.setLastname("lastname");
        user.setLocation("location");
        Roles r = new Roles();
        r.setRoleId(3);
        user.setRoleId(r);
        return this.usersRepo.registerUser(user);
    }

}
