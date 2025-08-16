package com.fractal.domain.recruitment.candidate.education;

import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.education.mapper.CandidateEducationMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateEducationServiceImpl implements CandidateEducationService {

    private final CandidateEducationRepository educationRepository;
    private final CandidateEducationMapperService educationMapperService;
    private final CandidateService candidateService;


    @Override
    @Transactional
    public CandidateEducation create(Long candidateId, EducationRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var education = educationMapperService.toEntity(dto);
        candidate.addEducation(education);
        candidateService.save(candidate);
        return education;
    }

    @Override
    public List<CandidateEducation> getAllByCandidateId(Long candidateId) {
        return educationRepository.findAllByCandidateId(candidateId);
    }

    @Override
    public CandidateEducation getById(Long candidateId, Long id) {
        return educationRepository.findByCandidateIdAndId(candidateId,id).orElseThrow(()-> new ResourceNotFoundException("Candidate education with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public CandidateEducation update(Long candidateId, Long id, EducationRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var education = candidate.getEducations()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Candidate education with id: " + id + " not found"));
        education = educationRepository.save(educationMapperService.toEntity(education,dto));
        candidateService.save(candidate);
        return education;
    }

    @Override
    public void delete(Long candidateId, Long id) {
        var candidate = candidateService.getById(candidateId);
        var education = candidate.getEducations()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Candidate education with id: " + id + " not found"));
        candidate.removeEducation(education);
        candidateService.save(candidate);
    }

    @Override
    public EducationResponse toDTO(CandidateEducation education) {
        return educationMapperService.toDTO(education);
    }
}
