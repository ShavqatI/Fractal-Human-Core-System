package com.fractal.domain.authorization.role.menu.mapper;

import com.fractal.domain.authorization.role.menu.RoleMenu;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuRequest;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuResponse;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.navigation.menu.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class RoleMenuMapperServiceImpl implements RoleMenuMapperService {

    private final MenuService menuService;
    private final StatusService statusService;

    @Override
    public RoleMenuResponse toDTO(RoleMenu roleMenu) {
        return new RoleMenuResponse(
                roleMenu.getId(),
                menuService.toDTO(roleMenu.getMenu()),
                statusService.toDTO(roleMenu.getStatus()),
                roleMenu.getCreatedDate(),
                roleMenu.getUpdatedDate()
        );
    }

    @Override
    public RoleMenu toEntity(RoleMenuRequest dto) {
        return mapToEntity(new RoleMenu(),dto);
    }

    @Override
    public RoleMenu toEntity(RoleMenu roleMenu, RoleMenuRequest dto) {
        return mapToEntity(roleMenu,dto);
    }

    private RoleMenu mapToEntity(RoleMenu roleMenu, RoleMenuRequest dto) {
        roleMenu.setMenu(menuService.getById(dto.menuId()));
        roleMenu.setStatus(statusService.getById(dto.statusId()));
        return roleMenu;
    }
}
