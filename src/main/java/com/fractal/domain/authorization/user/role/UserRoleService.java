package com.fractal.domain.authorization.user.role;

import com.fractal.domain.authorization.user.role.dto.UserRoleRequest;
import com.fractal.domain.authorization.user.role.dto.UserRoleResponse;

import java.util.List;

public interface UserRoleService {
    UserRole create(Long userId, UserRoleRequest dto);

    UserRole getById(Long userId, Long id);

    List<UserRole> getAllByUserId(Long userId);

    UserRole update(Long userId, Long id, UserRoleRequest dto);

    void delete(Long userId, Long id);

    UserRoleResponse toDTO(UserRole userRole);

}
