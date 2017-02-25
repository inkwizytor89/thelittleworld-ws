package com.thelittleworld.dao;

import com.thelittleworld.entity.Team;

public interface TeamDAO {
    Team findMembersforTeam(Integer teamId);
}
