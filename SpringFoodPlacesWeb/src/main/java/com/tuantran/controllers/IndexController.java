/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.service.RolesService;
import com.tuantran.service.UsersService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Administrator
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class IndexController {

    // Có service rồi thì chỉ wire từ service thôi OK
    // Truy vấn HQL ở đây = cúc nha
    @Autowired
    private RolesService rolesService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private Environment environment;
    
    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("roles", this.rolesService.getRoles());
    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("msg", "NHÌN CÁI GÌ???");
        

        int pageSize = Integer.parseInt(this.environment.getProperty("PAGE_SIZE"));
        int countUsers = this.usersService.countUsers();
        model.addAttribute("counter", Math.ceil(countUsers * 1.0 / pageSize));

        String pageStr = params.get("page");
        String pageAllStr = params.get("pageAll");

        if (pageStr == null) {

            if (pageAllStr == null) {
                params.put("page", "1");
                model.addAttribute("users", this.usersService.getUsers(params));
            }
            else {
                model.addAttribute("users", this.usersService.getUsers(params));
            }

        } else {
            model.addAttribute("users", this.usersService.getUsers(params));
        }

        return "index";
    }
}
