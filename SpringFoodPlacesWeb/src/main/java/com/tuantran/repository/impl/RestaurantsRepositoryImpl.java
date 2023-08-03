/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.repository.impl;

import com.tuantran.pojo.Restaurants;
import com.tuantran.repository.RestaurantsRepository;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Repository
@Transactional
public class RestaurantsRepositoryImpl implements RestaurantsRepository{

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> getRestaurants() {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Restaurants");
        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateRestaurants(Restaurants restaurant) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (restaurant.getRestaurantId()== null) {
                session.save(restaurant);
            } else {
                session.update(restaurant);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Restaurants getRestaurantById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Restaurants.class, id);
    }
    
    
}
