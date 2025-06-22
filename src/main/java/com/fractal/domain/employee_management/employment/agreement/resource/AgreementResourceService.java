package com.fractal.domain.employee_management.employment.agreement.resource;

import com.fractal.domain.resource.dto.ResourceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AgreementResourceService {

    AgreementResource create(Long agreementId, MultipartFile file);
    List<AgreementResource> getAllByAgreementId(Long agreementId);
    AgreementResource getById(Long agreementId ,Long id);
    AgreementResource update(Long agreementId,Long id, MultipartFile file);
    void delete(Long agreementId,Long id);
    ResourceResponse toDTO(AgreementResource resource);




    /*ResourceResponse toDTO(AgreementResource resource);
    AgreementResource toEntity(ResourceRequest dto);
    AgreementResource toEntity(MultipartFile file, String url);
    AgreementResource update(AgreementResource resource, ResourceRequest dto);
    ResourceRequest fileToRequest(MultipartFile file,String url);
    void delete(AgreementResource resource);
    AgreementResource findById(Long id);*/
}
