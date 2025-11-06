package com.fractal.domain.education.resource;

import com.fractal.domain.education.EducationService;
import com.fractal.domain.education.resource.mapper.EducationResourceMapperService;
import com.fractal.domain.resource.FileService;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationResourceServiceImpl implements EducationResourceService {

    private final EducationResourceRepository resourceRepository;
    private final EducationResourceMapperService resourceMapperService;
    private final EducationService educationService;
    private final FileService fileService;

    @Value("${resource-storage.education}")
    private String resourceStoragePath;

    @Override
    public EducationResource create(Long educationId, MultipartFile file) {
        var education = educationService.getById(educationId);
        var resource =  resourceMapperService.toEntity(file,resourceStoragePath);
        education.addResource(resource);
        educationService.save(education);
        return resource;
    }

    @Override
    public List<EducationResource> getAllByEducationId(Long educationId) {
        return resourceRepository.findAllByEducationId(educationId);
    }

    @Override
    public EducationResource getById(Long educationId, Long id) {
        return resourceRepository.findByEducationIdAndId(educationId,id).orElseThrow(()-> new ResourceNotFoundException("Education Resource  with id: " + id + " not found"));
    }

    @Override
    public EducationResource update(Long educationId, Long id, MultipartFile file) {
        var education = educationService.getById(educationId);
        var resource = education.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education Resource  with id: " + id + " not found"));
        resource = resourceMapperService.toEntity(resource,file,resourceStoragePath);
        resourceRepository.save(resource);
        educationService.save(education);
        return resource;
    }

    @Override
    public void delete(Long educationId, Long id) {
        var education = educationService.getById(educationId);
        var resource = education.getResources()
                .stream()
                .filter(r -> r.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education Resource  with id: " + id + " not found"));
        fileService.delete(resource.getUrl());
        education.removeResource(resource);
        educationService.save(education);
    }

    @Override
    public ResourceResponse toDTO(EducationResource resource) {
        return resourceMapperService.toDTO(resource);
    }
}
