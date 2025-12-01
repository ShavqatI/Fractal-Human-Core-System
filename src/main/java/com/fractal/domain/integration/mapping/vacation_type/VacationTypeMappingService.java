package com.fractal.domain.integration.mapping.vacation_type;

import com.fractal.domain.integration.mapping.vacation_type.dto.VacationTypeMappingRequest;
import com.fractal.domain.integration.mapping.vacation_type.dto.VacationTypeMappingResponse;

import java.util.List;

public interface VacationTypeMappingService {

    VacationTypeMapping create(VacationTypeMappingRequest dto);

    List<VacationTypeMapping> getAll();

    VacationTypeMapping getById(Long id);

    VacationTypeMapping update(Long id, VacationTypeMappingRequest dto);

    void deleteById(Long id);

    VacationTypeMappingResponse toDTO(VacationTypeMapping vacationTypeMapping);
}
