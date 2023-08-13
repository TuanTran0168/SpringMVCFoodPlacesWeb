/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuantran.repository.impl;

import com.tuantran.pojo.Users;
import com.tuantran.repository.UsersRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrator
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class UsersRepositoryImpl implements UsersRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private Environment environment;

    @Override
    public List<Object[]> getUsers(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = criteriaBuilder.createQuery(Users.class);
        Root rootUsers = query.from(Users.class);

        query.select(rootUsers);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String keyword = params.get("keyword");
            if (keyword != null && !keyword.isEmpty()) {
                predicates.add(criteriaBuilder.or(
                        criteriaBuilder.like(rootUsers.get("firstname"), String.format("%%%s%%", keyword)),
                        criteriaBuilder.like(rootUsers.get("lastname"), String.format("%%%s%%", keyword)))
                );
            }

            String roleId = params.get("roleId");
            if (roleId != null && !roleId.isEmpty()) {
                // Chỗ này ảo ma :) không parse về Int là bugs ???
                // Mà á parse về Int thì IDE nó báo không cần thiết ???
                predicates.add(criteriaBuilder.equal(rootUsers.get("roleId"), Integer.parseInt(roleId)));
            }

            query.where(predicates.toArray(Predicate[]::new));

        }

        query.orderBy(criteriaBuilder.asc(rootUsers.get("userId")));
        Query final_query = session.createQuery(query);

        if (params != null) {
            String pageStr = params.get("page");
            if (pageStr != null && !pageStr.isEmpty()) {
                int pageInt = Integer.parseInt(pageStr);
                int pageSize = Integer.parseInt(this.environment.getProperty("PAGE_SIZE"));

                final_query.setMaxResults(pageSize);
                final_query.setFirstResult((pageInt - 1) * pageSize);
            }
        }

        return final_query.getResultList();
    }

    @Override
    public int countUsers() {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT Count(*) FROM Users");

        return Integer.parseInt(query.getSingleResult().toString());
    }

    @Override
    public boolean addOrUpdateUsers(Users user) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (user.getUserId() == null) {
                session.save(user);
            } else {
                session.update(user);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Users getUserById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Users.class, id);
    }

    @Override
    public Users getUserByUsername(String username) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Users WHERE username=:username");
        query.setParameter("username", username);
        return (Users) query.getSingleResult();
    }

    @Override
    public boolean registerUser(Users user) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            session.save(user);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
