package com.fractal.domain.employee_management.employment;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employment.agreement.Agreement;
import com.fractal.domain.employee_management.employment.agreement.AgreementService;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementRequest;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryRequest;
import com.fractal.domain.employee_management.employment.dto.EmploymentHistoryResponse;
import com.fractal.domain.employee_management.employment.type.EmploymentTypeService;
import com.fractal.domain.organization_management.department.DepartmentService;
import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.organization_management.position.PositionService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class EmploymentHistoryServiceImpl implements EmploymentHistoryService {

    private final EmploymentHistoryRepository employmentHistoryRepository;
    private final AgreementService agreementService;
    private final OrganizationService organizationService;
    private final DepartmentService departmentService;
    private final PositionService positionService;
    private final EmploymentTypeService employmentTypeService;
    private final StatusService statusService;

    @Override
    public EmploymentHistoryResponse toDTO(EmploymentHistory employmentHistory) {
        return new EmploymentHistoryResponse(
                employmentHistory.getId(),
                employmentHistory.getOrderNumber(),
                employmentHistory.getOrderDate(),
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
                        .map(agreementService::toDTO)
                        .collect(Collectors.toList()),
                employmentHistory.getCreatedDate(),
                employmentHistory.getUpdatedDate()
        );
    }

    @Override
    public EmploymentHistory toEntity(EmploymentHistoryRequest dto) {
        var employmentHistory = EmploymentHistory.builder()
                .orderNumber(dto.orderNumber())
                .orderDate(dto.orderDate())
                .serial(null)
                .startDate(dto.startDate())
                .endDate(dto.endDate())
                .organization(organizationService.getById(dto.organizationId()))
                .department(departmentService.getById(dto.departmentId()))
                .position(positionService.getById(dto.positionId()))
                .employmentType(employmentTypeService.getById(dto.employmentTypeId()))
                .status(statusService.getById(dto.statusId()))
                .build();
        dto.agreements().forEach(agreementRequest -> employmentHistory.addAgreement(agreementService.toEntity(agreementRequest)));
        return employmentHistory;
    }

    @Override
    public EmploymentHistory addAgreement(Long id, AgreementRequest agreementRequest) {
        var employmentHistory = findById(id);
        employmentHistory.addAgreement(agreementService.toEntity(agreementRequest));
        return save(employmentHistory);
    }

    @Override
    public EmploymentHistory updateAgreement(Long id, Long agreementId, AgreementRequest agreementRequest) {
        var employmentHistory = findById(id);
        var agreement = employmentHistory.getAgreements()
                .stream()
                .filter(a-> a.getId().equals(agreementId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Agreement with id: " + agreementId + " not found"));
        agreementService.update(agreement.getId(),agreementRequest);
        return save(employmentHistory);
    }

    @Override
    public EmploymentHistory deleteAgreement(Long id, Long agreementId) {
        var employmentHistory = findById(id);
        var agreement = employmentHistory.getAgreements()
                .stream()
                .filter(a-> a.getId().equals(agreementId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Agreement with id: " + agreementId + " not found"));
        employmentHistory.removeAgreement(agreement);
        agreementService.delete(agreement);
        return save(employmentHistory);
    }

    private EmploymentHistory save(EmploymentHistory employmentHistory) {
        try {
            return employmentHistoryRepository.save(employmentHistory);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    private EmploymentHistory findById(Long id) {
        return employmentHistoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employment History with id: " + id + " not found"));
    }
}
