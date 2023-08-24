/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.formatters;

import com.tuantran.pojo.Users;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Administrator
 */
public class UsersFormatter implements Formatter<Users>{
    @Override
    public String print(Users role, Locale locale) {
        return String.valueOf(role.getRoleId());
    }

    @Override
    public Users parse(String userId, Locale locale) throws ParseException {
        return new Users(Integer.parseInt(userId));
    }
}
