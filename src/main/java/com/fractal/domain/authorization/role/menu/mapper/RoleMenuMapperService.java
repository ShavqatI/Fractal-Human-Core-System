package com.fractal.domain.authorization.role.menu.mapper;

import com.fractal.domain.authorization.role.menu.RoleMenu;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuRequest;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuResponse;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.authorization.user.dto.UserRequest;
import com.fractal.domain.authorization.user.dto.UserResponse;

public interface RoleMenuMapperService {
    RoleMenuResponse toDTO(RoleMenu roleMenu);
    RoleMenu toEntity(RoleMenuRequest dto);
    RoleMenu toEntity(RoleMenu roleMenu, RoleMenuRequest dto);
}


