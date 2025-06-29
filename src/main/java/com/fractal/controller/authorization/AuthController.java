package com.fractal.controller.authorization;

import com.fractal.controller.authorization.dto.AuthRequest;
import com.fractal.controller.authorization.dto.AuthResponse;
import com.fractal.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;



    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password()));
        String token = jwtUtil.generateToken(authRequest.username());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
