package com.fractal.domain.navigation.action.mapper;

import com.fractal.domain.localization.layout_label.LayoutLabelService;
import com.fractal.domain.navigation.action.Action;
import com.fractal.domain.navigation.action.category.ActionCategoryService;
import com.fractal.domain.navigation.action.dto.ActionCompactResponse;
import com.fractal.domain.navigation.action.dto.ActionRequest;
import com.fractal.domain.navigation.action.dto.ActionResponse;
import com.fractal.domain.navigation.action.type.ActionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ActionMapperServiceImpl implements ActionMapperService {

    private final ActionCategoryService actionCategoryService;
    private final ActionTypeService actionTypeService;
    private final LayoutLabelService layoutLabelService;
    @Override
    public ActionResponse toDTO(Action action) {
        return new ActionResponse(
                action.getId(),
                action.getName(),
                action.getUrl(),
                action.getIcon(),
                layoutLabelService.toDTO(action.getLayoutLabel()),
                actionTypeService.toDTO(action.getActionType()),
                actionCategoryService.toDTO(action.getActionCategory()),
                action.getCreatedDate()
        );
    }

    @Override
    public ActionCompactResponse toCompactDTO(Action action) {
        return new ActionCompactResponse(
                action.getId(),
                action.getName(),
                action.getUrl()
        );
    }

    @Override
    public Action toEntity(ActionRequest dto) {
        return mapToEntity( new Action(),dto);
    }

    @Override
    public Action toEntity(Action action, ActionRequest dto) {
        return mapToEntity(action,dto);
    }

    private Action mapToEntity(Action action, ActionRequest dto) {
        action.setName(dto.name());
        action.setUrl(dto.url());
        action.setIcon(dto.icon());
        action.setLayoutLabel(layoutLabelService.getById(dto.layoutLabelId()));
        action.setActionCategory(actionCategoryService.getById(dto.actionCategoryId()));
        action.setActionType(actionTypeService.getById(dto.actionTypeId()));
        return action;
    }
}
