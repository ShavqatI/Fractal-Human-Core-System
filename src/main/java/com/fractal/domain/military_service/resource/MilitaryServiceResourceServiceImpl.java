package com.fractal.domain.military_service.resource;

import com.fractal.domain.military_service.MilitaryServiceService;
import com.fractal.domain.military_service.resource.mapper.MilitaryServiceResourceMapperService;
import com.fractal.domain.resource.FileService;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MilitaryServiceResourceServiceImpl implements MilitaryServiceResourceService {

    private final MilitaryServiceResourceRepository resourceRepository;
    private final MilitaryServiceResourceMapperService resourceMapperService;
    private final MilitaryServiceService militaryServiceService;
    private final FileService fileService;

    @Value("${resource-storage.military-service}")
    private String resourceStoragePath;

    @Override
    @Transactional
    public MilitaryServiceResource create(Long militaryServiceId, MultipartFile file) {
        var militaryService = militaryServiceService.getById(militaryServiceId);
        var resource = resourceMapperService.toEntity(file, resourceStoragePath);
        militaryService.addResource(resource);
        militaryServiceService.save(militaryService);
        return resource;
    }

    @Override
    public List<MilitaryServiceResource> getAllByMilitaryServiceId(Long militaryServiceId) {
        return resourceRepository.findAllByMilitaryServiceId(militaryServiceId);
    }

    @Override
    public MilitaryServiceResource getById(Long militaryServiceId, Long id) {
        return resourceRepository.findByMilitaryServiceIdAndId(militaryServiceId, id).orElseThrow(() -> new ResourceNotFoundException("Military Service Resource  with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public MilitaryServiceResource update(Long militaryServiceId, Long id, MultipartFile file) {
        var militaryService = militaryServiceService.getById(militaryServiceId);
        var resource = militaryService.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Military Service Resource  with id: " + id + " not found"));
        resource = resourceMapperService.toEntity(resource, file, resourceStoragePath);
        militaryServiceService.save(militaryService);
        return resource;
    }

    @Override
    public void delete(Long militaryServiceId, Long id) {
        var militaryService = militaryServiceService.getById(militaryServiceId);
        var resource = militaryService.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Military Service Resource  with id: " + id + " not found"));
        fileService.delete(resource.getUrl());
        militaryService.removeResource(resource);
        militaryServiceService.save(militaryService);
    }

    @Override
    public ResourceResponse toDTO(MilitaryServiceResource resource) {
        return resourceMapperService.toDTO(resource);
    }
}
