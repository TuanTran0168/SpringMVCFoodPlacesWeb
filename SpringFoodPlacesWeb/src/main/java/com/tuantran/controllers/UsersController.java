/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.pojo.Restaurants;
import com.tuantran.pojo.Users;
import com.tuantran.service.RolesService;
import com.tuantran.service.UsersService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Administrator
 */
@Controller
public class UsersController {

    @Autowired
    private RolesService rolesService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private Environment environment;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("roles", this.rolesService.getRoles());
    }

    @RequestMapping("/admin/users")
    public String users(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("msg", "NHÌN CÁI GÌ???");

        int pageSize = Integer.parseInt(this.environment.getProperty("PAGE_SIZE"));
        int countUsers = this.usersService.countUsers();
        model.addAttribute("counter", Math.ceil(countUsers * 1.0 / pageSize));

        String pageStr = params.get("page");
        String pageAllStr = params.get("pageAll");

        if (pageStr == null) {

            if (pageAllStr == null) {
                params.put("page", "1");
                model.addAttribute("users_list", this.usersService.getUsers(params));
            } else {
                model.addAttribute("users_list", this.usersService.getUsers(params));
            }

        } else {
            model.addAttribute("users_list", this.usersService.getUsers(params));
        }

        return "users";
    }

    @GetMapping("/admin/users/newUser")
    public String newRestaurant(Model model) {
        model.addAttribute("user", new Users());
        return "newUser";
    }

//  Cái userId trong cái GetMapping này là trùng với bên jsp nha :)
    @GetMapping("/admin/users/{userId}")
    public String update(Model model, @PathVariable(value = "userId") int userId) {
        model.addAttribute("user", this.usersService.getUserById(userId));
        return "newUser";
    }

    @PostMapping("/admin/users/newUser")
    public String add(Model model, @ModelAttribute(value = "user") @Valid Users user, BindingResult rs) {
        String msg = "";
        if (!rs.hasErrors()) {
            // update
            if (user.getUserId() != null) {
                if (this.usersService.addOrUpdateUsers(user) == true) {
                    return "redirect:/admin/users";
                }
            //add
            } else {
                if (user.getPassword().equals(user.getConfirmPassword())) {
                    if (this.usersService.addOrUpdateUsers(user) == true) {
                        return "redirect:/admin/users";
                    }
                    else {
                        msg = "OK BUGS";
                    }
                }
                else {
                    msg = "Mật khẩu không khớp";
                }
            }
        }
        model.addAttribute("msg", msg);
        return "newUser";
    }
}
