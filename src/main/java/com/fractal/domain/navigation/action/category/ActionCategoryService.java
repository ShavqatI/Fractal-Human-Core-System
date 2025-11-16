package com.fractal.domain.navigation.action.category;

import com.fractal.domain.navigation.action.category.dto.ActionCategoryRequest;
import com.fractal.domain.navigation.action.category.dto.ActionCategoryResponse;

import java.util.List;

public interface ActionCategoryService {

    ActionCategory create(ActionCategoryRequest dto);

    List<ActionCategory> getAll();

    ActionCategory getByCode(String code);

    ActionCategory getById(Long id);

    ActionCategory update(Long id, ActionCategoryRequest dto);

    void deleteById(Long id);

    ActionCategoryResponse toDTO(ActionCategory actionCategory);
}
