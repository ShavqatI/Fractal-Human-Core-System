package com.fractal.domain.recruitment.candidate.professional_experience;

import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceRequest;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceResponse;
import com.fractal.domain.recruitment.candidate.professional_experience.mapper.CandidateProfessionalExperienceMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateProfessionalExperienceServiceImpl implements CandidateProfessionalExperienceService {

    private final CandidateProfessionalExperienceRepository professionalExperienceRepository;
    private final CandidateProfessionalExperienceMapperService mapperService;
    private final CandidateService candidateService;

    @Override
    public CandidateProfessionalExperience create(Long candidateId, CandidateProfessionalExperienceRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var professionalExperience = mapperService.toEntity(dto);
        candidate.addProfessionalExperience(professionalExperience);
        candidateService.save(candidate);
        return professionalExperience;
    }

    @Override
    public List<CandidateProfessionalExperience> getAllByCandidateId(Long candidateId) {
        return professionalExperienceRepository.findAllByCandidateId(candidateId);
    }

    @Override
    public CandidateProfessionalExperience getById(Long candidateId, Long id) {
        return professionalExperienceRepository.findByCandidateIdAndId(candidateId, id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }

    @Override
    public CandidateProfessionalExperience update(Long candidateId, Long id, CandidateProfessionalExperienceRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var professionalExperience = candidate.getProfessionalExperiences()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        professionalExperience = mapperService.toEntity(professionalExperience, dto);
        professionalExperienceRepository.save(professionalExperience);
        candidateService.save(candidate);
        return professionalExperience;
    }

    @Override
    public void delete(Long candidateId, Long id) {
        var candidate = candidateService.getById(candidateId);
        var professionalExperience = candidate.getProfessionalExperiences()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        candidate.removeProfessionalExperience(professionalExperience);
        candidateService.save(candidate);
    }

    @Override
    public CandidateProfessionalExperienceResponse toDTO(CandidateProfessionalExperience professionalExperience) {
        return mapperService.toDTO(professionalExperience);
    }

}
