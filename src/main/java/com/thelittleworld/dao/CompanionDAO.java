package com.thelittleworld.dao;


import com.thelittleworld.entity.Companion;

import java.util.List;

public interface CompanionDAO {

    List<Companion> findMembersforTeam(Integer teamId);
}
