package com.fractal.domain.agreement.employment.mapper;

import com.fractal.domain.agreement.employment.EmploymentAgreement;
import com.fractal.domain.agreement.employment.dto.EmploymentAgreementResponse;
import com.fractal.domain.agreement.employment.dto.EmploymentAgreementRequest;

public interface EmploymentAgreementMapperService {
    EmploymentAgreementResponse toDTO(EmploymentAgreement agreement);

    EmploymentAgreement toEntity(EmploymentAgreementRequest dto);

    EmploymentAgreement toEntity(EmploymentAgreement agreement, EmploymentAgreementRequest dto);
}


