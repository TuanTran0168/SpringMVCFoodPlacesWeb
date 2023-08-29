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
//        List<ShelfLife> listShelfLife_p = new ArrayList<>();
//        for (Object sl : listShelfLife) {
//            ShelfLife sl_p = (ShelfLife) sl;
//            
//            sl_p.setFromDate(MY_FORMAT_VIEW.parse(sl_p.getFromDate().toString()));
//            sl_p.setToDate(MY_FORMAT_VIEW.parse(sl_p.getToDate().toString()));
//            
//            
//            listShelfLife_p.add(sl_p);
//        }
//        
//        List<Object[]> ok = new ArrayList<>();
//        
//        for (ShelfLife loz : listShelfLife_p) {
//           Object sl_o = (Object) loz;
//           
//            Object[] sl_o_arr = (Object[]) sl_o;
//           
//           ok.add(sl_o_arr);
//        }

        model.addAttribute("shelfLifes", listShelfLife);
        return "shelfLife";
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
