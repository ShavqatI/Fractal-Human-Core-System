package com.fractal.domain.dictionary.status.category;

import com.fractal.domain.dictionary.status.category.dto.StatusCategoryRequest;
import com.fractal.domain.dictionary.status.category.dto.StatusCategoryResponse;

import java.util.List;

public interface StatusCategoryService {

    StatusCategory create(StatusCategoryRequest dto);

    List<StatusCategory> getAll();

    StatusCategory getByCode(String code);

    StatusCategory getById(Long id);

    StatusCategory update(Long id, StatusCategoryRequest dto);

    void deleteById(Long id);

    StatusCategoryResponse toDTO(StatusCategory statusCategory);
}
