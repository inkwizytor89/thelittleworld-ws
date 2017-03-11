package com.thelittleworld.dao.impl;

import com.thelittleworld.dao.DBVersionDAO;
import com.thelittleworld.entity.DBVersion;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class DBVersionDAOImpl implements DBVersionDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public DBVersion getLastDBVersion() {
            return (DBVersion) sessionFactory.getCurrentSession()
                    .createQuery("from DBVersion order by id desc")
                    .setMaxResults(1)
                    .list().get(0);
    }
}
