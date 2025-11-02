package com.fractal.domain.recruitment.candidate.resource.mapper;

import com.fractal.domain.recruitment.candidate.resource.CandidateResource;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceRequest;
import com.fractal.domain.recruitment.candidate.resource.dto.CandidateResourceResponse;
import com.fractal.domain.recruitment.candidate.resource.type.CandidateResourceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateResourceMapperServiceImpl implements CandidateResourceMapperService {

    private final CandidateResourceTypeService resourceTypeService;
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
    public CandidateResource toEntity(CandidateResourceRequest dto,String url) {
        return mapToEntity(new CandidateResource(),dto,url);
    }
    @Override
    public CandidateResource toEntity(CandidateResource resource, CandidateResourceRequest dto,String url) {
        return mapToEntity(resource,dto,url);
    }
    private CandidateResource mapToEntity(CandidateResource resource, CandidateResourceRequest dto,String url) {
        resource.setCandidateResourceType(resource.getCandidateResourceType());
        resource.setUrl(url);
        resource.setFileName(dto.file().getOriginalFilename());
        resource.setContentType(dto.file().getContentType());
        resource.setSizeInBytes(dto.file().getSize());

        return resource;
    }

}
