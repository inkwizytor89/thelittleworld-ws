package com.thelittleworld.server.endpoint;

import com.thelittleworld.dao.CompanyDAO;
import com.thelittleworld.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TeamController {

    @Autowired
    private CompanyDAO companyDAO;

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public Company company(@RequestParam(value = "company_id", required = true) Integer teamId) {

        return companyDAO.findMembersforCompany(teamId);
    }

}
