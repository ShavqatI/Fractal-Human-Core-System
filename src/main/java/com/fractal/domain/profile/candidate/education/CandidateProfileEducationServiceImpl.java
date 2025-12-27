package com.fractal.domain.profile.candidate.education;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.recruitment.candidate.education.CandidateEducation;
import com.fractal.domain.recruitment.candidate.education.CandidateEducationService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateProfileEducationServiceImpl implements CandidateProfileEducationService {

   private final CandidateEducationService educationService;
   private final AuthenticatedService authenticatedService;


    @Override
    public CandidateEducation create(EducationRequest dto) {
        return educationService.create(authenticatedService.getCandidateId(),dto);
    }

    @Override
    public CandidateEducation getById(Long id) {
        return findById(id);
    }

    @Override
    public List<CandidateEducation> getAll() {
        return educationService.getAllByCandidateId(authenticatedService.getCandidateId());
    }

    @Override
    public CandidateEducation update(Long id, EducationRequest dto) {
        return educationService.update(authenticatedService.getCandidateId(), findById(id).getId(),dto);
    }

    @Override
    public void delete(Long id) {
       educationService.delete(authenticatedService.getCandidateId(), findById(id).getId());
    }

    @Override
    public EducationResponse toDTO(CandidateEducation education) {
        return educationService.toDTO(education);
    }

    private CandidateEducation findById(Long id) {
        return educationService.getAllByCandidateId(authenticatedService.getCandidateId()).stream()
                .filter(education -> education.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}
