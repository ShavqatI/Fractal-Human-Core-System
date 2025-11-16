package com.fractal.domain.employee_management.business_trip.type;

import com.fractal.domain.employee_management.business_trip.type.dto.BusinessTripTypeRequest;
import com.fractal.domain.employee_management.business_trip.type.dto.BusinessTripTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessTripTypeServiceImpl implements BusinessTripTypeService {

    private final BusinessTripTypeRepository businessTripTypeRepository;

    @Override
    public BusinessTripType create(BusinessTripTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<BusinessTripType> getAll() {
        return businessTripTypeRepository.findAll();
    }

    @Override
    public BusinessTripType getByCode(String code) {
        return businessTripTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Vacation Type with code: " + code + " not found"));

    }

    @Override
    public BusinessTripType getById(Long id) {
        return findById(id);
    }

    @Override
    public BusinessTripType update(Long id, BusinessTripTypeRequest dto) {
        try {
            BusinessTripType businessTripType = findById(id);
            businessTripType.setCode(dto.code());
            businessTripType.setName(dto.name());
            businessTripType.setDescription(dto.description());
            return save(businessTripType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        businessTripTypeRepository.delete(findById(id));
    }

    @Override
    public BusinessTripTypeResponse toDTO(BusinessTripType businessTripType) {
        return new BusinessTripTypeResponse(
                businessTripType.getId(),
                businessTripType.getCode(),
                businessTripType.getName(),
                businessTripType.getDescription(),
                businessTripType.getCreatedDate()
        );
    }

    private BusinessTripType toEntity(BusinessTripTypeRequest dto) {
        return BusinessTripType.builder()
                .code(dto.code())
                .name(dto.name())
                .description(dto.description())
                .build();
    }

    private BusinessTripType save(BusinessTripType businessTripType) {
        try {
            return businessTripTypeRepository.save(businessTripType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private BusinessTripType findById(Long id) {
        return businessTripTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vacation Type with id: " + id + " not found"));
    }

}
