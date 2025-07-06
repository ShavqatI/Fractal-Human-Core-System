package com.fractal.controller.authorization;

import com.fractal.controller.authorization.dto.AuthRequest;
import com.fractal.controller.authorization.dto.AuthResponse;
import com.fractal.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authorization/authentication/")
public class AuthenticationController {
    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password()));
        String token = jwtService.generateToken(authRequest.username());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
