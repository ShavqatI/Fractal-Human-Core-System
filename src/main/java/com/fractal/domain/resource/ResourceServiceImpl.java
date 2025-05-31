package com.fractal.domain.resource;

import com.fractal.domain.employee_management.employment.agreement.resource.AgreementResource;
import com.fractal.domain.resource.dto.ResourceRequest;
import com.fractal.domain.resource.dto.ResourceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {

    @Override
    public ResourceResponse toDTO(Resource resource) {
        return new ResourceResponse(
                resource.getId(),
                resource.getUrl(),
                resource.getFileName(),
                resource.getContentType(),
                resource.getSizeInBytes(),
                resource.getCreatedDate()
        );
    }

    @Override
    public AgreementResource toEntity(ResourceRequest dto) {
        return AgreementResource.builder()
                .url(dto.url())
                .fileName(dto.fileName())
                .contentType(dto.contentType())
                .sizeInBytes(dto.sizeInBytes())
                .build();
    }

    @Override
    public AgreementResource toEntity(MultipartFile file, String url) {
        return toEntity(new ResourceRequest(url,file.getOriginalFilename(),file.getContentType(),file.getSize()));
    }



    @Override
    public ResourceRequest fileToRequest(MultipartFile file, String url) {
        return new ResourceRequest(url,file.getOriginalFilename(),file.getContentType(),file.getSize());
    }

}
