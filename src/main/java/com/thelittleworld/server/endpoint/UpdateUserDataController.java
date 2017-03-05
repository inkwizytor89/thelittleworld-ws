package com.thelittleworld.server.endpoint;

import com.thelittleworld.dao.CompanyDAO;
import com.thelittleworld.dao.UserDAO;
import com.thelittleworld.entity.Company;
import com.thelittleworld.entity.Member;
import com.thelittleworld.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateUserDataController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CompanyDAO companyDAO;

    @RequestMapping(value = "/update_user_data", method = RequestMethod.GET)
    public UserData updateUserData(@RequestParam(value = "user_id", required = true) Integer userId) {

        // TODO INK: wszsytko powinno się w sumie do ussera zaczytać Hibernate.initialize(subProcessModel.getElement());
        UserData userData = new UserData();
        userData.user = userDAO.getUser(userId);
        userData.company = companyDAO.getCompany(userData.user.companyId);

        return userData;
    }

    private class UserData {
        public User user;
        public Company company;
        public Member member;
    }
}
