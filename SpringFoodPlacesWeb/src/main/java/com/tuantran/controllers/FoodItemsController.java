/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.pojo.Fooditems;
import com.tuantran.pojo.Restaurants;
import com.tuantran.pojo.Users;
import com.tuantran.service.CategoriesFoodService;
import com.tuantran.service.FoodItemsService;
import com.tuantran.service.RestaurantsService;
import com.tuantran.service.ShelfLifeService;
import com.tuantran.service.UsersService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
@ControllerAdvice
public class FoodItemsController {

    @Autowired
    private FoodItemsService foodItemSer;

    @Autowired
    private CategoriesFoodService categoryFoodSer;

    @Autowired
    private UsersService userService;

    @Autowired
    private RestaurantsService restaurantsService;

    @Autowired
    private ShelfLifeService shelfLifeSer;

    @ModelAttribute
    public void commonAttr(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("shelfLife_list", this.shelfLifeSer.getShelfLife());
        model.addAttribute("category_list", this.categoryFoodSer.getCategoriesFood(params));
    }

    @GetMapping("/restaurantManager/foodItems")
    public String indexFoodItems(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("foodItems", this.foodItemSer.getFoodItems(params));
        model.addAttribute("msg", "Chào");
        return "indexFoodItems";
    }

//    @RequestMapping("/restaurantManager/foodItems")
//    public String indexFoodItemsTest(Model model, @RequestParam Map<String, String> params){
//        model.addAttribute("foodItems", this.foodItemSer.getFoodItems(params));
//        model.addAttribute("msg", "Chào");
//        return "indexFoodItems";
//    }
    @GetMapping("/restaurantManager/foodItems/newFoodItems")
    public String newFoodItems(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("foodItem", new Fooditems());
        model.addAttribute("shelfLife_list", this.shelfLifeSer.getShelfLife());
        model.addAttribute("category_list", this.categoryFoodSer.getCategoriesFood(params));
        return "newFoodItems";
    }

    @PostMapping("/restaurantManager/foodItems/newFoodItems")
    public String addFood(Model model, @ModelAttribute(value = "foodItem") @Valid Fooditems food, BindingResult rs, Authentication authentication, @RequestParam Map<String, String> params) {
        String msg = "";
        if (!rs.hasErrors()) {
            if (this.foodItemSer.addOrUpdateFoodItem(food) == true) {
                if (food.getRestaurantId().getRestaurantId() != null) {
                    return "redirect:/restaurantManager/restaurants/" + food.getRestaurantId().getRestaurantId();
                } else {
                    msg = "Có lỗi xảy ra!";
                }

            }

        }

        model.addAttribute("msg", msg);
        return "newFoodItems";
    }

    @GetMapping("/restaurantManager/foodItems/{foodId}")
    public String update(Model model, @PathVariable(value = "foodId") int foodId, @RequestParam Map<String, String> params, Authentication authentication) {
        String msg = "";
        Fooditems food = this.foodItemSer.getFoodItemById(foodId);
        if (food != null) {
            Restaurants restaurant = this.restaurantsService.getRestaurantById(food.getRestaurantId().getRestaurantId());

            if (authentication != null && authentication.isAuthenticated()) {
                Object principal = authentication.getPrincipal();
                UserDetails user = (UserDetails) principal;
                String username = user.getUsername();
                params.put("username", username);

                Users user_auth = this.userService.getUserByUsername_new(username);

                if (user_auth != null) {
                    if (restaurant.getUserId().getUserId().equals(user_auth.getUserId())) {
                        model.addAttribute("foodItem", this.foodItemSer.getFoodItemById(foodId));

                    } else {
                        // HOW TO GỬI CÁI NÀY RA LẠI TRANG restaurants đây :) 
                        // NÓ CỘNG CHUỖI Ở TRÊN URL BÀ CON ƠI :)
                        ///restaurantManager/restaurants?msg=Kh%F4ng+t%3Fn+t%3Fi+m%F3n+n%E0y+trong+nh%E0+h%E0ng+c%3Fa+b%3Fn%21
                        msg = "Không tồn tại món này trong nhà hàng của bạn!";
                        model.addAttribute("msg", msg);
                        return "redirect:/restaurantManager/restaurants";
                    }
                }
            }
        } else {
            msg = "Không tồn tại món này trong nhà hàng của bạn!";
            model.addAttribute("msg", msg);
            return "redirect:/restaurantManager/restaurants";
        }
        model.addAttribute("msg", msg);
        return "newFoodItems";
    }
}
