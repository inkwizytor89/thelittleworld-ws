package com.thelittleworld.dao;

import com.thelittleworld.entity.Company;

public interface CompanyDAO {
    Company getCompany(Integer companyId);

    Company findMembersforCompany(Integer teamId);
}
