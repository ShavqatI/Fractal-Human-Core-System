package com.fractal.domain.recruitment.candidate.work_experience;

import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;
import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.work_experience.mapper.CandidateWorkExperienceMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateWorkExperienceServiceImpl implements CandidateWorkExperienceService {

    private final CandidateWorkExperienceRepository workExperienceRepository;
    private final CandidateWorkExperienceMapperService workExperienceMapperService;
    private final CandidateService candidateService;


    @Override
    @Transactional
    public CandidateWorkExperience create(Long candidateId, WorkExperienceRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var workExperience = workExperienceMapperService.toEntity(dto);
        candidate.addWorkExperience(workExperience);
        candidateService.save(candidate);
        return workExperience;
    }

    @Override
    public List<CandidateWorkExperience> getAllByCandidateId(Long candidateId) {
        return workExperienceRepository.findAllByCandidateId(candidateId);
    }

    @Override
    public CandidateWorkExperience getById(Long candidateId, Long id) {
        return workExperienceRepository.findByCandidateIdAndId(candidateId,id).orElseThrow(()-> new ResourceNotFoundException("Candidate Work Experience  with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public CandidateWorkExperience update(Long candidateId, Long id, WorkExperienceRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var workExperience = candidate.getWorkExperiences()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Candidate Work Experience  with id: " + id + " not found"));
        workExperience = workExperienceRepository.save(workExperienceMapperService.toEntity(workExperience,dto));
        candidateService.save(candidate);
        return workExperience;
    }

    @Override
    public void delete(Long candidateId, Long id) {
        var candidate = candidateService.getById(candidateId);
        var workExperience = candidate.getWorkExperiences()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Candidate Work Experience  with id: " + id + " not found"));
        candidate.removeWorkExperience(workExperience);
        candidateService.save(candidate);
    }

    @Override
    public WorkExperienceResponse toDTO(CandidateWorkExperience workExperience) {
        return workExperienceMapperService.toDTO(workExperience);
    }
}
