package com.fractal.domain.employment.internal.agreement;

import com.fractal.domain.employment.internal.agreement.dto.InternalEmploymentAgreementRequest;
import com.fractal.domain.employment.internal.agreement.dto.InternalEmploymentAgreementResponse;

import java.util.List;

public interface InternalEmploymentAgreementService {
    InternalEmploymentAgreement create(Long employmentId, InternalEmploymentAgreementRequest dto);

    List<InternalEmploymentAgreement> getAllByInternalEmploymentId(Long employmentId);

    InternalEmploymentAgreement getById(Long employmentId, Long id);

    InternalEmploymentAgreement update(Long employmentId, Long id, InternalEmploymentAgreementRequest dto);

    void delete(Long employmentId, Long id);

    InternalEmploymentAgreementResponse toDTO(InternalEmploymentAgreement agreement);

    InternalEmploymentAgreement save(InternalEmploymentAgreement agreement);

    InternalEmploymentAgreement getById(Long id);

}
