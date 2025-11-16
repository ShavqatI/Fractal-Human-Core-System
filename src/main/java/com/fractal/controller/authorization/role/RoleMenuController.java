package com.fractal.controller.authorization.role;


import com.fractal.domain.authorization.role.menu.RoleMenuService;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuRequest;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/authorization/role/{roleId}/menu")
@RequiredArgsConstructor
public class RoleMenuController {

    private final RoleMenuService roleMenuService;

    @PostMapping()
    public ResponseEntity<RoleMenuResponse> create(@PathVariable Long roleId, @RequestBody @Valid RoleMenuRequest dto) {
        return new ResponseEntity<>(roleMenuService.toDTO(roleMenuService.create(roleId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoleMenuResponse>> getAll(@PathVariable Long roleId) {
        return ResponseEntity.ok(roleMenuService.getAllByRoleId(roleId).stream().map(roleMenuService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleMenuResponse> getById(@PathVariable Long roleId, @PathVariable Long id) {
        return ResponseEntity.ok(roleMenuService.toDTO(roleMenuService.getById(roleId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleMenuResponse> update(@PathVariable Long roleId, @PathVariable Long id, @RequestBody @Valid RoleMenuRequest dto) {
        return ResponseEntity.ok(roleMenuService.toDTO(roleMenuService.update(roleId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long roleId, @PathVariable Long id) {
        roleMenuService.delete(roleId, id);
        return ResponseEntity.noContent().build();
    }

}
