package com.fractal.controller.authorization;

import com.fractal.controller.authorization.dto.AuthRequest;
import com.fractal.controller.authorization.dto.AuthResponse;
import com.fractal.domain.authorization.role.RoleService;
import com.fractal.domain.authorization.role.dto.RoleResponse;
import com.fractal.domain.authorization.role.menu.RoleMenu;
import com.fractal.domain.authorization.user.UserService;
import com.fractal.domain.navigation.menu.MenuService;
import com.fractal.domain.navigation.menu.dto.MenuResponse;
import com.fractal.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authorization/authentication/")
public class AuthenticationController {
    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final UserService userService;
    private final RoleService roleService;
    private final MenuService menuService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password()));
        String token = jwtService.generateToken(authRequest.username());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @GetMapping("/navigation")
    public ResponseEntity<List<MenuResponse>> getNavigation() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.getPrincipal() instanceof UserDetails) {
            var userDetails = (UserDetails) auth.getPrincipal();
            var user = userService.findByUsername(userDetails.getUsername());
            var roles = userService.getActiveRoles(user.getId());
            List<List<RoleMenu>> roleMenus = new ArrayList<>();
            roles.forEach(userRole -> roleMenus.add(roleService.getActiveMenus(userRole.getRole().getId())));
            return ResponseEntity.ok(roleMenus.stream()
                    .flatMap(List::stream).map(roleMenu -> menuService.toDTO(roleMenu.getMenu()))
                    .collect(Collectors.toList()));

        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
