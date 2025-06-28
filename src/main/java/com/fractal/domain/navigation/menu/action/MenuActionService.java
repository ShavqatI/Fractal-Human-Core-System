package com.fractal.domain.navigation.menu.action;

import com.fractal.domain.navigation.action.Action;
import com.fractal.domain.navigation.action.dto.ActionRequest;
import com.fractal.domain.navigation.action.dto.ActionResponse;
import com.fractal.domain.navigation.menu.action.dto.MenuActionRequest;

import java.util.List;

public interface MenuActionService {
    MenuAction create(MenuActionRequest dto);
    List<MenuAction> getAll();
    MenuAction getByUrl(String url);
    MenuAction getById(Long id);
    MenuAction update(Long id, MenuActionRequest dto);
    void deleteById(Long id);
    ActionResponse toDTO(MenuAction menuAction);
}
