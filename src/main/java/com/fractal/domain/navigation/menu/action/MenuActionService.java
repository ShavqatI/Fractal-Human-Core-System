package com.fractal.domain.navigation.menu.action;

import com.fractal.domain.navigation.menu.action.dto.MenuActionRequest;
import com.fractal.domain.navigation.menu.action.dto.MenuActionResponse;

import java.util.List;

public interface MenuActionService {
    MenuAction create(Long menuId,MenuActionRequest dto);
    List<MenuAction> getAllByMenuId(Long menuId);
    MenuAction getById(Long menuId,Long id);
    MenuAction getById(Long id);
    MenuAction update(Long menuId,Long id, MenuActionRequest dto);
    void delete(Long menuId, Long id);
    MenuActionResponse toDTO(MenuAction menuAction);
}
