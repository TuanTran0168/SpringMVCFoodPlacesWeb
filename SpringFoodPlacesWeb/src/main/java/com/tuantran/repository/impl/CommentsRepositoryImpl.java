/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.repository.impl;

import com.tuantran.pojo.Comments;
import com.tuantran.repository.CommentsRepository;
import java.util.List;
import javax.persistence.NoResultException;
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
public class CommentsRepositoryImpl implements CommentsRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Comments> getComments(int foodId) {
        try {
            Session s = this.factory.getObject().getCurrentSession();
            Query q = s.createQuery("FROM Comments WHERE foodId.foodId=:foodId");
            q.setParameter("foodId", foodId);

            return q.getResultList();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Comments addComment(Comments comment) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            session.save(comment);
            return comment;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
