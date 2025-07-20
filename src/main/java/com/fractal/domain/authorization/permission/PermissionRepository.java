package com.fractal.domain.authorization.permission;

import com.fractal.domain.authorization.role.menu.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface PermissionRepository extends JpaRepository<Permission, Long> {

    List<Permission> findAllByRoleId(Long roleId);

    List<Permission> findAllByMenuActionMenuId(Long menuId);

    List<Permission> findAllByRoleIdAndMenuActionMenuId(Long roleId, Long menuId);
}
