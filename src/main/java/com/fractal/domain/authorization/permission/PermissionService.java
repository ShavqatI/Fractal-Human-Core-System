package com.fractal.domain.authorization.permission;

import com.fractal.domain.authorization.permission.dto.PermissionRequest;
import com.fractal.domain.authorization.permission.dto.PermissionResponse;
import com.fractal.domain.authorization.role.menu.RoleMenu;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuRequest;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuResponse;

import java.util.List;

public interface PermissionService {
    Permission create(PermissionRequest dto);
    Permission getById(Long id);
    List<Permission> getAll();
    List<Permission> getAllByRoleId(Long roleId);
    List<Permission> getAllByMenuId(Long menuId);
    List<Permission> getAllByRoleIdMenuId(Long roleId,Long menuId);
    Permission update(Long id, PermissionRequest dto);
    void delete(Long id);
    PermissionResponse toDTO(Permission permission);

}
