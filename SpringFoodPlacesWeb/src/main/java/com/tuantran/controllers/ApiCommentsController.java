/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.pojo.Comments;
import com.tuantran.pojo.Users;
import com.tuantran.service.CommentsService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 */

@RestController
@RequestMapping("/api")
public class ApiCommentsController {
    
    @Autowired
    private CommentsService commentsService;
    
    @GetMapping(path = "/foodItems/{foodId}/comments/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<List<Comments>> listComments(@PathVariable(value = "foodId") int foodId) {
        return new ResponseEntity<>(this.commentsService.getComments(foodId), HttpStatus.OK);
    }
    
    @PostMapping(path = "/add-comment/",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Comments> addComment(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
        Comments comment = this.commentsService.addComment(params, avatar);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
    
}
