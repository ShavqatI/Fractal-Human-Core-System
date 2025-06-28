package com.fractal.domain.navigation.menu;

import com.fractal.domain.navigation.menu.dto.MenuRequest;
import com.fractal.domain.navigation.menu.dto.MenuResponse;
import com.fractal.domain.organization_management.organization.Organization;
import com.fractal.domain.organization_management.organization.dto.OrganizationRequest;
import com.fractal.domain.organization_management.organization.dto.OrganizationResponse;

import java.util.List;

public interface MenuService {
    Menu create(MenuRequest dto);
    List<Menu> getAll();
    Menu getByUrl(String url);
    Menu getById(Long id);
    Menu update(Long id, MenuRequest dto);
    void deleteById(Long id);
    MenuResponse toDTO(Menu menu);
}
