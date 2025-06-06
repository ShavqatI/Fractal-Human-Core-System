package com.fractal.domain.employee_management.employment.agreement;

import com.fractal.domain.employee_management.employment.agreement.dto.AgreementRequest;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementResponse;
import org.springframework.web.multipart.MultipartFile;

public interface AgreementService {
    AgreementResponse toDTO(Agreement agreement);
    Agreement toEntity(AgreementRequest dto);
    Agreement update(Long id,AgreementRequest dto);
    void delete(Agreement agreement);
    Agreement addResource(Long id,MultipartFile file, String url);
    Agreement updateResource(Long id, Long resourceId, MultipartFile file);
    Agreement deleteResource(Long id, Long resourceId);

}
