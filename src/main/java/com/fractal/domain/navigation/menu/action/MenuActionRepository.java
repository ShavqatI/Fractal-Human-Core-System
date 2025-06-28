package com.fractal.domain.navigation.menu.action;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface MenuActionRepository extends JpaRepository<MenuAction,Long> {
    Optional<MenuAction> findByMenuIdAndId(String menuId,Long id);
    List<MenuAction> findAllByMenuId(String menuId);
}
