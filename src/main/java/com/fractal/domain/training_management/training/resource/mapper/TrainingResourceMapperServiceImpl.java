package com.fractal.domain.training_management.training.resource.mapper;

import com.fractal.domain.training_management.training.resource.TrainingResource;
import com.fractal.domain.training_management.training.resource.dto.TrainingResourceRequest;
import com.fractal.domain.training_management.training.resource.dto.TrainingResourceResponse;
import com.fractal.domain.training_management.training.resource.type.TrainingResourceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class TrainingResourceMapperServiceImpl implements TrainingResourceMapperService {

    private final TrainingResourceTypeService resourceTypeService;
    @Override
    public TrainingResourceResponse toDTO(TrainingResource resource) {
        return new TrainingResourceResponse(
                resource.getId(),
                resourceTypeService.toDTO(resource.getTrainingResourceType()),
                resource.getUrl(),
                resource.getFileName(),
                resource.getContentType(),
                resource.getSizeInBytes(),
                resource.getCreatedDate()
        );
    }

    @Override
    public TrainingResource toEntity(TrainingResourceRequest dto, String url) {
        return mapToEntity(new TrainingResource(),dto,url);
    }



    @Override
    public TrainingResource toEntity(TrainingResource resource, TrainingResourceRequest dto, String url) {
        return mapToEntity(resource,dto,url);
    }



    private TrainingResource mapToEntity(TrainingResource resource, TrainingResourceRequest dto, String url) {
        resource.setTrainingResourceType(resource.getTrainingResourceType());
        resource.setUrl(url);
        resource.setFileName(dto.file().getOriginalFilename());
        resource.setContentType(dto.file().getContentType());
        resource.setSizeInBytes(dto.file().getSize());
        return resource;
    }

}
