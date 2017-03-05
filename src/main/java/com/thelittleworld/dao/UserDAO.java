package com.thelittleworld.dao;

import com.thelittleworld.entity.User;

public interface UserDAO {

    User getUser(Integer userId);

    Boolean login(String login, String password);
}