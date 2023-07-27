/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.repository.impl;

import com.tuantran.repository.RolesRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */

@Repository
public class RolesRepositoryImpl implements RolesRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Object[]> getRoles() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Roles");
        return q.getResultList();
    }
    
}
