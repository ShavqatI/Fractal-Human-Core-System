package com.fractal.domain.profile.subordinate.vacation.request;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.subordinate.SubordinateService;
import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.domain.vacation_management.request.VacationRequestService;
import com.fractal.domain.vacation_management.request.dto.VacationRequestRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class SubordinateVacationRequestServiceImpl implements SubordinateVacationRequestService {

    private final VacationRequestService vacationRequestService;
    private final AuthenticatedService authenticatedService;
    private final SubordinateService subordinateService;
    @Override
    public List<VacationRequest> getAll() {
        var subordinates = subordinateService.getActiveEmployees(authenticatedService.getEmployeeId());
        List<VacationRequest> vacationRequests = new ArrayList<>();
        subordinates.forEach(employee -> vacationRequests.addAll(
                vacationRequestService.getAllByEmployeeId(employee.getId())
                        .stream()
                        .sorted(Comparator.comparing(VacationRequest::getId).reversed())
                        .collect(Collectors.toList())
        ));
       return vacationRequests;
    }

    @Override
    public VacationRequest getById(Long id) {
        return findById(id);
    }

    @Override
    public VacationRequest update(Long id, SubordinateVacationRequestRequest dto) {
        var vacationRequest = findById(id);
        return vacationRequestService.update(vacationRequest.getId(),mapDTO(dto));
    }
    public VacationRequestResponse toDTO(VacationRequest vacationRequest) {
        return vacationRequestService.toDTO(vacationRequest);
    }

    private VacationRequest findById(Long id) {
       try {
           var vacationRequest = vacationRequestService.getById(id);
           var subordinate = subordinateService.getActiveEmployee(authenticatedService.getEmployeeId(),vacationRequest.getEmployee().getId());
           if(subordinate != null) return vacationRequest;
           else return null;
       }
       catch (ResourceNotFoundException e){
           throw new RuntimeException(e.getMessage());
       }
    }

    @Override
    public VacationRequest approve(Long id) {
        var vacationRequest = findById(id);
        return vacationRequestService.review(vacationRequest.getId());
    }

    private VacationRequestRequest mapDTO(SubordinateVacationRequestRequest dto) {
        return new VacationRequestRequest(
                authenticatedService.getEmployeeId(),
                dto.successorEmployeeId(),
                dto.vacationTypeId(),
                dto.startDate(),
                dto.startDate().plusDays(dto.days() - 1),
                dto.responsibilities(),
                dto.medicalInfos(),
                dto.educations(),
                dto.description()
        );
    }
}
