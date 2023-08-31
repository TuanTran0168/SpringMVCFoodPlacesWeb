/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tuantran.pojo.Roles;
import com.tuantran.pojo.Users;
import com.tuantran.repository.UsersRepository;
import com.tuantran.service.UsersService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 */
@Service("userDetailsService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private Cloudinary cloudinary;

//    @Override
//    public List<Object[]> getUsers() {
//        return this.usersRepo.getUsers();
//    }
    @Override
    public List<Users> getUsers(Map<String, String> params) {
        return this.usersRepo.getUsers(params);
    }

    @Override
    public int countUsers() {
        return this.usersRepo.countUsers();
    }

    @Override
    public boolean addOrUpdateUsers(Users user) {

        boolean isUsernameExists = this.usersRepo.isUsernameExists(user.getUsername());

        if (isUsernameExists == true) {
            return false;
        } else {
            if (!user.getFile().isEmpty()) {
                try {
                    Map res = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                    user.setAvatar(res.get("secure_url").toString());
                } catch (IOException ex) {
                    Logger.getLogger(RestaurantsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            String password = user.getPassword();
            user.setPassword(this.bCryptPasswordEncoder.encode(password));
            return this.usersRepo.addOrUpdateUsers(user);
        }

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

        boolean isUsernameExists = this.usersRepo.isUsernameExists(user.getUsername());

        if (isUsernameExists == true) {
            return false;
        } else {
            String password = user.getPassword();
            user.setPassword(this.bCryptPasswordEncoder.encode(password));
            user.setRoleId(new Roles(3));
            return this.usersRepo.registerUser(user);
        }

//        try {
//            
//            return false;
//
//        } catch (UsernameNotFoundException ex) {
//            String password = user.getPassword();
//            user.setPassword(this.bCryptPasswordEncoder.encode(password));
//            user.setRoleId(new Roles(3));
//            return this.usersRepo.registerUser(user);
//        }
    }

    @Override
    public boolean isUsernameExists(String username) {
        return this.usersRepo.isUsernameExists(username);
    }

    @Override
    public boolean deleteUsers(int id) {
        return this.usersRepo.deleteUsers(id);
    }

    @Override
    public Users getUserByUsername_new(String username) {
        return this.usersRepo.getUserByUsername_new(username);
    }

    @Override
    public boolean authUser(String username, String password) {
        return this.usersRepo.authUser(username, password);
    }

    //api register
    @Override
    public Users addUser(Map<String, String> params, MultipartFile avatar) {
        boolean isUsernameExists = this.usersRepo.isUsernameExists(params.get("username"));

        if (isUsernameExists == true) {
            return null;
        } else {
            Users user = new Users();
            user.setFirstname(params.get("firstname"));
            user.setLastname(params.get("lastname"));
            user.setPhonenumber(params.get("phonenumber"));
            user.setLocation(params.get("location"));
//        user.setEmail(params.get("email"));
            user.setUsername(params.get("username"));
            user.setPassword(this.bCryptPasswordEncoder.encode(params.get("password")));
            user.setRoleId(new Roles(3));
            if (!avatar.isEmpty()) {
                try {
                    Map res = this.cloudinary.uploader().upload(avatar.getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    user.setAvatar(res.get("secure_url").toString());
                } catch (IOException ex) {
                    Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.usersRepo.addUser(user);
            return user;
        }
    }

}
