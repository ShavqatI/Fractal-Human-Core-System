package com.fractal.domain.employee_management.business_trip.purpose;

import com.fractal.domain.employee_management.business_trip.purpose.dto.BusinessTripPurposeRequest;
import com.fractal.domain.employee_management.business_trip.purpose.dto.BusinessTripPurposeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessTripPurposeServiceImpl implements BusinessTripPurposeService {

    private final BusinessTripPurposeRepository businessTripPurposeRepository;

    @Override
    public BusinessTripPurpose create(BusinessTripPurposeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<BusinessTripPurpose> getAll() {
        return businessTripPurposeRepository.findAll();
    }

    @Override
    public BusinessTripPurpose getByCode(String code) {
        return businessTripPurposeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Vacation Type with code: " + code + " not found"));

    }

    @Override
    public BusinessTripPurpose getById(Long id) {
        return findById(id);
    }

    @Override
    public BusinessTripPurpose update(Long id, BusinessTripPurposeRequest dto) {
        try {
            BusinessTripPurpose businessTripPurpose = findById(id);
            businessTripPurpose.setCode(dto.code());
            businessTripPurpose.setName(dto.name());
            return save(businessTripPurpose);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        businessTripPurposeRepository.delete(findById(id));
    }

    @Override
    public BusinessTripPurposeResponse toDTO(BusinessTripPurpose businessTripPurpose) {
        return new BusinessTripPurposeResponse(
                businessTripPurpose.getId(),
                businessTripPurpose.getCode(),
                businessTripPurpose.getName(),
                businessTripPurpose.getCreatedDate()
        );
    }

    private BusinessTripPurpose toEntity(BusinessTripPurposeRequest dto) {
        return BusinessTripPurpose.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private BusinessTripPurpose save(BusinessTripPurpose businessTripPurpose) {
        try {
            return businessTripPurposeRepository.save(businessTripPurpose);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private BusinessTripPurpose findById(Long id) {
        return businessTripPurposeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vacation Type with id: " + id + " not found"));
    }

}
