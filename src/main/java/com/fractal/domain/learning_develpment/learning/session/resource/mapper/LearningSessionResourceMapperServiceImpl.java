package com.fractal.domain.learning_develpment.learning.session.resource.mapper;

import com.fractal.domain.learning_develpment.learning.session.resource.LearningSessionResource;
import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceRequest;
import com.fractal.domain.learning_develpment.learning.session.resource.dto.LearningSessionResourceResponse;
import com.fractal.domain.learning_develpment.learning.session.resource.type.LearningSessionResourceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class LearningSessionResourceMapperServiceImpl implements LearningSessionResourceMapperService {

    private final LearningSessionResourceTypeService resourceTypeService;
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
    public LearningSessionResource toEntity(LearningSessionResourceRequest dto, String url) {
        return mapToEntity(new LearningSessionResource(),dto,url);
    }



    @Override
    public LearningSessionResource toEntity(LearningSessionResource resource, LearningSessionResourceRequest dto, String url) {
        return mapToEntity(resource,dto,url);
    }



    private LearningSessionResource mapToEntity(LearningSessionResource resource, LearningSessionResourceRequest dto, String url) {
        resource.setLearningSessionResourceType(resource.getLearningSessionResourceType());
        resource.setUrl(url);
        resource.setFileName(dto.file().getOriginalFilename());
        resource.setContentType(dto.file().getContentType());
        resource.setSizeInBytes(dto.file().getSize());
        return resource;
    }

}
