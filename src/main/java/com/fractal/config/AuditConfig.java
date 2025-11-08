package com.fractal.config;

import com.fractal.domain.authorization.user.User;
import com.fractal.domain.authorization.user.UserService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;


@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditConfig {
    @Bean
    public AuditorAware<User> auditorAware(UserService userService, EntityManager entityManager) {
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated()) {
                Object principal = authentication.getPrincipal();
                if (principal instanceof UserDetails) {
                    var userDetails = (UserDetails) principal;
                    User user = userService.findByUsername(userDetails.getUsername());
                    //return Optional.of(entityManager.getReference(User.class, user.getId()));
                    return Optional.of(entityManager.contains(user) ? user : entityManager.merge(user));
                }
            }
            return Optional.empty();
        };
    }
}

