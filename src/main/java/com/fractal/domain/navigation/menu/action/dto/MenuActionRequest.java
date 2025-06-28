package com.fractal.domain.navigation.menu.action.dto;

import java.util.List;

public record MenuActionRequest(
        Long menuId,
        List<Long> actions
) {}
