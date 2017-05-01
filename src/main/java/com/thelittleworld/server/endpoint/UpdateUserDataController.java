package com.thelittleworld.server.endpoint;

import com.thelittleworld.dao.UserDAO;
import com.thelittleworld.entity.Companion;
import com.thelittleworld.entity.Company;
import com.thelittleworld.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class UpdateUserDataController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/update_user_data", method = RequestMethod.GET)
    public UserDataTO updateUserData(@RequestParam(value = "user_id") Integer userId) {

        // TODO INK: Hibernate.initialize(subProcessModel.getElement());
        return new UserDataTO(userDAO.getUser(userId));
    }

    public class UserDataTO {

        public User user;

        public Company company;

        public Collection<Companion> companions;

        public UserDataTO(User user) {
            this.user = user;
            this.company = user.company;
            this.companions = user.company.companions;
        }
    }
}
