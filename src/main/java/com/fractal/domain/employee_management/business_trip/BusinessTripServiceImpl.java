package com.fractal.domain.employee_management.business_trip;

import com.fractal.domain.employee_management.business_trip.dto.BusinessTripRequest;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;
import com.fractal.domain.employee_management.business_trip.mapper.BusinessTripMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class BusinessTripServiceImpl implements BusinessTripService {

    private final BusinessTripRepository businessTripRepository;
    private final BusinessTripMapperService mapperService;


    @Override
    public BusinessTrip create(BusinessTripRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<BusinessTrip> getAll() {
        return businessTripRepository.findAll();
    }

    @Override
    public BusinessTrip getById(Long id) {
        return findById(id);
    }

    @Override
    public List<BusinessTrip> getAllByEmployeeId(Long employeeId) {
        return businessTripRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public BusinessTrip update(Long id, BusinessTripRequest dto) {
        try {
           return save(mapperService.toEntity(findById(id),dto));
       }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        businessTripRepository.delete(findById(id));
    }

    public BusinessTripResponse toDTO(BusinessTrip businessTrip) {
        return mapperService.toDTO(businessTrip);
    }

    @Override
    public BusinessTrip save(BusinessTrip businessTrip) {
        try {
            return businessTripRepository.save(businessTrip);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private BusinessTrip findById(Long id) {
        return businessTripRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("BusinessTrip with id: " + id + " not found"));
    }

}
