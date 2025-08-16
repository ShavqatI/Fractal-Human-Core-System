package com.fractal.domain.education.accreditation_status;

import com.fractal.domain.education.accreditation_status.dto.AccreditationStatusRequest;
import com.fractal.domain.education.accreditation_status.dto.AccreditationStatusResponse;

import java.util.List;

public interface AccreditationStatusService {

    AccreditationStatus create(AccreditationStatusRequest dto);
    List<AccreditationStatus> getAll();
    AccreditationStatus getByCode(String code);
    AccreditationStatus getById(Long id);
    AccreditationStatus update(Long id, AccreditationStatusRequest dto);
    void deleteById(Long id);
    AccreditationStatusResponse toDTO(AccreditationStatus accreditationStatus);
}
