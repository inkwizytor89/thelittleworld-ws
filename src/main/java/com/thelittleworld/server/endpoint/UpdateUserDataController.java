package com.thelittleworld.server.endpoint;

import com.thelittleworld.dao.UserDAO;
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

    @RequestMapping(value = "/update_user_data", method = RequestMethod.GET)
    public User updateUserData(@RequestParam(value = "user_id", required = true) Integer userId) {

        // TODO INK: Hibernate.initialize(subProcessModel.getElement());
        return userDAO.getUser(userId);
    }

}
