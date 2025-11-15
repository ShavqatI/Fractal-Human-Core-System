package com.fractal.domain.vacation_management.type;

import com.fractal.domain.vacation_management.type.dto.VacationTypeRequest;
import com.fractal.domain.vacation_management.type.dto.VacationTypeResponse;

import java.util.List;

public interface VacationTypeService {

    VacationType create(VacationTypeRequest dto);
    List<VacationType> getAll();
    VacationType getByCode(String code);
    VacationType getById(Long id);
    VacationType update(Long id, VacationTypeRequest dto);
    void deleteById(Long id);
    VacationTypeResponse toDTO(VacationType vacationType);
}
