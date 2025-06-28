package com.fractal.domain.navigation.menu.mapper;

import com.fractal.domain.navigation.menu.Menu;
import com.fractal.domain.navigation.menu.dto.MenuRequest;
import com.fractal.domain.navigation.menu.dto.MenuResponse;

public interface MenuMapperService {
    MenuResponse toDTO(Menu menu);
    Menu toEntity(MenuRequest dto);
    Menu toEntity(Menu menu, MenuRequest dto);
}


