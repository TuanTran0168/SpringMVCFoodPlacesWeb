/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service.impl;

import com.tuantran.repository.RolesRepository;
import com.tuantran.service.RolesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesRepository rolesRepo;

    @Override
    public List<Object[]> getRoles() {
        return this.rolesRepo.getRoles();
    }

}
