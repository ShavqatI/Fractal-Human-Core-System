package com.fractal.domain.recruitment.candidate.resource;

import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceRequest;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceResponse;
import com.fractal.domain.recruitment.candidate.resource.mapper.CandidateResourceMapperService;
import com.fractal.domain.resource.FileService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateResourceServiceImpl implements CandidateResourceService {

    private final CandidateResourceRepository resourceRepository;
    private final CandidateResourceMapperService resourceMapperService;
    private final CandidateService candidateService;
    private final FileService fileService;

    @Value("${resource-storage.candidate}")
    private String resourceStoragePath;

    @Override
    public CandidateResource create(Long candidateId, CandidateResourceRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var resource = resourceMapperService.toEntity(dto, resourceStoragePath);
        candidate.addResource(resource);
        candidateService.save(candidate);
        return resource;
    }

    @Override
    public List<CandidateResource> getAllByCandidateId(Long candidateId) {
        return resourceRepository.findAllByCandidateId(candidateId);
    }

    @Override
    public CandidateResource getById(Long candidateId, Long id) {
        return resourceRepository.findByCandidateIdAndId(candidateId, id).orElseThrow(() -> new ResourceNotFoundException("Candidate Resource  with id: " + id + " not found"));
    }

    @Override
    public CandidateResource update(Long candidateId, Long id, CandidateResourceRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var resource = candidate.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Candidate Resource  with id: " + id + " not found"));
        resource = resourceMapperService.toEntity(resource, dto, resourceStoragePath);
        resourceRepository.save(resource);
        candidateService.save(candidate);
        return resource;
    }

    @Override
    public void delete(Long candidateId, Long id) {
        var candidate = candidateService.getById(candidateId);
        var resource = candidate.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Candidate Resource  with id: " + id + " not found"));
        fileService.delete(resource.getUrl());
        candidate.removeResource(resource);
        candidateService.save(candidate);
    }

    @Override
    public CandidateResourceResponse toDTO(CandidateResource resource) {
        return resourceMapperService.toDTO(resource);
    }
}
