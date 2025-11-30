package com.fractal.domain.employee_management.employment.usecase.hire;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employee_management.employment.usecase.hire.dto.Hire;
import com.fractal.domain.employment.internal.dto.InternalEmploymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmployeeEmploymentUseCaseServiceImpl implements EmployeeEmploymentUseCaseService {
    private final EmployeeEmploymentService employmentService;
    private final StatusService statusService;
    @Override
    public void hire(Long employeeId, Hire dto) {
      employmentService.create(employeeId,
              new InternalEmploymentRequest(
                      dto.getOrganizationId(),
                      dto.getDepartmentId(),
                      dto.getPositionId(),
                      dto.getEmploymentTypeId(),
                      dto.getStartDate(),
                      dto.getEndDate(),
                      List.of(),
                      List.of(),
                      dto.getCompensationComponents(),
                      statusService.getByCode("CREATED").getId()
               )
      );
    }
}
