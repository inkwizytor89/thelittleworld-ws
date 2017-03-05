package com.thelittleworld.server.endpoint;

import com.thelittleworld.dao.UserDAO;
import com.thelittleworld.server.endpoint.request_body.LoginRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Boolean login(@RequestBody LoginRequestBody loginRequestBody) {

        Boolean isAccept = userDAO.login(loginRequestBody.getLogin(), loginRequestBody.getPassword());
        return isAccept;
    }
}
