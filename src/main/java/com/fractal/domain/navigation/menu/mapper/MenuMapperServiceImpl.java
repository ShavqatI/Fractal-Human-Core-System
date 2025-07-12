package com.fractal.domain.navigation.menu.mapper;

import com.fractal.domain.localization.layout_label.LayoutLabelService;
import com.fractal.domain.navigation.menu.Menu;
import com.fractal.domain.navigation.menu.dto.MenuRequest;
import com.fractal.domain.navigation.menu.dto.MenuResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class MenuMapperServiceImpl implements MenuMapperService {

    private final LayoutLabelService layoutLabelService;

    @Override
    public MenuResponse toDTO(Menu menu) {
        return new MenuResponse(
                menu.getId(),
                menu.getName(),
                menu.getUrl(),
                menu.getLevel(),
                menu.getIcon(),
                layoutLabelService.toDTO(menu.getLayoutLabel()),
                menu.getSequence(),
                Optional.ofNullable(menu.getChildren())
                        .orElse(emptyList())
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList()),
                menu.getCreatedDate()

        );
    }

    @Override
    public Menu toEntity(MenuRequest dto) {
        return mapToEntity( new Menu(),dto);
    }

    @Override
    public Menu toEntity(Menu menu, MenuRequest dto) {
        return mapToEntity( menu,dto);
    }

    private Menu mapToEntity(Menu menu, MenuRequest dto) {
        menu.setName(dto.name());
        menu.setUrl(dto.url());
        menu.setLevel(dto.level());
        menu.setIcon(dto.icon());
        menu.setLayoutLabel(layoutLabelService.getById(dto.layoutLabelId()));
        menu.setSequence(dto.sequence());
        dto.children().forEach(child->menu.addChild(toEntity(child)));
        return menu;
    }
}
