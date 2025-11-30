package com.fractal.domain.employment.internal;

import com.fractal.domain.employment.internal.dto.InternalEmploymentRequest;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;

import java.util.List;

public interface InternalEmploymentService {
    InternalEmployment create(InternalEmploymentRequest dto);

    List<InternalEmployment> getAll();
    List<InternalEmployment> getAllApproved();

    InternalEmployment getById(Long id);

    InternalEmployment update(Long id, InternalEmploymentRequest dto);

    void deleteById(Long id);

    InternalEmploymentResponse toDTO(InternalEmployment employment);

    InternalEmployment save(InternalEmployment employment);


}
