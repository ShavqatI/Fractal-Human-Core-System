package com.fractal.domain.profile.subordinate.vacation.request;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.subordinate.SubordinateService;
import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.domain.vacation_management.request.VacationRequestService;
import com.fractal.domain.vacation_management.request.dto.VacationRequestCancelRequest;
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
    public VacationRequest create(SubordinateVacationRequestRequest dto) {
        try{
            var employee = subordinateService.getActiveEmployee(authenticatedService.getEmployeeId(), dto.employeeId());
            if(employee != null)
            return vacationRequestService.create(mapDTO(dto));
        }
        catch (Exception e){
           throw new RuntimeException(e.getMessage());
        }
       return null;
    }

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
        try{
            var employee = subordinateService.getActiveEmployee(authenticatedService.getEmployeeId(), dto.employeeId());
            if(employee != null)
                return vacationRequestService.update(findById(id).getId(),mapDTO(dto));
         }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

    @Override
    public VacationRequestResponse toDTO(VacationRequest vacationRequest) {
        return vacationRequestService.toDTO(vacationRequest);
    }

    @Override
    public VacationRequest review(Long id) {
        return vacationRequestService.review(findById(id).getId());
    }
    @Override
    public VacationRequest approve(Long id) {
        var vacationRequest = findById(id);
        return vacationRequestService.approve(vacationRequest.getId());
    }
    @Override
    public VacationRequest cancel(VacationRequestCancelRequest dto) {
        return vacationRequestService.cancel(new VacationRequestCancelRequest(findById(dto.id()).getId(),dto.reason()));
    }

    @Override
    public void deleteById(Long id) {
        vacationRequestService.deleteById(findById(id).getId());
    }

    @Override
    public void close(Long id) {
        vacationRequestService.close(findById(id).getId());
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

    private VacationRequestRequest mapDTO(SubordinateVacationRequestRequest dto) {
        return new VacationRequestRequest(
                dto.employeeId(),
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
