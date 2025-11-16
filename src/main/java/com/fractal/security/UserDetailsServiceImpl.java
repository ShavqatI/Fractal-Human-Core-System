package com.fractal.security;

import com.fractal.domain.authorization.user.UserService;
import com.fractal.domain.authorization.user.role.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;
    private final UserRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsImpl userDetails = new UserDetailsImpl(userService.findByUsername(username), roleService);
        return userDetails;
    }
}
