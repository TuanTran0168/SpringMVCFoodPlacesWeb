/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.pojo.Users;
import com.tuantran.service.UsersService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Administrator
 */
@Controller
public class RegisterController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new Users());
        return "register";
    }
    
    @InitBinder("Users")
    public void initBinder(WebDataBinder binder) {
        binder.setAllowedFields("username", "password", "confirmPassword", "phonenumber");
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") @Valid Users user, BindingResult rs) {
        String msg = "VÃI";
        if (!rs.hasErrors()) {
            if (user.getPassword().equals(user.getConfirmPassword())) {
                if (usersService.registerUser(user) == true) {
                    return "redirect:/login";
                } else {
                    msg = "BUG rồi con";
                }
            } else {
                msg = "Mật khẩu không khớp";
            }
        } else {
            msg = "BUG BÊN JSP RỒI ĐM";
        }

        model.addAttribute("msg", msg);
        return "register";
    }
}
