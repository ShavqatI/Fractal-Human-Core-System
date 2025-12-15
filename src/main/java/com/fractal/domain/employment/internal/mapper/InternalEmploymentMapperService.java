package com.fractal.domain.employment.internal.mapper;

import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.dto.InternalEmploymentApprovedResponse;
import com.fractal.domain.employment.internal.dto.InternalEmploymentRequest;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import com.fractal.domain.employment.internal.dto.TerminationRequest;

public interface InternalEmploymentMapperService {
    InternalEmploymentResponse toDTO(InternalEmployment employment);
    InternalEmployment toEntity(InternalEmploymentRequest dto);

    InternalEmployment toEntity(InternalEmployment employment, InternalEmploymentRequest dto);
    InternalEmployment toEntity(InternalEmployment employment, TerminationRequest dto);

    InternalEmployment copy(InternalEmployment employment);
}


