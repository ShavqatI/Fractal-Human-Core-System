package com.fractal.domain.employee_management.subordinate.type;

import com.fractal.domain.employee_management.subordinate.type.dto.SubordinateTypeRequest;
import com.fractal.domain.employee_management.subordinate.type.dto.SubordinateTypeResponse;

import java.util.List;

public interface SubordinateTypeService {

    SubordinateType create(SubordinateTypeRequest dto);

    List<SubordinateType> getAll();

    SubordinateType getByCode(String code);

    SubordinateType getById(Long id);

    SubordinateType update(Long id, SubordinateTypeRequest dto);

    void deleteById(Long id);

    SubordinateTypeResponse toDTO(SubordinateType subordinateType);
}
