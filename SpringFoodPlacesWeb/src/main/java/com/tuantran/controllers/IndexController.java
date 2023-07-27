/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Administrator
 */

@Controller
public class IndexController {
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @RequestMapping("/")
    @Transactional
    public String index(Model model) {
        model.addAttribute("msg", "CHÀO TỤI MÀY");
        Session s = factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Roles");
        model.addAttribute("roles", q.getResultList());
        return "index";
    }
}
