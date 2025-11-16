package com.fractal.domain.learning_develpment.learning.session.resource.mapper;

import com.fractal.domain.learning_develpment.learning.session.resource.LearningSessionResource;
import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceRequest;
import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceResponse;
import com.fractal.domain.learning_develpment.learning.session.resource.type.LearningSessionResourceTypeService;
import com.fractal.domain.resource.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class LearningSessionResourceMapperServiceImpl implements LearningSessionResourceMapperService {

    private final LearningSessionResourceTypeService resourceTypeService;
    private final FileService fileService;

    @Override
    public LearningSessionResourceResponse toDTO(LearningSessionResource resource) {
        return new LearningSessionResourceResponse(
                resource.getId(),
                resourceTypeService.toDTO(resource.getLearningSessionResourceType()),
                resource.getUrl(),
                resource.getFileName(),
                resource.getContentType(),
                resource.getSizeInBytes(),
                resource.getCreatedDate()
        );
    }

    @Override
    public LearningSessionResource toEntity(LearningSessionResourceRequest dto, String resourceStoragePath) {
        return mapToEntity(new LearningSessionResource(), dto, resourceStoragePath);
    }


    @Override
    public LearningSessionResource toEntity(LearningSessionResource resource, LearningSessionResourceRequest dto, String resourceStoragePath) {
        return mapToEntity(resource, dto, resourceStoragePath);
    }


    private LearningSessionResource mapToEntity(LearningSessionResource resource, LearningSessionResourceRequest dto, String resourceStoragePath) {
        fileService.delete(resource.getUrl());
        resource.setLearningSessionResourceType(resourceTypeService.getById(dto.resourceTypeId()));
        resource.setFileName(dto.file().getOriginalFilename());
        resource.setContentType(dto.file().getContentType());
        resource.setSizeInBytes(dto.file().getSize());
        resource.setUrl(fileService.save(dto.file(), resourceStoragePath));
        return resource;
    }

}
