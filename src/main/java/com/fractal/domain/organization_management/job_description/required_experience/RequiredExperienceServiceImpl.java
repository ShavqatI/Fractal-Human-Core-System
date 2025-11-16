package com.fractal.domain.organization_management.job_description.required_experience;

import com.fractal.domain.organization_management.job_description.JobDescriptionService;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceResponse;
import com.fractal.domain.organization_management.job_description.required_experience.mapper.RequiredExperienceMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class RequiredExperienceServiceImpl implements RequiredExperienceService {
    private final RequiredExperienceRepository requiredExperienceRepository;
    private final RequiredExperienceMapperService mapperService;
    private final JobDescriptionService jobDescriptionService;

    @Override
    @Transactional
    public RequiredExperience create(Long jobDescriptionId, RequiredExperienceRequest dto) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var requiredExperience = mapperService.toEntity(dto);
        jobDescription.addRequiredExperience(requiredExperience);
        jobDescriptionService.save(jobDescription);
        return requiredExperience;
    }

    @Override
    public List<RequiredExperience> getAllByJobDescriptionId(Long jobDescriptionId) {
        return requiredExperienceRepository.findAllByJobDescriptionId(jobDescriptionId);
    }

    @Override
    public RequiredExperience getById(Long jobDescriptionId, Long id) {
        return requiredExperienceRepository.findByJobDescriptionIdAndId(jobDescriptionId, id).orElseThrow(() -> new ResourceNotFoundException("Required Experience with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public RequiredExperience update(Long jobDescriptionId, Long id, RequiredExperienceRequest dto) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var requiredExperience = jobDescription.getRequiredExperiences().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Required Experience with id: " + id + " not found"));
        requiredExperience = requiredExperienceRepository.save(mapperService.toEntity(requiredExperience, dto));
        jobDescriptionService.save(jobDescription);
        return requiredExperience;
    }

    @Override
    @Transactional
    public void delete(Long jobDescriptionId, Long id) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var requiredExperience = jobDescription.getRequiredExperiences().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Required Experience with id: " + id + " not found"));
        jobDescription.removeRequiredExperience(requiredExperience);
        jobDescriptionService.save(jobDescription);
    }

    @Override
    public RequiredExperienceResponse toDTO(RequiredExperience requiredExperience) {
        return mapperService.toDTO(requiredExperience);
    }
}
