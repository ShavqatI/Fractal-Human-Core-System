package com.fractal.domain.authorization;

import com.fractal.domain.authorization.user.User;
import com.fractal.domain.authorization.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class AuthenticatedServiceImpl implements AuthenticatedService {

    private final UserService userService;

    @Override
    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                var userDetails = (UserDetails) principal;
                User user = userService.findByUsername(userDetails.getUsername());
                return user;
            } else {
                System.out.println(principal.getClass());
            }
        } else {
            System.out.println("Not auth");
        }
        return null;
    }
}
