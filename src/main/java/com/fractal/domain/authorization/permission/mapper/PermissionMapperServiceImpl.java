package com.fractal.domain.authorization.permission.mapper;

import com.fractal.domain.authorization.permission.Permission;
import com.fractal.domain.authorization.permission.dto.PermissionRequest;
import com.fractal.domain.authorization.permission.dto.PermissionResponse;
import com.fractal.domain.authorization.role.RoleService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.navigation.menu.action.MenuActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class PermissionMapperServiceImpl implements PermissionMapperService {

    private final RoleService roleService;
    private final MenuActionService menuActionService;
    private final StatusService statusService;

    @Override
    public PermissionResponse toDTO(Permission permission) {
        return new PermissionResponse(
                permission.getId(),
                roleService.toDTO(permission.getRole()),
                menuActionService.toDTO(permission.getMenuAction()),
                statusService.toDTO(permission.getStatus()),
                permission.getCreatedDate(),
                permission.getUpdatedDate()
        );
    }

    @Override
    public Permission toEntity(PermissionRequest dto) {
        return mapToEntity(new Permission(),dto);
    }

    @Override
    public Permission toEntity(Permission permission, PermissionRequest dto) {
        return mapToEntity(permission,dto);
    }

    private Permission mapToEntity(Permission permission,PermissionRequest dto) {
        permission.setRole(roleService.getById(dto.roleId()));
        permission.setMenuAction(menuActionService.getById(dto.menuActionId()));
        permission.setStatus(statusService.getById(dto.statusId()));
        return permission;
    }
}
