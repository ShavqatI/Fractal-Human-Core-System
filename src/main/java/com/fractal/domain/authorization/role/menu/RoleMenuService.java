package com.fractal.domain.authorization.role.menu;

import com.fractal.domain.authorization.role.menu.dto.RoleMenuRequest;
import com.fractal.domain.authorization.role.menu.dto.RoleMenuResponse;

import java.util.List;

public interface RoleMenuService {
    RoleMenu create(Long roleId,RoleMenuRequest dto);
    RoleMenu getById(Long roleId,Long id);
    List<RoleMenu> getAllByRoleId(Long roleId);
    RoleMenu update(Long roleId,Long id, RoleMenuRequest dto);
    void delete(Long roleId,Long id);
    RoleMenuResponse toDTO(RoleMenu roleMenu);
    RoleMenu getByRoleIdAndMenuId(Long roleId,Long menuId);
    List<RoleMenu> getActiveMenus(Long id);

}
