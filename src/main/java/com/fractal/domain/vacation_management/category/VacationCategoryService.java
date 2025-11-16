package com.fractal.domain.vacation_management.category;

import com.fractal.domain.vacation_management.category.dto.VacationCategoryRequest;
import com.fractal.domain.vacation_management.category.dto.VacationCategoryResponse;

import java.util.List;

public interface VacationCategoryService {

    VacationCategory create(VacationCategoryRequest dto);

    List<VacationCategory> getAll();

    VacationCategory getByCode(String code);

    VacationCategory getById(Long id);

    VacationCategory update(Long id, VacationCategoryRequest dto);

    void deleteById(Long id);

    VacationCategoryResponse toDTO(VacationCategory vacationCategory);
}
