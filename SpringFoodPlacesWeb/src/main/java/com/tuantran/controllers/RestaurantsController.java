/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.pojo.Restaurants;
import com.tuantran.pojo.Roles;
import com.tuantran.pojo.Users;
import com.tuantran.service.RestaurantStatusService;
import com.tuantran.service.RestaurantsService;
import com.tuantran.service.UsersService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
 * @author Administrator
 */
@Controller
public class RestaurantsController {

    @Autowired
    private RestaurantsService restaurantsService;

    @Autowired
    private UsersService userService;

    @Autowired
    private RestaurantStatusService restaurantStatusService;

    @Autowired
    private Environment environment;

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("restaurantStatus_list", this.restaurantStatusService.getRestaurantsStatus());
        model.addAttribute("user_list", this.userService.getUsers(null));
    }

    @GetMapping("/restaurantManager/restaurants")
    public String list(Model model, @RequestParam Map<String, String> params, Authentication authentication) {
        int pageSize = Integer.parseInt(this.environment.getProperty("PAGE_SIZE"));
        String confirm = params.get("confirm");
        params.put("confirm", confirm);
        int countRestaurant = this.restaurantsService.countRestaurants(params);
        model.addAttribute("counter", Math.ceil(countRestaurant * 1.0 / pageSize));
        
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            UserDetails user = (UserDetails) principal;
            String username = user.getUsername();
            params.put("username", username);
            
            Users user_auth = this.userService.getUserByUsername_new(username);
//            Users user_auth = new Users();
//            user_auth.setUserId(4);
//            Roles r = new Roles();
//            r.setRoleId(2);
//            user_auth.setRoleId(r);
            
            if (user_auth != null) {
                params.put("current_user_UserId", user_auth.getUserId().toString());
                int countRestaurant_UserId = this.restaurantsService.countRestaurants(params);
                model.addAttribute("counter", Math.ceil(countRestaurant_UserId * 1.0 / pageSize));
            }
            
            model.addAttribute("role", user_auth.getRoleId().getRoleId());
        }

        String pageStr = params.get("page");
        String pageAllStr = params.get("pageAll");

        if (pageStr == null) {
            if (pageAllStr == null) {
                params.put("page", "1");

                model.addAttribute("restaurant_list", this.restaurantsService.getRestaurants(params));
            } else {
                model.addAttribute("restaurant_list", this.restaurantsService.getRestaurants(params));
            }

        } else {
            model.addAttribute("restaurant_list", this.restaurantsService.getRestaurants(params));
        }

        return "restaurants";
    }

    @GetMapping("/restaurantManager/restaurants/newRestaurant")
    public String newRestaurant(Model model) {
        model.addAttribute("restaurant", new Restaurants());
        return "newRestaurant";
    }

//  Cái restaurantId trong cái GetMapping này là trùng với bên jsp nha :)
    @GetMapping("/restaurantManager/restaurants/{restaurantId}")
    public String update(Model model, @PathVariable(value = "restaurantId") int restaurantId) {
        model.addAttribute("restaurant", this.restaurantsService.getRestaurantById(restaurantId));
        return "newRestaurant";
    }

    @PostMapping("/restaurantManager/restaurants/newRestaurant")
    public String add(@ModelAttribute(value = "restaurant") @Valid Restaurants restaurant, BindingResult rs) {

        if (!rs.hasErrors()) {
            if (restaurantsService.addOrUpdateRestaurants(restaurant) == true) {
                return "redirect:/restaurantManager/restaurants";
            }
        }
        return "newRestaurant";
    }

    @GetMapping("/admin/restaurants")
    public String restaurant_admin(Model model, @RequestParam Map<String, String> params) {
        int pageSize = Integer.parseInt(this.environment.getProperty("PAGE_SIZE"));
        String confirm = params.get("confirm");
        params.put("confirm", confirm);
        int countRestaurant = this.restaurantsService.countRestaurants(params);
        model.addAttribute("counter", Math.ceil(countRestaurant * 1.0 / pageSize));

        String pageStr = params.get("page");
        String pageAllStr = params.get("pageAll");

        if (pageStr == null) {
            if (pageAllStr == null) {
                params.put("page", "1");

                model.addAttribute("restaurant_list", this.restaurantsService.getRestaurants(params));
            } else {
                model.addAttribute("restaurant_list", this.restaurantsService.getRestaurants(params));
            }

        } else {
            model.addAttribute("restaurant_list", this.restaurantsService.getRestaurants(params));
        }

        return "restaurants_admin";
    }

    @GetMapping("/admin/restaurants/newRestaurant")
    public String newRestaurant_admin(Model model) {
        model.addAttribute("restaurant", new Restaurants());
        return "newRestaurant_admin";
    }

//  Cái restaurantId trong cái GetMapping này là trùng với bên jsp nha :)
    @GetMapping("/admin/restaurants/{restaurantId}")
    public String update_admin(Model model, @PathVariable(value = "restaurantId") int restaurantId) {
        model.addAttribute("restaurant", this.restaurantsService.getRestaurantById(restaurantId));
        return "newRestaurant_admin";
    }

    @PostMapping("/admin/restaurants/newRestaurant")
    public String add_admin(@ModelAttribute(value = "restaurant") @Valid Restaurants restaurant, BindingResult rs) {

        if (!rs.hasErrors()) {
            if (restaurantsService.addOrUpdateRestaurants(restaurant) == true) {
                return "redirect:/admin/restaurants";
            }
        }
        return "newRestaurant_admin";
    }
}
