package com.fractal.domain.profile.subordinate.business_trip;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.employee_management.business_trip.BusinessTripService;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripRequest;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;
import com.fractal.domain.employee_management.subordinate.SubordinateService;
import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class SubordinateBusinessTripServiceImpl implements SubordinateBusinessTripService {

    private final BusinessTripService businessTripService;
    private final AuthenticatedService authenticatedService;
    private final SubordinateService subordinateService;

    @Override
    public BusinessTrip create(SubordinateBusinessTripRequest dto) {
       return businessTripService.create(mapDTO(dto));
    }

    @Override
    public List<BusinessTrip> getAll() {
        var subordinates = subordinateService.getActiveEmployees(authenticatedService.getEmployeeId());
        List<BusinessTrip> businessTrips = new ArrayList<>();
        subordinates.forEach(employee -> businessTrips.addAll(
                businessTripService.getAllByEmployeeId(employee.getId())
                        .stream()
                        .sorted(Comparator.comparing(BusinessTrip::getId).reversed())
                        .collect(Collectors.toList())
        ));
        return businessTrips;
    }
    @Override
    public BusinessTrip getById(Long id) {
        return findById(id);
    }
    @Override
    public BusinessTrip update(Long id, SubordinateBusinessTripRequest dto) {
        return businessTripService.update(findById(id).getId(),mapDTO(dto));
    }

    @Override
    public void deleteById(Long id) {
        businessTripService.deleteById(findById(id).getId());
    }

    @Override
    public void close(Long id) {
        var businessTrip = findById(id);
        businessTripService.close(businessTrip.getId());

    }

    public BusinessTripResponse toDTO(BusinessTrip businessTrip) {
        return businessTripService.toDTO(businessTrip);
    }

    private BusinessTrip findById(Long id) {
        try {
            var businessTrip = businessTripService.getById(id);
            var subordinate = subordinateService.getActiveEmployee(authenticatedService.getEmployeeId(),businessTrip.getEmployee().getId());
            if(subordinate != null) return businessTrip;
            else return null;
        }
        catch (ResourceNotFoundException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public BusinessTrip review(Long id) {
        var businessTrip = findById(id);
        return businessTripService.review(businessTrip.getId());
    }

    @Override
    public BusinessTrip approve(Long id) {
        var businessTrip = findById(id);
        return businessTripService.approve(businessTrip.getId());
    }

    @Override
    public Path passport(Long id) {
        var businessTrip = findById(id);
        return businessTripService.passport(businessTrip.getId());
    }

    private BusinessTripRequest mapDTO(SubordinateBusinessTripRequest dto) {
        return new BusinessTripRequest(
                authenticatedService.getEmployeeId(),
                dto.businessTripTypeId(),
                dto.businessTripPurposeId(),
                dto.description(),
                dto.startDate(),
                dto.endDate(),
                dto.expenses(),
                dto.locations(),
                dto.files()
        );
    }
}
