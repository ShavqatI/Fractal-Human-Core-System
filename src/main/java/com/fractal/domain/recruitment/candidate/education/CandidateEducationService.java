package com.fractal.domain.recruitment.candidate.education;

import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.recruitment.candidate.education.dto.CandidateAddressRequest;
import com.fractal.domain.recruitment.candidate.education.dto.CandidateAddressResponse;

import java.util.List;

public interface CandidateEducationService {

    CandidateEducation create(Long candidateId, EducationRequest dto);
    CandidateEducation getById(Long candidateId, Long id);
    List<CandidateEducation> getAllByCandidateId(Long organizationId);
    CandidateEducation update(Long candidateId, Long id, EducationRequest dto);
    void delete(Long candidateId, Long id);
    EducationResponse toDTO(CandidateEducation address);
}
