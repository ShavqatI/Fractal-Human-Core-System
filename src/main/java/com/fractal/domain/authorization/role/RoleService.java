package com.fractal.domain.authorization.role;

import com.fractal.domain.authorization.role.dto.RoleRequest;
import com.fractal.domain.authorization.role.dto.RoleResponse;

import java.util.List;

public interface RoleService {
    Role create(RoleRequest dto);
    Role getById(Long id);
    List<Role> getAll();
    Role update(Long id, RoleRequest dto);
    void delete(Long id);
    Role save(Role role);
    RoleResponse toDTO(Role role);

}
