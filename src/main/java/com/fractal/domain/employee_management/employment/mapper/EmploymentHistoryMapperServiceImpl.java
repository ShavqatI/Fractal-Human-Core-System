package com.fractal.domain.employee_management.employment.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employment.EmploymentHistory;
import com.fractal.domain.employee_management.employment.agreement.mapper.AgreementMapperService;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryResponse;
import com.fractal.domain.employee_management.employment.order.mapper.EmploymentHistoryOrderMapperService;
import com.fractal.domain.employment.type.EmploymentTypeService;
import com.fractal.domain.organization_management.department.DepartmentService;
import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.organization_management.position.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class EmploymentHistoryMapperServiceImpl implements EmploymentHistoryMapperService {

    private final AgreementMapperService agreementMapperService;
    private final OrganizationService organizationService;
    private final DepartmentService departmentService;
    private final PositionService positionService;
    private final EmploymentTypeService employmentTypeService;
    private final StatusService statusService;
    private final EmploymentHistoryOrderMapperService orderMapperService;

    @Override
    public EmploymentHistoryResponse toDTO(EmploymentHistory employmentHistory) {
        return new EmploymentHistoryResponse(
                employmentHistory.getId(),
                employmentHistory.getSerial(),
                employmentHistory.getStartDate(),
                employmentHistory.getEndDate(),
                employmentHistory.getOrganization().getName(),
                employmentHistory.getDepartment().getName(),
                employmentHistory.getPosition().getName(),
                employmentHistory.getEmploymentType().getName(),
                employmentHistory.getStatus().getName(),
                Optional.ofNullable(employmentHistory.getAgreements())
                        .orElse(emptyList())
                        .stream()
                        .map(agreementMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(employmentHistory.getOrders())
                        .orElse(emptyList())
                        .stream()
                        .map(orderMapperService::toDTO)
                        .collect(Collectors.toList()),
                employmentHistory.getCreatedDate(),
                employmentHistory.getUpdatedDate()
        );
    }

    @Override
    public EmploymentHistory toEntity(EmploymentHistoryRequest dto) {
        return mapToEntity(new EmploymentHistory(),dto);
    }

    @Override
    public EmploymentHistory toEntity(EmploymentHistory employmentHistory, EmploymentHistoryRequest dto) {
        return mapToEntity(employmentHistory,dto);
    }

    private EmploymentHistory mapToEntity(EmploymentHistory employmentHistory, EmploymentHistoryRequest dto) {
        employmentHistory.setSerial(null);
        employmentHistory.setStartDate(dto.startDate());
        employmentHistory.setEndDate(dto.endDate());
        employmentHistory.setOrganization(organizationService.getById(dto.organizationId()));
        employmentHistory.setDepartment(departmentService.getById(dto.departmentId()));
        employmentHistory.setPosition(positionService.getById(dto.positionId()));
        employmentHistory.setEmploymentType(employmentTypeService.getById(dto.employmentTypeId()));
        employmentHistory.setStatus(statusService.getById(dto.statusId()));
        dto.agreements().forEach(agreementRequest -> employmentHistory.addAgreement(agreementMapperService.toEntity(agreementRequest)));
        dto.orders().forEach(orderRequest -> employmentHistory.addOrder(orderMapperService.toEntity(orderRequest)));
        return employmentHistory;
    }

}
