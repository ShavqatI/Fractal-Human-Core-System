package com.fractal.domain.authorization.user;

import com.fractal.domain.authorization.user.role.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user", schema = "authorization_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password")
    private String password;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    @Column(name = "created_date", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    //@CreatedDate
    protected LocalDateTime createdDate;

    @Column(name = "updated_date", insertable = false)
    @LastModifiedDate
    protected LocalDateTime updatedDate;

    @Column(name = "created_user_id", updatable = false)
    //@CreatedBy
    protected Long createdUser;


    @Column(name = "updated_user_id", updatable = true)
    //@LastModifiedBy
    protected Long updatedUser;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UserRole> userRoles = new ArrayList<>();

    @Transactional
    public void addRole(UserRole userRole) {
        if (userRoles == null) userRoles = new ArrayList<>();
        userRole.setUser(this);
        userRoles.add(userRole);

    }

    @Transactional
    public void removeRole(UserRole userRole) {
        userRoles.remove(userRole);
    }

}
