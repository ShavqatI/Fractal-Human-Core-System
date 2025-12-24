package com.fractal.domain.profile.business_trip;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.employee_management.business_trip.BusinessTripService;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripRequest;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
@RequiredArgsConstructor
class ProfileBusinessTripServiceImpl implements ProfileBusinessTripService {

    private final BusinessTripService businessTripService;
    private final AuthenticatedService authenticatedService;

    @Override
    public BusinessTrip create(ProfileBusinessTripRequest dto) {
       return businessTripService.create(mapDTO(dto));
    }

    @Override
    public List<BusinessTrip> getAll() {
        return businessTripService.getAllByEmployeeId(authenticatedService.getEmployeeId());
    }
    @Override
    public BusinessTrip getById(Long id) {
        return findById(id);
    }
    @Override
    public BusinessTrip update(Long id, ProfileBusinessTripRequest dto) {
        return businessTripService.update(id,mapDTO(dto));
    }

    @Override
    public void deleteById(Long id) {
        businessTripService.deleteById(findById(id).getId());
    }

    @Override
    public void close(Long id) {
        businessTripService.close(findById(id).getId());
    }

    public BusinessTripResponse toDTO(BusinessTrip businessTrip) {
        return businessTripService.toDTO(businessTrip);
    }

    private BusinessTrip findById(Long id){
        return getAll().stream().filter(s-> s.getEmployee().getId().equals(authenticatedService.getEmployeeId()) && s.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public BusinessTrip review(Long id) {
        return businessTripService.review(findById(id).getId());
    }

    @Override
    public Path passport(Long id) {
        var businessTrip = findById(id);
        return businessTripService.passport(businessTrip.getId());
    }

    private BusinessTripRequest mapDTO(ProfileBusinessTripRequest dto) {
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
