package com.thelittleworld.dao.impl;

import com.thelittleworld.dao.UserDAO;
import com.thelittleworld.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.CallableStatement;
import java.sql.Types;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public User getUser(Integer userId) {
    return sessionFactory.getCurrentSession().get(User.class, userId);
    }

    @SuppressWarnings("unchecked")
    public Boolean login(String login, String password) {

        Boolean accept = sessionFactory.getCurrentSession()
                .doReturningWork(connection -> {
                    try (CallableStatement function = connection.prepareCall(
                            "{ ? = call check_password(?, ?) }" )) {
                        function.registerOutParameter(1, Types.BOOLEAN);
                        function.setString(2, login);
                        function.setString(3, password);
                        function.execute();
                        return function.getBoolean(1);
                    }
                } );

        return accept;
    }

}
