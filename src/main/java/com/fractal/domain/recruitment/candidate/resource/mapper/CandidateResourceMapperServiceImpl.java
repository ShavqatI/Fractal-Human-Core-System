package com.fractal.domain.recruitment.candidate.resource.mapper;

import com.fractal.domain.recruitment.candidate.resource.CandidateResource;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceRequest;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceResponse;
import com.fractal.domain.recruitment.candidate.resource.type.CandidateResourceTypeService;
import com.fractal.domain.resource.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateResourceMapperServiceImpl implements CandidateResourceMapperService {

    private final CandidateResourceTypeService resourceTypeService;
    private final FileService fileService;

    @Override
    public CandidateResourceResponse toDTO(CandidateResource resource) {
        return new CandidateResourceResponse(
                resource.getId(),
                resourceTypeService.toDTO(resource.getCandidateResourceType()),
                resource.getUrl(),
                resource.getFileName(),
                resource.getContentType(),
                resource.getSizeInBytes(),
                resource.getCreatedDate()
        );
    }

    @Override
    public CandidateResource toEntity(CandidateResourceRequest dto,String resourceStoragePath) {
        return mapToEntity(new CandidateResource(),dto, resourceStoragePath);
    }
    @Override
    public CandidateResource toEntity(CandidateResource resource, CandidateResourceRequest dto,String resourceStoragePath) {
        return mapToEntity(resource,dto, resourceStoragePath);
    }
    private CandidateResource mapToEntity(CandidateResource resource, CandidateResourceRequest dto,String resourceStoragePath) {
        fileService.delete(resource.getUrl());
        resource.setCandidateResourceType(resourceTypeService.getById(dto.candidateResourceTypeId()));
        resource.setFileName(dto.file().getOriginalFilename());
        resource.setContentType(dto.file().getContentType());
        resource.setSizeInBytes(dto.file().getSize());
        resource.setUrl(fileService.save(dto.file(), resourceStoragePath));
        return resource;
    }

}
