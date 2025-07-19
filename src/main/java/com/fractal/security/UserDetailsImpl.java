package com.fractal.security;

import com.fractal.domain.authorization.user.User;
import com.fractal.domain.authorization.user.role.UserRoleService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
    private User user;
    private UserRoleService roleService;
    public UserDetailsImpl(User user, UserRoleService roleService) {
        this.user = user;
        this.roleService = roleService;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        roleService.getAllByUserId(user.getId()).stream().map(userRole -> roleService.toDTO(userRole))
        .filter(userRole -> userRole.status().equals("ACTIVE"))
         .forEach(userRole -> authorities.add(new SimpleGrantedAuthority("ROLE_" + userRole.role())));
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
}
