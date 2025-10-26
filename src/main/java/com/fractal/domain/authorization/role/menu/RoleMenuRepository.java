package com.fractal.domain.authorization.role.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface RoleMenuRepository extends JpaRepository<RoleMenu, Long> {

    List<RoleMenu> findAllByRoleId(Long roleId);

    List<RoleMenu> findAllByRoleIdAndMenuId(Long roleId, Long menuId);
}
