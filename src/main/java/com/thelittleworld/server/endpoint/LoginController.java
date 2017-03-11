package com.thelittleworld.server.endpoint;

import com.thelittleworld.dao.DBVersionDAO;
import com.thelittleworld.dao.UserDAO;
import com.thelittleworld.server.endpoint.request_body.LoginRequestBody;
import com.thelittleworld.server.endpoint.respons.VersionResponse;
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

    @Autowired
    private DBVersionDAO dbVersionDAO;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public VersionResponse login(@RequestBody LoginRequestBody loginRequestBody) {

        VersionResponse response = new VersionResponse();
        response.user = userDAO.login(loginRequestBody.getLogin(), loginRequestBody.getPassword());
        response.dbVersion = dbVersionDAO.getLastDBVersion();

        return response;
    }
}
