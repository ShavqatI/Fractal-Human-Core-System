package com.fractal.domain.recruitment.candidate.military_service;


import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;

import java.util.List;

public interface CandidateMilitaryServiceService {

    CandidateMilitaryService create(Long candidateId, MilitaryServiceRequest dto);

    List<CandidateMilitaryService> getAllByCandidateId(Long candidateId);

    CandidateMilitaryService getById(Long candidateId, Long id);

    CandidateMilitaryService getById(Long id);

    MilitaryServiceResponse toDTO(CandidateMilitaryService candidateMilitaryService);

    CandidateMilitaryService update(Long candidateId, Long id, MilitaryServiceRequest dto);

    void delete(Long employeeId, Long id);

    CandidateMilitaryService save(CandidateMilitaryService candidateMilitaryService);

}
