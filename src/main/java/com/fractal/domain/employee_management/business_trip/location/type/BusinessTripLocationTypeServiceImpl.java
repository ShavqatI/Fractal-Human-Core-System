package com.fractal.domain.employee_management.business_trip.location.type;

import com.fractal.domain.employee_management.business_trip.location.type.dto.BusinessTripLocationTypeRequest;
import com.fractal.domain.employee_management.business_trip.location.type.dto.BusinessTripLocationTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class BusinessTripLocationTypeServiceImpl implements BusinessTripLocationTypeService {

    private final BusinessTripLocationTypeRepository businessTripLocationTypeRepository;

    @Override
    public BusinessTripLocationType create(BusinessTripLocationTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public BusinessTripLocationType update(Long id, BusinessTripLocationTypeRequest dto) {
        try {
            BusinessTripLocationType businessTripLocationType = findById(id);
            businessTripLocationType.setCode(dto.code());
            businessTripLocationType.setName(dto.name());
            return save(businessTripLocationType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    @Override
    public List<BusinessTripLocationType> getAll() {
        return businessTripLocationTypeRepository.findAll();
    }

    @Override
    public BusinessTripLocationType getByCode(String code) {
        return businessTripLocationTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Address Type with code: " + code + " not found"));
    }

    @Override
    public BusinessTripLocationType getById(Long id) {
        return findById(id);
    }

    @Override
    public void deleteById(Long id) {
        businessTripLocationTypeRepository.delete(findById(id));
    }

    @Override
    public BusinessTripLocationTypeResponse toDTO(BusinessTripLocationType businessTripLocationType) {
        return new BusinessTripLocationTypeResponse(
                businessTripLocationType.getId(),
                businessTripLocationType.getCode(),
                businessTripLocationType.getName(),
                businessTripLocationType.getCreatedDate()
        );
    }

    private BusinessTripLocationType toEntity(BusinessTripLocationTypeRequest dto) {
        return BusinessTripLocationType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private BusinessTripLocationType save(BusinessTripLocationType businessTripLocationType) {
        try {
            return businessTripLocationTypeRepository.save(businessTripLocationType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private BusinessTripLocationType findById(Long id) {
        return businessTripLocationTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address Type with id: " + id + " not found"));
    }

}
