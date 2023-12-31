/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.controllers;

import com.tuantran.components.JwtService;
import com.tuantran.pojo.Users;
import com.tuantran.service.UsersService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/api")
public class ApiUsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login/")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody Users user) {
//        1 đúng tài khoản + đúng mật khẩu
//        2 đúng tài khoản + sai mật khẩu
//        3 sai tài khoản

        int check = this.usersService.authUser(user.getUsername(), user.getPassword());
        String message = "Có lỗi xảy ra!";

        if (check == 1) {
            String token = this.jwtService.generateTokenLogin(user.getUsername());
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else if (check == 2) {
            message = "Mật khẩu không chính xác!";
        } else if (check == 3) {
            message = "Tài khoản không chính xác!";
        } else {
            message = "Có lỗi xảy ra!";
        }

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

//    @PostMapping(path = "/register/",
//            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE})
//    @CrossOrigin
//    public ResponseEntity<Users> registerUser(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
//        Users user = this.usersService.addUser(params, avatar);
//        return new ResponseEntity<>(user, HttpStatus.CREATED);
//    }
    @PostMapping(path = "/register/",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<String> registerUser(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
        Users user = this.usersService.addUser(params, avatar);
        if (user != null) {
            return new ResponseEntity<>("Đăng ký thành công!", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("Tài khoản đã được đăng ký!", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/admin/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "userId") int id) {
        this.usersService.deleteUsers(id);
    }

    @GetMapping("/admin/users/")
    @CrossOrigin
    public ResponseEntity<List<Users>> list(Map<String, String> params) {
        return new ResponseEntity<>(this.usersService.getUsers(params), HttpStatus.OK);
    }

    @GetMapping("/admin/users/roleId/{roleId}")
    @CrossOrigin
    public ResponseEntity<List<Users>> list_1(@PathVariable(value = "roleId") int roleId, Map<String, String> params) {
        params.put("roleId", String.valueOf(roleId));
        return new ResponseEntity<>(this.usersService.getUsers(params), HttpStatus.OK);
    }

    @GetMapping("/server/admin/users/roleId/{roleId}")
    @CrossOrigin
    public ResponseEntity<List<Users>> usersByUserRole_List_no_token(@PathVariable(value = "roleId") int roleId, Map<String, String> params) {
        params.put("roleId", String.valueOf(roleId));
        return new ResponseEntity<>(this.usersService.getUsers(params), HttpStatus.OK);
    }

    @DeleteMapping("/server/admin/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete_no_token(@PathVariable(value = "userId") int id) {
        this.usersService.deleteUsers(id);
    }

    //lấy user hiện tại bên reactjs
    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Users> details(Principal user) {
        Users u = this.usersService.getUserByUsername_new(user.getName());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

//    @PostMapping(path = "/update-user/",
//            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE})
//    @CrossOrigin
//    public ResponseEntity<Users> update(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
//        Users user = this.usersService.updateUser(params, avatar);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
    @PostMapping(path = "/update-user/",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<String> update(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
        int check = this.usersService.updateUser(params, avatar);
        String message = "Có lỗi xảy ra!";
        if (check == 1) {
            message = "Cập nhật thành công!";
            return new ResponseEntity<>(message, HttpStatus.OK);
        }

        if (check == 2) {
            message = "Không tìm thấy tài khoản để cập nhật!";
        }

        if (check == 3) {
            message = "Số điện thoại đã được đăng ký!";
        }

        if (check == 4) {
            message = "Email đã được đăng ký!";
        }

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/change-password/",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<String> changePassword(@RequestParam Map<String, String> params) {
        int check = this.usersService.changePassword(params);
        String message = "Có lỗi xảy ra!";

        if (check == 1) {
            return new ResponseEntity<>("Đổi mật khẩu thành công!", HttpStatus.OK);
        } else if (check == 2) {
            message = "Không tìm thấy tài khoản để đổi mật khẩu!";
        } else if (check == 3) {
            message = "Mật khẩu cũ không chính xác!";
        } else {
            message = "Có lỗi xảy ra!";
        }

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

//    @PostMapping("/login-google/")
//    @CrossOrigin
//    public ResponseEntity<String> loginGoogle(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
//        Users userRegister = this.usersService.registerUserGoogle(params, avatar);
//        String message = "";
//        if (userRegister != null) {
//            message = "Đăng ký thành công!";
//            return new ResponseEntity<>(message, HttpStatus.OK);
//        }
//        else {
//            message = "Có lỗi xảy ra!";
//        }
//
//        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
//    }
    @PostMapping("/login-google/")
    @CrossOrigin
    public ResponseEntity<String> loginGoogle(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
        Users userRegister = this.usersService.registerUserGoogle(params, avatar);
        String message = "";
        if (userRegister != null) {
            // Đăng ký thành công!
            int check = this.usersService.authUserLoginGoogle(userRegister.getUsername(), userRegister.getPassword());
            if (check == 1) {
                String token = this.jwtService.generateTokenLogin(userRegister.getUsername());
                return new ResponseEntity<>(token, HttpStatus.OK);
            } else if (check == 2) {
                message = "Mật khẩu không chính xác!";
            } else if (check == 3) {
                message = "Tài khoản không chính xác!";
            } else {
                message = "Có lỗi xảy ra!";
            }
        } else {
            message = "Có lỗi xảy ra!";
        }

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
