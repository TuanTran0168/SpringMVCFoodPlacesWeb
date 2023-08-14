/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.repository;

import com.tuantran.pojo.ShelfLife;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ShelfLifeRepository {
    List<Object[]> getShelfLife();
    boolean addOrUpdateShelfLife(ShelfLife shelfLife);
    ShelfLife getShelfLifeById(int id);
    boolean delShelf(int id);
}
