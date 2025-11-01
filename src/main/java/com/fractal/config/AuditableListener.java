package com.fractal.config;

import com.fractal.domain.abstraction.Auditable;
import com.fractal.domain.authorization.user.User;
import jakarta.persistence.PrePersist;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Component;

@Component
public class AuditableListener {

    @PrePersist
    public void setCreatedUser(Auditable entity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof User user) {
                entity.setCreatedUser(user);
            }
        }
    }

}
