package com.fractal.controller.authorization.role;


import com.fractal.domain.authorization.permission.PermissionService;
import com.fractal.domain.authorization.permission.dto.PermissionRequest;
import com.fractal.domain.authorization.permission.dto.PermissionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/authorization/permission")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;
    @PostMapping
    public ResponseEntity<PermissionResponse> create(@RequestBody @Valid PermissionRequest dto) {
        return new ResponseEntity<>(permissionService.toDTO(permissionService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<PermissionResponse>> getAll() {
        return ResponseEntity.ok(permissionService.getAll().stream().map(permissionService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PermissionResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(permissionService.toDTO(permissionService.getById(id)));
    }
    @GetMapping("/role/{roleId}")
    public ResponseEntity<List<PermissionResponse>> getAllByRoleId(@PathVariable Long roleId) {
        return ResponseEntity.ok(permissionService.getAllByRoleId(roleId).stream().map(permissionService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/menu/{menuId}")
    public ResponseEntity<List<PermissionResponse>> getAllByMenuId(@PathVariable Long menuId) {
        return ResponseEntity.ok(permissionService.getAllByMenuId(menuId).stream().map(permissionService::toDTO).collect(Collectors.toList()));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PermissionResponse> update(@PathVariable Long id, @RequestBody @Valid PermissionRequest dto) {
      return  ResponseEntity.ok(permissionService.toDTO(permissionService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        permissionService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
