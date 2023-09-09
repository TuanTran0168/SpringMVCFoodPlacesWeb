/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tuantran.pojo.Comments;
import com.tuantran.pojo.Fooditems;
import com.tuantran.pojo.ReceiptDetail;
import com.tuantran.pojo.Receipts;
import com.tuantran.pojo.Users;
import com.tuantran.repository.CommentsRepository;
import com.tuantran.repository.FoodItemsRepository;
import com.tuantran.repository.ReceiptDetailRepository;
import com.tuantran.repository.ReceiptRepository;
import com.tuantran.repository.RestaurantsRepository;
import com.tuantran.repository.UsersRepository;
import com.tuantran.service.CommentsService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 */
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepo;

    @Autowired
    private FoodItemsRepository foodItemsRepo;

    @Autowired
    private RestaurantsRepository restaurantsRepo;

    @Autowired
    private UsersRepository usersRepo;

    @Autowired
    private ReceiptDetailRepository receiptDetailRepo;

    @Autowired
    private ReceiptRepository receiptRepo;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Comments> getComments(int foodId, Map<String, String> params) {
        return this.commentsRepo.getComments(foodId, params);
    }

    @Override
    public Comments addComment(Map<String, String> params, MultipartFile avatar) {

        Comments comment = new Comments();
        comment.setCreatedDate(new Date());

        comment.setComment(params.get("comment"));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = this.usersRepo.getUserByUsername_new(authentication.getName());
        comment.setUserId(user);

        comment.setRestaurantId(this.restaurantsRepo.getRestaurantById(Integer.parseInt(params.get("restaurantId"))));
        comment.setFoodId(this.foodItemsRepo.getFoodItemById(Integer.parseInt(params.get("foodId"))));

        if (!avatar.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(avatar.getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                comment.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return this.commentsRepo.addComment(comment);
    }

//    @Override
//    public Comments addComment(Map<String, String> params, MultipartFile avatar) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Users user = this.usersRepo.getUserByUsername_new(authentication.getName());
//        String foodId = params.get("foodId");
//        Comments comment = new Comments();
//        if (foodId != null && !foodId.isEmpty()) {
//            Fooditems foodComment = this.foodItemsRepo.getFoodItemById(Integer.parseInt(foodId));
//
//            List<ReceiptDetail> receiptDetail_list = this.receiptDetailRepo.getReceiptDetailsByFoodId(foodComment.getFoodId());
//            List<Receipts> receipt_list = new ArrayList<>();
//            for (ReceiptDetail rd : receiptDetail_list) {
//                if (rd.getReceiptId().getUserId().equals(user.getUserId())) {
//                    comment.setCreatedDate(new Date());
//
//                    comment.setComment(params.get("comment"));
//                    comment.setUserId(user);
//
//                    comment.setRestaurantId(this.restaurantsRepo.getRestaurantById(Integer.parseInt(params.get("restaurantId"))));
//                    comment.setFoodId(this.foodItemsRepo.getFoodItemById(Integer.parseInt(params.get("foodId"))));
//
//                    if (!avatar.isEmpty()) {
//                        try {
//                            Map res = this.cloudinary.uploader().upload(avatar.getBytes(),
//                                    ObjectUtils.asMap("resource_type", "auto"));
//                            comment.setAvatar(res.get("secure_url").toString());
//                        } catch (IOException ex) {
//                            Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                }
//            }
//        }
//
//        return this.commentsRepo.addComment(comment);
//    }
    @Override
    public int countComments(int foodId) {
        return this.commentsRepo.countComments(foodId);
    }

    @Override
    public int checkComment(int foodId, Map<String, String> params) {
        String userIdStr = params.get("userId");
        if (userIdStr != null & !userIdStr.isEmpty()) {
            int userId = Integer.parseInt(userIdStr);
            return this.commentsRepo.checkComment(foodId, userId);
        }
        return 0;
    }

}
