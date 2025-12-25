package com.fractal.domain.profile.candidate.employment;

import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.recruitment.candidate.employment.CandidateEmployment;

import java.util.List;

public interface CandidateProfileEmploymentService {
    CandidateEmployment create(ExternalEmploymentRequest dto);

    CandidateEmployment getById(Long id);

    List<CandidateEmployment> getAll();

    CandidateEmployment update(Long id, ExternalEmploymentRequest dto);

    void delete(Long id);

    EmploymentResponse toDTO(CandidateEmployment employment);


}
