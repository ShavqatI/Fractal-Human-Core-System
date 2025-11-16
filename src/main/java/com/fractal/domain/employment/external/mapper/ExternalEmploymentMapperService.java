package com.fractal.domain.employment.external.mapper;

import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.external.ExternalEmployment;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.employment.external.dto.ExternalEmploymentResponse;

public interface ExternalEmploymentMapperService {
    ExternalEmploymentResponse toDTO(ExternalEmployment employment);

    ExternalEmployment toEntity(ExternalEmploymentRequest dto);

    ExternalEmployment toEntity(ExternalEmployment employment, ExternalEmploymentRequest dto);

    Employment copy(ExternalEmployment employment);
}


