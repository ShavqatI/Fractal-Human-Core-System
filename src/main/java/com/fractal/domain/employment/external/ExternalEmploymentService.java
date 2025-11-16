package com.fractal.domain.employment.external;

import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.employment.external.dto.ExternalEmploymentResponse;

import java.util.List;

public interface ExternalEmploymentService {
    ExternalEmployment create(ExternalEmploymentRequest dto);

    List<ExternalEmployment> getAll();

    ExternalEmployment getById(Long id);

    ExternalEmployment update(Long id, ExternalEmploymentRequest dto);

    void deleteById(Long id);

    ExternalEmploymentResponse toDTO(ExternalEmployment instructor);

    ExternalEmployment save(ExternalEmployment employment);
}
