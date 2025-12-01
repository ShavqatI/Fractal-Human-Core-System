package com.fractal.controller.authorization.user;


import com.fractal.domain.authorization.user.UserService;
import com.fractal.domain.authorization.user.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/authorization/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest dto) {
        return new ResponseEntity<>(userService.toDTO(userService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.ok(userService.getAll().stream().map(userService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/compact")
    public ResponseEntity<List<UserCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(userService.getAll().stream().map(userService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.toDTO(userService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @RequestBody @Valid UserRequest dto) {
        return ResponseEntity.ok(userService.toDTO(userService.update(id, dto)));
    }

    @PutMapping("reset-password/{id}")
    public ResponseEntity<Void> resetPassword(@PathVariable Long id, @RequestBody @Valid ResetPasswordRequest dto) {
        userService.resetPassword(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("change-password/{id}")
    public ResponseEntity<Void> changePassword(@PathVariable Long id, @RequestBody @Valid ChangePasswordRequest dto) {
        userService.changePassword(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
