package com.fractal.domain.navigation.menu.action;

import com.fractal.domain.navigation.action.ActionService;
import com.fractal.domain.navigation.menu.MenuService;
import com.fractal.domain.navigation.menu.action.dto.MenuActionRequest;
import com.fractal.domain.navigation.menu.action.dto.MenuActionResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
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
    @Transactional
    public MenuAction create(Long menuId,MenuActionRequest dto) {
        var menu = menuService.getById(menuId);
        var menuAction = toEntity(dto);
        menu.addAction(menuAction);
        menuService.save(menu);
        return menuAction;
    }

    private MenuAction toEntity(MenuActionRequest dto) {
        return MenuAction.builder().action(actionService.getById(dto.actionId())).build();
    }

    @Override
    public List<MenuAction> getAllByMenuId(Long menuId) {
        return menuActionRepository.findAllByMenuId(menuId);
    }

    @Override
    public MenuAction getById(Long menuId,Long id) {
        return menuActionRepository.findByMenuIdAndId(menuId,id).orElseThrow(()->new ResourceNotFoundException("Menu action with id: " + id + " not found"));
    }

    @Override
    public MenuAction getById(Long id) {
        return menuActionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Menu action with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public MenuAction update(Long menuId,Long id, MenuActionRequest dto) {
        var menu = menuService.getById(menuId);
        var menuAction = menu.getMenuActions().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst().orElseThrow(()-> new ResourceNotFoundException("Menu action with id: " + id + " not found"));
        menuAction.setAction(actionService.getById(dto.actionId()));
        menuAction = menuActionRepository.save(menuAction);
        menuService.save(menu);
        return menuAction;
    }

    @Override
    @Transactional
    public void delete(Long menuId, Long id) {
        var menu = menuService.getById(menuId);
        var menuAction = menu.getMenuActions().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst().orElseThrow(()-> new ResourceNotFoundException("Menu action with id: " + id + " not found"));
        menu.removeAction(menuAction);
        menuActionRepository.delete(menuAction);
        menuService.save(menu);
    }

    @Override
    public MenuActionResponse toDTO(MenuAction menuAction) {
        return new MenuActionResponse(
                menuAction.getId(),
                menuAction.getAction().getName(),
                menuAction.getCreatedDate()
        );
    }
}
