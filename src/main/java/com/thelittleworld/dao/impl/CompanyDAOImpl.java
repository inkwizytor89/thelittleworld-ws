package com.thelittleworld.dao.impl;

import com.thelittleworld.dao.CompanyDAO;
import com.thelittleworld.entity.Company;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class CompanyDAOImpl implements CompanyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Company getCompany(Integer companyId) {
        return sessionFactory.getCurrentSession().get(Company.class, companyId);
    }

    @Override
    public Company findMembersforCompany(Integer companyId) {

        List<Company> teams = new ArrayList<Company>();

        teams = sessionFactory.getCurrentSession()
                .createQuery("from CompanyOld where id=?")
                .setParameter(0, companyId)
                .list();

        if (teams.size() > 0) {
            return teams.get(0);
        } else {
            return null;
        }
    }
}
