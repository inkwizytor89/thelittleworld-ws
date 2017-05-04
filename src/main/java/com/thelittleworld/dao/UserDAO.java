package com.thelittleworld.dao;

import com.thelittleworld.entity.User;

public interface UserDAO {

    User getUser(Integer userId);

    User findByUserName(String name);

    User login(String login, String password);
}