/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.pojo.CategoriesFood;
import com.tuantran.pojo.ShelfLife;
import com.tuantran.service.ShelfLifeService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;

/**
 *
 * @author HP
 */
@Controller
public class ShelfLifeController {

    @Autowired
    private ShelfLifeService shelfLifeSer;

    @Autowired
    private CustomDateEditor MY_CustomDateEditor;

    @Autowired
    private SimpleDateFormat MY_FORMAT_VIEW;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, MY_CustomDateEditor);
    }

    @GetMapping("/restaurantManager/shelfLife")
    public String indexShelfLife(Model model, @RequestParam Map<String, String> params) throws ParseException {
        List<ShelfLife> listShelfLife = this.shelfLifeSer.getShelfLife(params);

        model.addAttribute("shelfLife", new ShelfLife());
        model.addAttribute("shelfLifes", listShelfLife);
        return "shelfLife";
    }
    
    @PostMapping("/restaurantManager/shelfLife")
    public String addCategory_new(Model model, @ModelAttribute(value = "shelfLife") @Valid ShelfLife shelfLife, BindingResult rs, @RequestParam Map<String, String> params, Authentication authentication) {
        String msg = "";
         if (!rs.hasErrors()) {
            if (this.shelfLifeSer.addOrUpdateShelfLife(shelfLife) == true) {
                return "redirect:/restaurantManager/shelfLife?restaurantId=" + shelfLife.getRestaurantId().getRestaurantId();
            }
        }
        model.addAttribute("msg", msg);
        return "redirect:/restaurantManager/restaurants";
    }

    //=============================================//
    @GetMapping("/restaurantManager/shelfLife/newShelfLife")
    public String newShelfLife(Model model) {
        model.addAttribute("shelfLife", new ShelfLife());
        return "newShelfLife";
    }

    @PostMapping("/restaurantManager/shelfLife/newShelfLife")
    public String addShelfLife(@ModelAttribute(value = "shelfLife") @Valid ShelfLife shelfLife, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.shelfLifeSer.addOrUpdateShelfLife(shelfLife) == true) {
                return "redirect:/restaurantManager/shelfLife";
            }
        }
        return "newShelfLife";
    }

    @GetMapping("/restaurantManager/shelfLife/newShelfLife/{shelflifeId}")
    public String update(Model model, @PathVariable(value = "shelflifeId") int shelflifeId) {
        model.addAttribute("shelfLife", this.shelfLifeSer.getShelfLifeById(shelflifeId));
        return "newShelfLife";
    }
}
