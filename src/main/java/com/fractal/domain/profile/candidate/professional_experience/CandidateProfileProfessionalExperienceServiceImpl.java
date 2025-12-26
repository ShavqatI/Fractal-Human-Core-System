package com.fractal.domain.profile.candidate.professional_experience;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.recruitment.candidate.professional_experience.CandidateProfessionalExperience;
import com.fractal.domain.recruitment.candidate.professional_experience.CandidateProfessionalExperienceService;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceRequest;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateProfileProfessionalExperienceServiceImpl implements CandidateProfileProfessionalExperienceService {

   private final CandidateProfessionalExperienceService professionalExperienceService;
   private final AuthenticatedService authenticatedService;


    @Override
    public CandidateProfessionalExperience create(CandidateProfessionalExperienceRequest dto) {
        return professionalExperienceService.create(authenticatedService.getCandidateId(), dto);
    }

    @Override
    public List<CandidateProfessionalExperience> getAll() {
        return professionalExperienceService.getAllByCandidateId(authenticatedService.getCandidateId());
    }

    @Override
    public CandidateProfessionalExperience getById(Long id) {
        return findById(id);
    }

    @Override
    public CandidateProfessionalExperience update(Long id, CandidateProfessionalExperienceRequest dto) {
        return professionalExperienceService.update(authenticatedService.getCandidateId(), findById(id).getId(),dto);
    }

    @Override
    public void delete(Long id) {
       professionalExperienceService.delete(authenticatedService.getCandidateId(), findById(id).getId());
    }

    @Override
    public CandidateProfessionalExperienceResponse toDTO(CandidateProfessionalExperience professionalExperience) {
        return professionalExperienceService.toDTO(professionalExperience);
    }

    private CandidateProfessionalExperience findById(Long id) {
        return professionalExperienceService.getAllByCandidateId(authenticatedService.getCandidateId()).stream()
                .filter(professionalExperience -> professionalExperience.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}
