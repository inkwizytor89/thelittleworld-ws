package com.thelittleworld.server.endpoint;

import com.thelittleworld.dao.TeamDAO;
import com.thelittleworld.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TeamController {

    @Autowired
    private TeamDAO teamDAO;

    @RequestMapping(value = "/team", method = RequestMethod.GET)
    public Team team(@RequestParam(value = "team_id", required = true) Integer teamId) {

        return teamDAO.findMembersforTeam(teamId);
    }

}
