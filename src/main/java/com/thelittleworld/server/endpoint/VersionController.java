package com.thelittleworld.server.endpoint;

import com.thelittleworld.dao.DBVersionDAO;
import com.thelittleworld.dao.UserDAO;
import com.thelittleworld.server.endpoint.respons.VersionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private DBVersionDAO dbVersionDAO;

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public VersionResponse getVersion(@RequestParam(value = "user_id") Integer userId) {

        VersionResponse response = new VersionResponse();
        response.user = userDAO.getUser(userId);
        response.dbVersion = dbVersionDAO.getLastDBVersion();

        return response;
    }
}
