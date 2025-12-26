package com.fractal.domain.profile.candidate.military_service;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;
import com.fractal.domain.recruitment.candidate.military_service.CandidateMilitaryService;
import com.fractal.domain.recruitment.candidate.military_service.CandidateMilitaryServiceService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateProfileMilitaryServiceServiceImpl implements CandidateProfileMilitaryServiceService {

   private final CandidateMilitaryServiceService militaryServiceService;
   private final AuthenticatedService authenticatedService;

    @Override
    public CandidateMilitaryService create(MilitaryServiceRequest dto) {
        return militaryServiceService.create(authenticatedService.getCandidateId(), dto);
    }

    @Override
    public List<CandidateMilitaryService> getAll() {
        return militaryServiceService.getAllByCandidateId(authenticatedService.getCandidateId());
    }

    @Override
    public CandidateMilitaryService getById(Long id) {
        return findById(id);
    }

    @Override
    public CandidateMilitaryService update(Long id, MilitaryServiceRequest dto) {
        return militaryServiceService.update(authenticatedService.getCandidateId(), findById(id).getId(),dto);
    }

    @Override
    public void delete(Long id) {
      militaryServiceService.delete(authenticatedService.getCandidateId(), findById(id).getId());
    }

    @Override
    public MilitaryServiceResponse toDTO(CandidateMilitaryService candidateMilitaryService) {
        return militaryServiceService.toDTO(candidateMilitaryService);
    }

    private CandidateMilitaryService findById(Long id) {
        return militaryServiceService.getAllByCandidateId(authenticatedService.getCandidateId()).stream()
                .filter(militaryService -> militaryService.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}
