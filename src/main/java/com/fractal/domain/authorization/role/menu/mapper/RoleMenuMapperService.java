package com.fractal.domain.authorization.role.menu.mapper;

import com.fractal.domain.authorization.role.menu.RoleMenu;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuRequest;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuResponse;

public interface RoleMenuMapperService {
    RoleMenuResponse toDTO(RoleMenu roleMenu);

    RoleMenu toEntity(RoleMenuRequest dto);

    RoleMenu toEntity(RoleMenu roleMenu, RoleMenuRequest dto);
}


