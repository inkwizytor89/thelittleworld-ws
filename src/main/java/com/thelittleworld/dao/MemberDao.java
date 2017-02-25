package com.thelittleworld.dao;


import com.thelittleworld.entity.Member;

import java.util.List;

public interface MemberDao {

    List<Member> findMembersforTeam(Integer teamId);
}
