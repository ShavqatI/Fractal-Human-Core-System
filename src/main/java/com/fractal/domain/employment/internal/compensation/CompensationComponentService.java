package com.fractal.domain.employment.internal.compensation;

import com.fractal.domain.employment.internal.compensation.dto.CompensationComponentRequest;
import com.fractal.domain.employment.internal.compensation.dto.CompensationComponentResponse;

import java.util.List;

public interface CompensationComponentService {
    CompensationComponent create(Long employmentId, CompensationComponentRequest dto);
    List<CompensationComponent> getAllByInternalEmploymentId(Long employmentId);
    CompensationComponent getById(Long employmentId , Long id);
    CompensationComponent update(Long employmentId, Long id, CompensationComponentRequest dto);
    void delete(Long employmentId,Long id);
    CompensationComponentResponse toDTO(CompensationComponent agreement);
    CompensationComponent save(CompensationComponent agreement);
    CompensationComponent getById(Long id);

}
