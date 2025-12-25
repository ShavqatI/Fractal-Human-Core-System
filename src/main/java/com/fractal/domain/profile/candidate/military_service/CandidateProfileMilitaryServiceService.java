package com.fractal.domain.profile.candidate.military_service;

import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;
import com.fractal.domain.recruitment.candidate.military_service.CandidateMilitaryService;

import java.util.List;

public interface CandidateProfileMilitaryServiceService {
    CandidateMilitaryService create(MilitaryServiceRequest dto);
    List<CandidateMilitaryService> getAll();
    CandidateMilitaryService getById(Long id);
    CandidateMilitaryService update(Long id, MilitaryServiceRequest dto);
    void delete(Long id);
    MilitaryServiceResponse toDTO(CandidateMilitaryService candidateMilitaryService);


}
