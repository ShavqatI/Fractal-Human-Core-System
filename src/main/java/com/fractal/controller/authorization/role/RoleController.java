package com.fractal.controller.authorization.role;


import com.fractal.domain.authorization.role.RoleService;
import com.fractal.domain.authorization.role.dto.RoleRequest;
import com.fractal.domain.authorization.role.dto.RoleResponse;
import com.fractal.domain.authorization.user.UserService;
import com.fractal.security.UserDetailsImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/authorization/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    private final UserService userService;
    @PostMapping
    public ResponseEntity<RoleResponse> create(@RequestBody @Valid RoleRequest dto) {
        return new ResponseEntity<>(roleService.toDTO(roleService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<RoleResponse>> getAll() {
        return ResponseEntity.ok(roleService.getAll().stream().map(roleService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(roleService.toDTO(roleService.getById(id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<RoleResponse> update(@PathVariable Long id, @RequestBody @Valid RoleRequest dto) {
      return  ResponseEntity.ok(roleService.toDTO(roleService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
