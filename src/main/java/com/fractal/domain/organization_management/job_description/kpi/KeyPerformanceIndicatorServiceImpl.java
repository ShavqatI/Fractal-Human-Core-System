package com.fractal.domain.organization_management.job_description.kpi;

import com.fractal.domain.organization_management.job_description.JobDescriptionService;
import com.fractal.domain.organization_management.job_description.kpi.dto.KeyPerformanceIndicatorRequest;
import com.fractal.domain.organization_management.job_description.kpi.dto.KeyPerformanceIndicatorResponse;
import com.fractal.domain.organization_management.job_description.kpi.mapper.KeyPerformanceIndicatorMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class KeyPerformanceIndicatorServiceImpl implements KeyPerformanceIndicatorService {

      private final KeyPerformanceIndicatorRepository keyPerformanceIndicatorRepository;
      private final KeyPerformanceIndicatorMapperService mapperService;
      private final JobDescriptionService jobDescriptionService;

    @Override
    @Transactional
    public KeyPerformanceIndicator create(Long jobDescriptionId, KeyPerformanceIndicatorRequest dto) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var keyPerformanceIndicator = mapperService.toEntity(dto);
        jobDescription.addKeyPerformanceIndicator(keyPerformanceIndicator);
        jobDescriptionService.save(jobDescription);
        return keyPerformanceIndicator;
    }

    @Override
    public List<KeyPerformanceIndicator> getAllByJobDescriptionId(Long jobDescriptionId) {
        return keyPerformanceIndicatorRepository.findAllByJobDescriptionId(jobDescriptionId);
    }

    @Override
    public KeyPerformanceIndicator getById(Long jobDescriptionId, Long id) {
        return keyPerformanceIndicatorRepository.findByJobDescriptionIdAndId(jobDescriptionId,id).orElseThrow(()-> new ResourceNotFoundException("Key Performance Indicator with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public KeyPerformanceIndicator update(Long jobDescriptionId, Long id, KeyPerformanceIndicatorRequest dto) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var keyPerformanceIndicator = jobDescription.getKeyPerformanceIndicators().stream()
                .filter(q -> q.getId().equals(id))
                .findFirst().orElseThrow(()-> new ResourceNotFoundException("Key Performance Indicator with id: " + id + " not found"));
        keyPerformanceIndicator = keyPerformanceIndicatorRepository.save(mapperService.toEntity(keyPerformanceIndicator,dto));
        jobDescriptionService.save(jobDescription);
        return keyPerformanceIndicator;
    }

    @Override
    @Transactional
    public void delete(Long jobDescriptionId, Long id) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var keyPerformanceIndicator = jobDescription.getKeyPerformanceIndicators().stream()
                .filter(q -> q.getId().equals(id))
                .findFirst().orElseThrow(()-> new ResourceNotFoundException("Key Performance Indicator with id: " + id + " not found"));
        jobDescription.removeKeyPerformanceIndicator(keyPerformanceIndicator);
        keyPerformanceIndicatorRepository.delete(keyPerformanceIndicator);
        jobDescriptionService.save(jobDescription);
    }

    @Override
    public KeyPerformanceIndicatorResponse toDTO(KeyPerformanceIndicator keyPerformanceIndicator) {
        return mapperService.toDTO(keyPerformanceIndicator);
    }
}
