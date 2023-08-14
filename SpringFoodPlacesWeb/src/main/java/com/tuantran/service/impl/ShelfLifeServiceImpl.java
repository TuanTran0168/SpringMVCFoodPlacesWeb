/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.service.impl;

import com.tuantran.pojo.ShelfLife;
import com.tuantran.repository.ShelfLifeRepository;
import com.tuantran.service.ShelfLifeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class ShelfLifeServiceImpl implements ShelfLifeService{
    
    @Autowired
    private ShelfLifeRepository ShelfLifeRepo;
    
    @Override
    public List<Object[]> getShelfLife() {
        return this.ShelfLifeRepo.getShelfLife();
    }

    @Override
    public boolean addOrUpdateShelfLife(ShelfLife shelfLife) {
        return this.ShelfLifeRepo.addOrUpdateShelfLife(shelfLife);
    }

    @Override
    public ShelfLife getShelfLifeById(int id) {
        return this.ShelfLifeRepo.getShelfLifeById(id);
    }

    @Override
    public boolean delShelf(int id) {
        return this.ShelfLifeRepo.delShelf(id);
    }

}
