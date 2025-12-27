package com.fractal.domain.agreement.employment;

import com.fractal.domain.agreement.employment.dto.EmploymentAgreementRequest;
import com.fractal.domain.agreement.employment.dto.EmploymentAgreementResponse;

import java.nio.file.Path;
import java.util.List;

public interface EmploymentAgreementService {
    EmploymentAgreement create(EmploymentAgreementRequest dto);

    List<EmploymentAgreement> getAll();

    EmploymentAgreement getById(Long id);

    EmploymentAgreement update(Long id, EmploymentAgreementRequest dto);

    void delete(Long id);

    EmploymentAgreementResponse toDTO(EmploymentAgreement agreement);

    EmploymentAgreement save(EmploymentAgreement agreement);
    Path print(Long id);
}
