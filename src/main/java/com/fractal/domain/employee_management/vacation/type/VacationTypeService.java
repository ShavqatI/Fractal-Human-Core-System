package com.fractal.domain.employee_management.vacation.type;

import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.dictionary.status.dto.StatusRequest;
import com.fractal.domain.dictionary.status.dto.StatusResponse;
import com.fractal.domain.employee_management.vacation.type.dto.VacationTypeRequest;
import com.fractal.domain.employee_management.vacation.type.dto.VacationTypeResponse;

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
