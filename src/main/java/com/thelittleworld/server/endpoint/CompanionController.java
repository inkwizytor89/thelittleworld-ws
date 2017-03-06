package com.thelittleworld.server.endpoint;

import com.thelittleworld.dao.CompanionDAO;
import com.thelittleworld.entity.Companion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO unused
@RestController
public class CompanionController {

    @Autowired
    private CompanionDAO companionDAO;

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public List<Companion> team(@RequestParam(value = "team_id", required = true) Integer teamId) {

        return companionDAO.findMembersforTeam(teamId);
    }
}
