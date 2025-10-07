package com.fractal.domain.employment.internal.agreement.resource;

import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface InternalEmploymentAgreementResourceService {

    InternalEmploymentAgreementResource create(Long agreementId, MultipartFile file);
    List<InternalEmploymentAgreementResource> getAllByAgreementId(Long agreementId);
    InternalEmploymentAgreementResource getById(Long agreementId , Long id);
    InternalEmploymentAgreementResource update(Long agreementId, Long id, MultipartFile file);
    void delete(Long agreementId,Long id);
    ResourceResponse toDTO(InternalEmploymentAgreementResource resource);




    /*ResourceResponse toDTO(AgreementResource resource);
    AgreementResource toEntity(ResourceRequest dto);
    AgreementResource toEntity(MultipartFile file, String url);
    AgreementResource update(AgreementResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
    void delete(AgreementResource resource);
    AgreementResource findById(Long id);*/
}
