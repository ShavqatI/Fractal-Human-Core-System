package com.fractal.domain.employee_management.education.accreditation_status;

import com.fractal.domain.employee_management.education.accreditation_status.dto.AccreditationStatusRequest;
import com.fractal.domain.employee_management.education.degree_type.dto.DegreeTypeResponse;

import java.util.List;

public interface AccreditationStatusService {

    AccreditationStatus create(AccreditationStatusRequest dto);
    List<AccreditationStatus> getAll();
    AccreditationStatus getByCode(String code);
    AccreditationStatus getById(Long id);
    AccreditationStatus update(Long id, AccreditationStatusRequest dto);
    void deleteById(Long id);
    DegreeTypeResponse toDTO(AccreditationStatus accreditationStatus);
}
