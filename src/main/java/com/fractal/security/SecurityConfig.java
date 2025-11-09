package com.fractal.security;

import com.fractal.domain.authorization.permission.Permission;
import com.fractal.domain.authorization.permission.PermissionService;
import com.fractal.domain.navigation.menu.Menu;
import com.fractal.domain.navigation.menu.action.MenuAction;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;
import java.util.Optional;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtRequestFilter jwtFilter;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final PermissionService permissionService;
    private final JwtLogoutHandler logoutHandler;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/authenticate", "/public/**","/api/**","/**").permitAll()
                        .anyRequest().access((authentication, request) -> authorizationDecision(authentication.get(),request))
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> logout
                        .logoutUrl("/api/v1/authorization/authentication/logout")
                        .addLogoutHandler(logoutHandler)
                        .logoutSuccessHandler((request, response, authentication) ->
                                response.setStatus(HttpServletResponse.SC_OK))
                )
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

   private AuthorizationDecision authorizationDecision(Authentication authentication, RequestAuthorizationContext request) {
        if (authentication.isAuthenticated()) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                return new AuthorizationDecision(false); // Deny access for anonymous users
            }

            List<Permission> permissions = permissionService.getActivePermissions(authentication);
            String requestUrl = request.getRequest().getRequestURI();
            for (var permission : permissions) {
                String role  = "ROLE_" + permission.getRole().getCode();
                String urlPattern = permission.getMenuAction().getAction().getUrl();
                if (requestUrl.matches(urlPattern.replace("**", ".*"))) {
                    boolean hasRole = authentication.getAuthorities().stream()
                            .anyMatch(authority -> authority.getAuthority().equals(role));
                    return new AuthorizationDecision(hasRole);
                }
                return new AuthorizationDecision(false);
            }
        }
        return new AuthorizationDecision(false);
    }





}
