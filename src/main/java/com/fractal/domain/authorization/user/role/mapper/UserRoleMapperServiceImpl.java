package com.fractal.domain.authorization.user.role.mapper;

import com.fractal.domain.authorization.role.RoleService;
import com.fractal.domain.authorization.role.menu.RoleMenu;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuRequest;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuResponse;
import com.fractal.domain.authorization.user.role.UserRole;
import com.fractal.domain.authorization.user.role.dto.UserRoleRequest;
import com.fractal.domain.authorization.user.role.dto.UserRoleResponse;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.navigation.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserRoleMapperServiceImpl implements UserRoleMapperService {

    private final RoleService roleService;
    @Override
    public UserRoleResponse toDTO(UserRole userRole) {
        return new UserRoleResponse(
                userRole.getId(),
                userRole.getRole().getName(),
                userRole.getStatus().getName(),
                userRole.getCreatedDate(),
                userRole.getUpdatedDate()
        );
    }

    @Override
    public UserRole toEntity(UserRoleRequest dto) {
        return mapToEntity(new UserRole(),dto);
    }

    @Override
    public UserRole toEntity(UserRole userRole, UserRoleRequest dto) {
        return mapToEntity(userRole,dto);
    }



    private UserRole mapToEntity(UserRole userRole, UserRoleRequest dto) {
        userRole.setRole(roleService.getById(dto.roleId()));
        return userRole;
    }
}
