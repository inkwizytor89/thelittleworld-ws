package com.thelittleworld.dao.impl;

import com.thelittleworld.dao.UserDAO;
import com.thelittleworld.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.CallableStatement;
import java.sql.Types;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

//    @PersistenceContext
//    private EntityManager entityManager;

    public User getUser(Integer userId) {
    return sessionFactory.getCurrentSession().get(User.class, userId);
    }

    @SuppressWarnings("unchecked")
    public User findByUserName(String login) {

//        return entityManager.createQuery("from User where login=?", User.class)
//                .setParameter(0, login)
//                .getSingleResult();

        return (User) sessionFactory.getCurrentSession().createQuery("from User where login=?")
                .setParameter(0, login)
        .setMaxResults(1)
        .list()
        .get(0);

//                return query.getSingleResult();

    }

    @SuppressWarnings("unchecked")
    public User login(String login, String password) {

        Integer userId = sessionFactory.getCurrentSession()
                .doReturningWork(connection -> {
                    try (CallableStatement function = connection.prepareCall(
                            "{ ? = call login(?, ?) }" )) {
                        function.registerOutParameter(1, Types.INTEGER);
                        function.setString(2, login);
                        function.setString(3, password);
                        function.execute();
                        return function.getInt(1);
                    }
                } );

        return getUser(userId);
    }

}
