package com.fractal.domain.vacation_management.request.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.vacation_management.category.VacationCategoryService;
import com.fractal.domain.vacation_management.dto.VacationResponse;
import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;
import com.fractal.domain.vacation_management.request.medical_info.dto.VacationRequestMedicalInfoRequest;
import com.fractal.domain.vacation_management.request.medical_info.mapper.VacationRequestMedicalInfoMapperService;
import com.fractal.domain.vacation_management.request.responsibility.mapper.VacationRequestResponsibilityMapperService;
import com.fractal.domain.vacation_management.request.state.VacationRequestStateService;
import com.fractal.domain.vacation_management.type.VacationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class VacationRequestMapperServiceImpl implements VacationRequestMapperService {

    private final EmployeeService employeeService;
    private final StatusService statusService;
    private final VacationTypeService vacationTypeService;
    private final VacationRequestStateService stateService;
    private final VacationRequestResponsibilityMapperService responsibilityMapperService;
    private final VacationRequestMedicalInfoMapperService medicalInfoMapperService;

    @Override
    public VacationRequestResponse toDTO(VacationRequest vacationRequest) {
        return new VacationRequestResponse(
                vacationRequest.getId(),
                employeeService.toCompactDTO(vacationRequest.getEmployee()),
                employeeService.toCompactDTO(vacationRequest.getSuccessorEmployee()),
                vacationTypeService.toDTO(vacationRequest.getVacationType()),
                vacationRequest.getStartDate(),
                vacationRequest.getEndDate(),
                vacationRequest.getDays(),
                vacationRequest.getDescription(),
                Optional.ofNullable(vacationRequest.getResponsibilities())
                        .orElse(emptyList())
                        .stream()
                        .map(responsibilityMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(vacationRequest.getMedicalInfos())
                        .orElse(emptyList())
                        .stream()
                        .map(medicalInfoMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(vacationRequest.getStates())
                        .orElse(emptyList())
                        .stream()
                        .map(stateService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(vacationRequest.getStatus()),
                vacationRequest.getCreatedDate()
        );
    }

    @Override
    public VacationRequest toEntity(VacationRequestRequest dto) {
        return mapToEntity(new VacationRequest(),dto);
    }

    @Override
    public VacationRequest toEntity(VacationRequest vacationRequest, VacationRequestRequest dto) {
        return mapToEntity(vacationRequest,dto);
    }

    private VacationRequest mapToEntity(VacationRequest vacationRequest, VacationRequestRequest dto) {
        vacationRequest.setEmployee(employeeService.getById(dto.employeeId()));
        vacationRequest.setSuccessorEmployee(employeeService.getById(dto.successorEmployeeId()));
        vacationRequest.setVacationType(vacationTypeService.getById(dto.vacationTypeId()));
        vacationRequest.setStartDate(dto.startDate());
        vacationRequest.setEndDate(dto.endDate());
        vacationRequest.setDays((int) ChronoUnit.DAYS.between(dto.startDate(), dto.endDate()) + 1);
        vacationRequest.setDescription(dto.description());
        dto.responsibilities().forEach(responsibility -> vacationRequest.addResponsibility(responsibilityMapperService.toEntity(responsibility)));
        dto.medicalInfos().forEach(medicalInfo -> vacationRequest.addMedicalInfo(medicalInfoMapperService.toEntity(medicalInfo)));
        return vacationRequest;
    }
}
