package com.fractal.domain.employment.internal.agreement.mapper;

import com.fractal.domain.employment.internal.agreement.InternalEmploymentAgreement;
import com.fractal.domain.employment.internal.agreement.dto.InternalEmploymentAgreementRequest;
import com.fractal.domain.employment.internal.agreement.dto.InternalEmploymentAgreementResponse;

public interface InternalEmploymentAgreementMapperService {
    InternalEmploymentAgreementResponse toDTO(InternalEmploymentAgreement agreement);

    InternalEmploymentAgreement toEntity(InternalEmploymentAgreementRequest dto);

    InternalEmploymentAgreement toEntity(InternalEmploymentAgreement agreement, InternalEmploymentAgreementRequest dto);
}


