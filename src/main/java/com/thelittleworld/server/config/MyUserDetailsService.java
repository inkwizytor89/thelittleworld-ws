package com.thelittleworld.server.config;

import com.thelittleworld.dao.UserDAO;
import com.thelittleworld.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {

        com.thelittleworld.entity.User user = userDAO.findByUserName(username);
        List<GrantedAuthority> authorities =
                buildUserAuthority(user.userRoles);

        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Collection<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for(UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.role));
        }
        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

    private User buildUserForAuthentication(com.thelittleworld.entity.User user,
                                            List<GrantedAuthority> authorities) {
        return new User(user.login, "papuga",
                true, true, true, true, authorities);
    }

}
