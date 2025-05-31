package com.fractal.domain.employee_management.vacation.category;

import com.fractal.domain.employee_management.vacation.category.dto.VacationCategoryRequest;
import com.fractal.domain.employee_management.vacation.category.dto.VacationCategoryResponse;

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
