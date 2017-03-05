package com.thelittleworld.dao.impl;

import com.thelittleworld.dao.CompanionDAO;
import com.thelittleworld.entity.Companion;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class CompanionDAOImpl implements CompanionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Companion> findMembersforTeam(Integer teamId) {
        List<Companion> companions = sessionFactory.getCurrentSession()
                .createQuery("from Companion where team_id=?")
                .setParameter(0,teamId)
                .list();
        return companions;
    }
}
