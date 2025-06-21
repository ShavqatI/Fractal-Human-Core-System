package com.fractal.domain.employee_management.education.resource;

import com.fractal.domain.employee_management.education.EducationService;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationResourceServiceImpl implements EducationResourceService {

    private final EducationResourceRepository resourceRepository;
    private final ResourceMapperService resourceMapperService;
    private final EducationService educationService;

    @Override
    public EducationResource create(Long educationId, MultipartFile file) {
        var education = educationService.getById(educationId);
        var resource = (EducationResource) resourceMapperService.toEntity(file,null);
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
        resource = (EducationResource) resourceMapperService.toEntity(resource,resourceMapperService.fileToRequest(file,null));
        resourceRepository.save(resource);
        educationService.save(education);
        return resource;
    }

    @Override
    public void delete(Long educationId, Long id) {
        var education = educationService.getById(educationId);
        var resource = education.getResources()
                .stream()
                .filter(r -> r.getId().equals(educationId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education Resource  with id: " + id + " not found"));
        education.removeResource(resource);
        resourceRepository.delete(resource);
        educationService.save(education);
    }

    @Override
    public ResourceResponse toDTO(EducationResource resource) {
        return resourceMapperService.toDTO(resource);
    }
}
