package com.fractal.domain.employee_management.employment.agreement;

import com.fractal.domain.employee_management.employment.agreement.dto.AgreementRequest;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementResponse;
import com.fractal.domain.employee_management.employment.agreement.resource.AgreementResource;
import org.springframework.web.multipart.MultipartFile;

public interface AgreementService {
    AgreementResponse toDTO(Agreement agreement);
    Agreement toEntity(AgreementRequest dto);
    Agreement addResource(Long id,MultipartFile file, String url);
    Agreement deleteResource(Long id, Long resourceId);
}
