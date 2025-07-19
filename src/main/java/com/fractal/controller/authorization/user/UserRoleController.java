package com.fractal.controller.authorization.user;


import com.fractal.domain.authorization.user.role.UserRoleService;
import com.fractal.domain.authorization.user.role.dto.UserRoleRequest;
import com.fractal.domain.authorization.user.role.dto.UserRoleResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/authorization/user/{userId}/role")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @PostMapping()
    public ResponseEntity<UserRoleResponse> create(@PathVariable Long userId, @RequestBody @Valid UserRoleRequest dto) {
        return new ResponseEntity<>(userRoleService.toDTO(userRoleService.create(userId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<UserRoleResponse>> getAll(@PathVariable Long userId) {
        return ResponseEntity.ok(userRoleService.getAllByUserId(userId).stream().map(userRoleService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserRoleResponse> getById(@PathVariable Long userId,@PathVariable Long id) {
        return ResponseEntity.ok(userRoleService.toDTO(userRoleService.getById(userId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserRoleResponse> update(@PathVariable Long userId, @PathVariable Long id, @RequestBody @Valid UserRoleRequest dto) {
        return ResponseEntity.ok(userRoleService.toDTO(userRoleService.update(userId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long userId, @PathVariable Long id) {
        userRoleService.delete(userId,id);
        return ResponseEntity.noContent().build();
    }

}