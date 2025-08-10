package com.fractal.domain.citizenship;

import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.citizenship.dto.CitizenshipResponse;

import java.util.List;

public interface CitizenshipService {

    Citizenship create(Long employeeId, CitizenshipRequest dto);
    List<Citizenship> getAllByEmployeeId(Long employeeId);
    Citizenship getById(Long employeeId , Long id);
    Citizenship update(Long employeeId, Long id, CitizenshipRequest dto);
    void delete(Long employeeId,Long id);
    CitizenshipResponse toDTO(Citizenship citizenship);

}
