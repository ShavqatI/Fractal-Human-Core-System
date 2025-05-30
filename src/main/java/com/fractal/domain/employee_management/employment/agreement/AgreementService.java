package com.fractal.domain.employee_management.employment.agreement;

import com.fractal.domain.employee_management.employment.agreement.dto.AgreementRequest;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementResponse;

public interface AgreementService {
    AgreementResponse toDTO(Agreement agreement);
    Agreement toEntity(AgreementRequest dto);
}
