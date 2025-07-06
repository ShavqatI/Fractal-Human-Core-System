package com.fractal.domain.authorization.user;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.authorization.user.role.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user", schema = "authorization_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity {

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password")
    private String password;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRole> userRoles = new ArrayList<>();

    public void addRole(UserRole userRole) {
        if (userRoles == null) userRoles = new ArrayList<>();
        userRole.setUser(this);
        userRoles.add(userRole);
    }

    public void removeRole(UserRole userRole) {
        userRoles.remove(userRole);
    }

    }
