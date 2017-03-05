package com.thelittleworld.server.endpoint;

import com.thelittleworld.dao.MemberDAO;
import com.thelittleworld.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberDAO memberDAO;

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public List<Member> team(@RequestParam(value = "team_id", required = true) Integer teamId) {

        return memberDAO.findMembersforTeam(teamId);
    }
}
