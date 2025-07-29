package com.fractal.domain.navigation.menu.action.mapper;

import com.fractal.domain.authorization.role.menu.RoleMenu;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuRequest;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuResponse;
import com.fractal.domain.navigation.menu.action.MenuAction;
import com.fractal.domain.navigation.menu.action.dto.MenuActionRequest;
import com.fractal.domain.navigation.menu.action.dto.MenuActionResponse;

public interface MenuActionMapperService {
    MenuActionResponse toDTO(MenuAction menuAction);
    MenuAction toEntity(MenuActionRequest dto);
    MenuAction toEntity(MenuAction menuAction, MenuActionRequest dto);
}


