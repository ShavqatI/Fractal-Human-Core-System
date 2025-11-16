package com.fractal.domain.organization_management.job_description.responsibility;

import com.fractal.domain.organization_management.job_description.JobDescriptionService;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityResponse;
import com.fractal.domain.organization_management.job_description.responsibility.mapper.ResponsibilityMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class ResponsibilityServiceImpl implements ResponsibilityService {

    private final ResponsibilityRepository responsibilityRepository;
    private final ResponsibilityMapperService mapperService;
    private final JobDescriptionService jobDescriptionService;

    @Override
    @Transactional
    public Responsibility create(Long jobDescriptionId, ResponsibilityRequest dto) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var responsibility = mapperService.toEntity(dto);
        jobDescription.addResponsibility(responsibility);
        jobDescriptionService.save(jobDescription);
        return responsibility;
    }

    @Override
    public List<Responsibility> getAllByJobDescriptionId(Long jobDescriptionId) {
        return responsibilityRepository.findAllByJobDescriptionId(jobDescriptionId);
    }

    @Override
    public Responsibility getById(Long jobDescriptionId, Long id) {
        return responsibilityRepository.findByJobDescriptionIdAndId(jobDescriptionId, id).orElseThrow(() -> new ResourceNotFoundException("Responsibility with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public Responsibility update(Long jobDescriptionId, Long id, ResponsibilityRequest dto) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        Responsibility responsibility = jobDescription.getResponsibilities().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Responsibility with id: " + id + " not found"));
        responsibility = responsibilityRepository.save(mapperService.toEntity(responsibility, dto));
        jobDescriptionService.save(jobDescription);
        return responsibility;
    }

    @Override
    @Transactional
    public void delete(Long jobDescriptionId, Long id) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        Responsibility responsibility = jobDescription.getResponsibilities().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Responsibility with id: " + id + " not found"));
        jobDescription.removeResponsibility(responsibility);
        jobDescriptionService.save(jobDescription);

    }

    @Override
    public ResponsibilityResponse toDTO(Responsibility responsibility) {
        return mapperService.toDTO(responsibility);
    }

}
