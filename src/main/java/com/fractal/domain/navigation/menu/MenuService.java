package com.fractal.domain.navigation.menu;

import com.fractal.domain.navigation.menu.dto.MenuRequest;
import com.fractal.domain.navigation.menu.dto.MenuResponse;

import java.util.List;

public interface MenuService {
    Menu create(MenuRequest dto);
    List<Menu> getAll();
    Menu getByUrl(String url);
    Menu getById(Long id);
    Menu update(Long id, MenuRequest dto);
    void deleteById(Long id);
    MenuResponse toDTO(Menu menu);
    Menu save(Menu menu);
    Menu addChild(Long id, MenuRequest dto);
    Menu updateChild(Long id, Long childId, MenuRequest dto);
    Menu deleteChild(Long id, Long childId);
}
