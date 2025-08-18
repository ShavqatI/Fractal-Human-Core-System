package com.fractal.domain.recruitment.candidate.resource.mapper;

import com.fractal.domain.recruitment.candidate.resource.CandidateResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import com.fractal.domain.resource.mapper.ResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class CandidateResourceMapperServiceImpl implements CandidateResourceMapperService {

    private final ResourceMapperService mapperService;

    @Override
    public ResourceResponse toDTO(CandidateResource resource) {
        return mapperService.toDTO(resource);
    }

    @Override
    public CandidateResource toEntity(ResourceRequest dto) {
        return (CandidateResource) mapperService.toEntity(dto);
    }

    @Override
    public CandidateResource toEntity(MultipartFile file, String url) {
        return (CandidateResource) mapperService.toEntity(file,url);
    }

    @Override
    public CandidateResource toEntity(CandidateResource resource, ResourceRequest dto) {
        return (CandidateResource) mapperService.toEntity(resource,dto);
    }

    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return mapperService.fileToRequest(file,url);
    }
}
