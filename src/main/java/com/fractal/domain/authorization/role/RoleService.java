package com.fractal.domain.authorization.role;

import com.fractal.domain.authorization.role.dto.RoleCompactResponse;
import com.fractal.domain.authorization.role.dto.RoleRequest;
import com.fractal.domain.authorization.role.dto.RoleResponse;
import com.fractal.domain.authorization.role.menu.RoleMenu;

import java.util.List;

public interface RoleService {
    Role create(RoleRequest dto);

    Role getById(Long id);

    Role getByCode(String code);

    List<Role> getAll();

    Role update(Long id, RoleRequest dto);

    void delete(Long id);

    Role save(Role role);

    List<RoleMenu> getActiveMenus(Long id);

    RoleResponse toDTO(Role role);

    RoleCompactResponse toCompactDTO(Role role);

}
