package com.thelittleworld.dao.impl;

import com.thelittleworld.dao.ItemDAO;
import com.thelittleworld.entity.Item;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ItemDAOImpl implements ItemDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Item> getAllItems() {
        List<Item> items = sessionFactory.getCurrentSession()
                .createQuery("from Item")
                .list();
        return items;
    }
}
