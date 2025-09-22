package com.fractal.domain.training_management.training.resource;

import com.fractal.domain.training_management.training.TrainingService;
import com.fractal.domain.training_management.training.resource.dto.TrainingResourceRequest;
import com.fractal.domain.training_management.training.resource.dto.TrainingResourceResponse;
import com.fractal.domain.training_management.training.resource.mapper.TrainingResourceMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingResourceServiceImpl implements TrainingResourceService {

    private final TrainingResourceRepository resourceRepository;
    private final TrainingResourceMapperService resourceMapperService;
    private final TrainingService trainingService;

    @Override
    public TrainingResource create(Long candidateId, TrainingResourceRequest dto) {
        var training = trainingService.getById(candidateId);
        var resource =  resourceMapperService.toEntity(dto,null);
        training.addResource(resource);
        trainingService.save(training);
        return resource;
    }

    @Override
    public List<TrainingResource> getAllByEducationId(Long educationId) {
        return resourceRepository.findAllByTrainingId(educationId);
    }

    @Override
    public TrainingResource getById(Long educationId, Long id) {
        return resourceRepository.findByTrainingIdAndId(educationId,id).orElseThrow(()-> new ResourceNotFoundException("Candidate Resource  with id: " + id + " not found"));
    }

    @Override
    public TrainingResource update(Long candidateId, Long id, TrainingResourceRequest dto) {
        var training = trainingService.getById(candidateId);
        var resource = training.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Candidate Resource  with id: " + id + " not found"));
        resource = resourceMapperService.toEntity(resource,dto,null);
        resourceRepository.save(resource);
        trainingService.save(training);
        return resource;
    }

    @Override
    public void delete(Long candidateId, Long id) {
        var training = trainingService.getById(candidateId);
        var resource = training.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Candidate Resource  with id: " + id + " not found"));
        training.removeResource(resource);
        trainingService.save(training);
    }

    @Override
    public TrainingResourceResponse toDTO(TrainingResource resource) {
        return resourceMapperService.toDTO(resource);
    }
}
