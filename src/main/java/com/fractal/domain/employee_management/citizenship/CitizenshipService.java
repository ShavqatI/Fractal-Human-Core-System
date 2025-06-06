package com.fractal.domain.employee_management.citizenship;

import com.fractal.domain.employee_management.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.employee_management.citizenship.dto.CitizenshipResponse;

public interface CitizenshipService {

    CitizenshipResponse toDTO(Citizenship citizenship);
    Citizenship toEntity(CitizenshipRequest dto);
    Citizenship update(Long id,CitizenshipRequest dto);
    void delete(Citizenship citizenship);
}
