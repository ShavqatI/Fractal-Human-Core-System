package com.fractal.domain.employee_management.relative.type;

import com.fractal.domain.employee_management.relative.type.dto.RelationTypeRequest;
import com.fractal.domain.employee_management.relative.type.dto.RelationTypeResponse;

import java.util.List;

public interface RelationTypeService {

    RelationType create(RelationTypeRequest dto);

    List<RelationType> getAll();

    RelationType getByCode(String code);

    RelationType getById(Long id);

    RelationType update(Long id, RelationTypeRequest dto);

    void deleteById(Long id);

    RelationTypeResponse toDTO(RelationType relationType);
}
