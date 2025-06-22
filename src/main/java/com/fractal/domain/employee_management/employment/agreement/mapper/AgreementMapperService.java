package com.fractal.domain.employee_management.employment.agreement.mapper;

import com.fractal.domain.employee_management.employment.agreement.Agreement;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementRequest;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementResponse;

public interface AgreementMapperService {
    AgreementResponse toDTO(Agreement agreement);
    Agreement toEntity(AgreementRequest dto);
    Agreement toEntity(Agreement agreement, AgreementRequest dto);
}


