package com.fractal.domain.employee_management.employment.agreement;

import com.fractal.domain.employee_management.employment.agreement.dto.AgreementRequest;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementResponse;

import java.util.List;

public interface AgreementService {
    Agreement create(Long employmentHistoryId, AgreementRequest dto);
    List<Agreement> getAllByEmploymentHistoryId(Long employmentHistoryId);
    Agreement getById(Long employmentHistoryId ,Long id);
    Agreement update(Long employmentHistoryId,Long id, AgreementRequest dto);
    void delete(Long employmentHistoryId,Long id);
    AgreementResponse toDTO(Agreement agreement);
    Agreement save(Agreement agreement);
    Agreement getById(Long id);

}
