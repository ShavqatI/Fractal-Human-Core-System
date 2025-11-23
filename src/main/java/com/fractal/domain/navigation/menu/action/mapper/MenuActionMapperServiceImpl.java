package com.fractal.domain.navigation.menu.action.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.navigation.action.ActionService;
import com.fractal.domain.navigation.menu.action.MenuAction;
import com.fractal.domain.navigation.menu.action.dto.MenuActionRequest;
import com.fractal.domain.navigation.menu.action.dto.MenuActionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class MenuActionMapperServiceImpl implements MenuActionMapperService {

    private final ActionService actionService;
    private final StatusService statusService;



    @Override
    public MenuActionResponse toDTO(MenuAction menuAction) {
        return new MenuActionResponse(
                menuAction.getId(),
                new MenuActionResponse.Menu(menuAction.getMenu().getId(),menuAction.getMenu().getName()),
                actionService.toCompactDTO(menuAction.getAction()),
                statusService.toCompactDTO(menuAction.getStatus()),
                menuAction.getCreatedDate()
        );
    }

    @Override
    public MenuAction toEntity(MenuActionRequest dto) {
        return mapToEntity(new MenuAction(), dto);
    }

    @Override
    public MenuAction toEntity(MenuAction menuAction, MenuActionRequest dto) {
        return mapToEntity(menuAction, dto);
    }

    private MenuAction mapToEntity(MenuAction menuAction, MenuActionRequest dto) {
        menuAction.setAction(actionService.getById(dto.actionId()));
        menuAction.setStatus(statusService.getById(dto.statusId()));
        return menuAction;
    }
}
