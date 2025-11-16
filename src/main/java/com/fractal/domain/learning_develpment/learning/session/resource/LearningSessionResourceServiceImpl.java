package com.fractal.domain.learning_develpment.learning.session.resource;

import com.fractal.domain.learning_develpment.learning.session.LearningSessionService;
import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceRequest;
import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceResponse;
import com.fractal.domain.learning_develpment.learning.session.resource.mapper.LearningSessionResourceMapperService;
import com.fractal.domain.resource.FileService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LearningSessionResourceServiceImpl implements LearningSessionResourceService {

    private final LearningSessionResourceRepository resourceRepository;
    private final LearningSessionResourceMapperService resourceMapperService;
    private final LearningSessionService sessionService;
    private final FileService fileService;

    @Value("${resource-storage.learning}")
    private String resourceStoragePath;

    @Override
    public LearningSessionResource create(Long sessionId, LearningSessionResourceRequest dto) {
        var session = sessionService.getById(sessionId);
        var resource = resourceMapperService.toEntity(dto, resourceStoragePath);
        session.addResource(resource);
        sessionService.save(session);
        return resource;
    }

    @Override
    public List<LearningSessionResource> getAllByLearningSessionId(Long sessionId) {
        return resourceRepository.findAllByLearningSessionId(sessionId);
    }

    @Override
    public LearningSessionResource getById(Long sessionId, Long id) {
        return resourceRepository.findByLearningSessionIdAndId(sessionId, id).orElseThrow(() -> new ResourceNotFoundException("Learning Session Resource with id: " + id + " not found"));
    }

    @Override
    public LearningSessionResource update(Long sessionId, Long id, LearningSessionResourceRequest dto) {
        var session = sessionService.getById(sessionId);
        var resource = session.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Learning Session Resource with id: " + id + " not found"));
        resource = resourceMapperService.toEntity(resource, dto, resourceStoragePath);
        resourceRepository.save(resource);
        sessionService.save(session);
        return resource;
    }

    @Override
    public void delete(Long sessionId, Long id) {
        var session = sessionService.getById(sessionId);
        var resource = session.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Learning Session Resource with id: " + id + " not found"));
        fileService.delete(resource.getUrl());
        session.removeResource(resource);
        sessionService.save(session);
    }

    @Override
    public LearningSessionResourceResponse toDTO(LearningSessionResource resource) {
        return resourceMapperService.toDTO(resource);
    }
}
