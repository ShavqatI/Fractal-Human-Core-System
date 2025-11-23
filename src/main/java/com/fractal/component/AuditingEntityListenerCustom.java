/*
package com.fractal.component;

import com.fractal.domain.abstraction.Auditable;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.authorization.user.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuditingEntityListenerCustom {


    private final UserService userService;
    private final EntityManager entityManager;

    public AuditingEntityListenerCustom(UserService userService, EntityManager entityManager) {
        this.userService = userService;
        this.entityManager = entityManager;
    }

    // Called before INSERT
    @PrePersist
    public void prePersist(Object entity) {
        if (entity instanceof Auditable auditable) {

            User currentUser = getCurrentUser();
            if (currentUser != null) {
                auditable.setCreatedUser(currentUser);
            }
        }
    }

    // Called before UPDATE
    @PreUpdate
    public void preUpdate(Object entity) {
        if (entity instanceof Auditable auditable) {

            User currentUser = getCurrentUser();
            if (currentUser != null) {
                auditable.setUpdatedUser(currentUser);
            }
        }
    }

    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }
        Object principal = auth.getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            var user = userService.findByUsername(userDetails.getUsername());

            return entityManager.contains(user) ? user : entityManager.merge(user);
        }
       return null;
    }
}
*/
