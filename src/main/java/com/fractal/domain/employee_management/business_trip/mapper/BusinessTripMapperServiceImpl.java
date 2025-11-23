package com.fractal.domain.employee_management.business_trip.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripRequest;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;
import com.fractal.domain.employee_management.business_trip.expense.mapper.BusinessTripExpenseMapperService;
import com.fractal.domain.employee_management.business_trip.location.mapper.BusinessTripLocationMapperService;
import com.fractal.domain.employee_management.business_trip.resource.mapper.BusinessTripResourceMapperService;
import com.fractal.domain.employee_management.business_trip.type.BusinessTripTypeService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class BusinessTripMapperServiceImpl implements BusinessTripMapperService {

    private final EmployeeService employeeService;
    private final StatusService statusService;
    private final BusinessTripTypeService businessTripTypeService;
    private final BusinessTripResourceMapperService resourceMapperService;
    private final BusinessTripExpenseMapperService expenseMapperService;
    private final BusinessTripLocationMapperService locationMapperService;


    @Override
    public BusinessTripResponse toDTO(BusinessTrip businessTrip) {
        return new BusinessTripResponse(
                businessTrip.getId(),
                employeeService.toCompactDTO(businessTrip.getEmployee()),
                businessTripTypeService.toDTO(businessTrip.getBusinessTripType()),
                statusService.toCompactDTO(businessTrip.getStatus()),
                businessTrip.getPurpose(),
                businessTrip.getDescription(),
                businessTrip.getStartDate(),
                businessTrip.getEndDate(),
                businessTrip.getDays(),
                Optional.ofNullable(businessTrip.getExpenses())
                        .orElse(emptyList())
                        .stream()
                        .map(expenseMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(businessTrip.getLocations())
                        .orElse(emptyList())
                        .stream()
                        .map(locationMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(businessTrip.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(resourceMapperService::toDTO)
                        .collect(Collectors.toList()),
                businessTrip.getCreatedDate()
        );
    }

    @Override
    public BusinessTrip toEntity(BusinessTripRequest dto) {
       var businessTrip = mapToEntity(new BusinessTrip(), dto);
        businessTrip.setStatus(statusService.getByCode("CREATED"));
        return businessTrip;
    }

    @Override
    public BusinessTrip toEntity(BusinessTrip businessTrip, BusinessTripRequest dto) {
        return mapToEntity(businessTrip, dto);
    }

    private BusinessTrip mapToEntity(BusinessTrip businessTrip, BusinessTripRequest dto) {
        businessTrip.setEmployee(employeeService.getById(dto.employeeId()));
        businessTrip.setBusinessTripType(businessTripTypeService.getById(dto.businessTripTypeId()));
        businessTrip.setPurpose(dto.purpose());
        businessTrip.setDescription(dto.description());
        businessTrip.setStartDate(dto.startDate());
        businessTrip.setEndDate(dto.endDate());
        businessTrip.setDays((int) ChronoUnit.DAYS.between(dto.startDate(), dto.endDate()) + 1);
        dto.expenses().forEach(expense -> businessTrip.addExpense(expenseMapperService.toEntity(expense)));
        dto.locations().forEach(location -> businessTrip.addLocation(locationMapperService.toEntity(location)));
        dto.files().forEach(file -> businessTrip.addResource(resourceMapperService.toEntity(file, null)));
        return businessTrip;
    }
}
