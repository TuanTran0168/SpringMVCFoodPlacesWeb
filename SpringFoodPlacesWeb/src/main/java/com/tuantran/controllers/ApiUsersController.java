/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.pojo.Users;
import com.tuantran.service.UsersService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api")
public class ApiUsersController {

    @Autowired
    private UsersService usersService;

    @DeleteMapping("/admin/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "userId") int id) {
        this.usersService.deleteUsers(id);
    }

    @GetMapping("/admin/users/")
    @CrossOrigin
    public ResponseEntity<List<Users>> list(Map<String, String> params) {
        return new ResponseEntity<>(this.usersService.getUsers(params), HttpStatus.OK);
    }

    @GetMapping("/admin/users/{roleId}")
    @CrossOrigin
    public ResponseEntity<List<Users>> list_1(@PathVariable(value = "roleId") int roleId, Map<String, String> params) {
        params.put("roleId", String.valueOf(roleId));
        return new ResponseEntity<>(this.usersService.getUsers(params), HttpStatus.OK);
    }
}
