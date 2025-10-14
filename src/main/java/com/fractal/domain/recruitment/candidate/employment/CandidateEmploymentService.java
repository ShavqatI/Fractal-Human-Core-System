package com.fractal.domain.recruitment.candidate.employment;

import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;

import java.util.List;

public interface CandidateEmploymentService {
    CandidateEmployment create(Long candidateId, ExternalEmploymentRequest dto);
    CandidateEmployment getById(Long candidateId, Long id);
    List<CandidateEmployment> getAllByCandidateId(Long candidateId);
    CandidateEmployment update(Long candidateId, Long id, ExternalEmploymentRequest dto);
    void delete(Long candidateId, Long id);
    EmploymentResponse toDTO(CandidateEmployment employment);

}
