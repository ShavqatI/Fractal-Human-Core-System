package com.fractal.domain.navigation.menu.action;

import com.fractal.domain.navigation.action.Action;
import com.fractal.domain.navigation.action.ActionService;
import com.fractal.domain.navigation.action.dto.ActionRequest;
import com.fractal.domain.navigation.action.dto.ActionResponse;
import com.fractal.domain.navigation.action.mapper.ActionMapperService;
import com.fractal.domain.navigation.menu.MenuService;
import com.fractal.domain.navigation.menu.action.dto.MenuActionRequest;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class MenuActionServiceImpl implements MenuActionService {

    private final MenuActionRepository menuActionRepository;
    private final MenuService menuService;
    private final ActionService actionService;

    @Override
    public MenuAction create(MenuActionRequest dto) {
        var menu = menuService.getById(dto.menuId());
        dto.actions().forEach(actionId-> {
            var menuAction = new MenuAction();
            menuAction.setAction(actionService.getById(actionId));
            menu.addAction(menuAction);
        });

    }

    @Override
    public List<MenuAction> getAll() {
        return null;
    }

    @Override
    public MenuAction getByUrl(String url) {
        return null;
    }

    @Override
    public MenuAction getById(Long id) {
        return null;
    }

    @Override
    public MenuAction update(Long id, MenuActionRequest dto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public ActionResponse toDTO(MenuAction menuAction) {
        return null;
    }
}
