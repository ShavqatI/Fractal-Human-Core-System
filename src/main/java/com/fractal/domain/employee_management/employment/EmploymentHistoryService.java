package com.fractal.domain.employee_management.employment;

import com.fractal.domain.employee_management.employment.agreement.dto.AgreementRequest;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryResponse;

public interface EmploymentHistoryService {
    EmploymentHistory create(EmploymentHistoryRequest dto);
    EmploymentHistoryResponse toDTO(EmploymentHistory employmentHistory);
    EmploymentHistory toEntity(EmploymentHistoryRequest dto);
    EmploymentHistory update(Long id,EmploymentHistoryRequest dto);
    void delete(EmploymentHistory employmentHistory);
    EmploymentHistory addAgreement(Long id, AgreementRequest agreementRequest);
    EmploymentHistory updateAgreement(Long id, Long agreementId, AgreementRequest agreementRequest);
    EmploymentHistory deleteAgreement(Long id, Long agreementId);
}
