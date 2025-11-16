package com.fractal.domain.employee_management.relative;

import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeResponse;

import java.util.List;


public interface RelativeService {
    Relative create(Long employeeId, RelativeRequest dto);

    Relative getById(Long id);

    List<Relative> getAllByEmployeeId(Long employeeId);

    Relative getById(Long employeeId, Long id);

    Relative update(Long employeeId, Long id, RelativeRequest dto);

    void delete(Long employeeId, Long id);

    RelativeResponse toDTO(Relative relative);

    Relative save(Relative relative);


}
