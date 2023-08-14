/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.pojo.CategoriesFood;
import com.tuantran.pojo.Restaurants;
import com.tuantran.service.CategoriesFoodService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
@PropertySource("classpath:configs.properties")
public class CategoryFoodController {
    @Autowired
    private CategoriesFoodService categoriesFoodSer;
    
    @Autowired
    private Environment env;
    
    @GetMapping("/restaurantManager/categoriesFood")
    public String indexCategories(Model model, @RequestParam Map<String, String> params){
        
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        int countCate = this.categoriesFoodSer.countCategoriesFood();
        model.addAttribute("counter", Math.ceil(countCate * 1.0 / pageSize));
        
        String pageStr = params.get("page");
        String pageAllStr = params.get("pageAll");
        
        if(pageStr == null){
            if(pageAllStr == null){
                params.put("page", "1");
                model.addAttribute("categories", this.categoriesFoodSer.getCategoriesFood(params));
            }
            else{
                model.addAttribute("categories", this.categoriesFoodSer.getCategoriesFood(params));
            }
        }
        else{
            model.addAttribute("categories", this.categoriesFoodSer.getCategoriesFood(params));
        }
        
//        model.addAttribute("categories", this.categoriesFoodSer.getCategoriesFood(params));
        model.addAttribute("msg", "Category Page");
        return "indexCategories";
    }
    
    @GetMapping("/restaurantManager/categoriesFood/newCategoriesFood")
    public String indexNewCate(Model model){
        model.addAttribute("cate", new CategoriesFood());
        return "newCategory";
    }
    
    @PostMapping("/restaurantManager/categoriesFood/newCategoriesFood")
    public String addCategory(@ModelAttribute(value = "cate") @Valid CategoriesFood cate, BindingResult rs){
        if (!rs.hasErrors()) {
            if (categoriesFoodSer.addOrUpdateCate(cate) == true) {
                return "redirect:/restaurantManager/categoriesFood";
            }
        }
        return "newCategory";
    }
    
    @GetMapping("/restaurantManager/categoriesFood/newCategoriesFood/{categoryfoodId}")
    public String update(Model model, @PathVariable(value = "categoryfoodId") int categoryfoodId) {
        model.addAttribute("cate", this.categoriesFoodSer.getCategoryById(categoryfoodId));
        return "newCategory";
    }
    
}
