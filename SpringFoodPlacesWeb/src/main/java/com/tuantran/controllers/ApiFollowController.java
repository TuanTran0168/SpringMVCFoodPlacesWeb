/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.pojo.Follow;
import com.tuantran.service.FollowService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api")
public class ApiFollowController {

    @Autowired
    private FollowService followService;

    @PostMapping(path = "/follow/",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<String> follow(@RequestParam Map<String, String> params) {
        String message = "";
        int check = this.followService.addFollow(params);
        if (check == 1) {
            return new ResponseEntity<>("Theo dõi thành công!", HttpStatus.CREATED);
        } else if (check == 2) {
            message = "Đã hủy theo dõi!";
            return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
        } else {
            message = "Có lỗi xảy ra!";
        }

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/check-follow/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Follow> checkFollow(@RequestParam Map<String, String> params) {
        System.out.println("user: " + params.get("userId") + "  " + params.get("restaurantId"));
        int userId = Integer.parseInt(params.get("userId"));
        int restaurantId = Integer.parseInt(params.get("restaurantId"));
        Follow follow = this.followService.getFollowByUserIdAndRestaurantId(userId, restaurantId);
        if (follow != null) {
            return new ResponseEntity<>(follow, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(follow, HttpStatus.BAD_REQUEST);

    }
    
    @PostMapping(path = "/check-follow-new/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Follow> checkFollow_new(@RequestParam Map<String, String> params) {
        Follow follow = this.followService.checkFollow(params);
        if (follow != null) {
            return new ResponseEntity<>(follow, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(follow, HttpStatus.BAD_REQUEST);

    }
}
