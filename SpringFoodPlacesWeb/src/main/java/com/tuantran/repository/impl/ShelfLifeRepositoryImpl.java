/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.repository.impl;

import com.tuantran.pojo.CategoriesFood;
import com.tuantran.pojo.ShelfLife;
import com.tuantran.repository.ShelfLifeRepository;
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
 * @author HP
 */
@Repository
@Transactional
public class ShelfLifeRepositoryImpl implements ShelfLifeRepository {

    @Autowired
    private ShelfLifeRepository shelfLifeRepo;
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> getShelfLife() {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("From ShelfLife");
        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateShelfLife(ShelfLife shelfLife) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (shelfLife.getShelflifeId() == null) {
                session.save(shelfLife);
            } else {
                session.update(shelfLife);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public ShelfLife getShelfLifeById(int id) {
        Session session =  this.factory.getObject().getCurrentSession();
        return session.get(ShelfLife.class, id);
    }

    @Override
    public boolean delShelf(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        ShelfLife shelfLife = this.getShelfLifeById(id);
        try{
            session.delete(shelfLife);
            return true;
        }catch(HibernateException ex){
            ex.printStackTrace();
            return false;
        }
    }

}
