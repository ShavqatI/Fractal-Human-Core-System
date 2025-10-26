package com.fractal.domain.agreement.resource;

import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AgreementResourceService {

    AgreementResource create(Long agreementId, MultipartFile file);
    List<AgreementResource> getAllByAgreementId(Long agreementId);
    AgreementResource getById(Long agreementId , Long id);
    AgreementResource update(Long agreementId, Long id, MultipartFile file);
    void delete(Long agreementId,Long id);
    ResourceResponse toDTO(AgreementResource resource);
}
