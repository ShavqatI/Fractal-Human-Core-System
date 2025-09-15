package com.fractal.domain.employee_management.business_trip.expense.type;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.business_trip.expense.type.dto.BusinessTripExpenseTypeRequest;
import com.fractal.domain.employee_management.business_trip.expense.type.dto.BusinessTripExpenseTypeCompactResponse;
import com.fractal.domain.employee_management.business_trip.expense.type.dto.BusinessTripExpenseTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;


@Service
@RequiredArgsConstructor
class BusinessTripExpenseTypeServiceImpl implements BusinessTripExpenseTypeService {

    private final BusinessTripExpenseTypeRepository businessTripExpenseTypeRepository;
    private final StatusService statusService;


    @Override
    public BusinessTripExpenseType create(BusinessTripExpenseTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<BusinessTripExpenseType> getAll() {
        return businessTripExpenseTypeRepository.findAll();
    }

    @Override
    public BusinessTripExpenseType getByCode(String code) {
        return businessTripExpenseTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Separation Reason with code: " + code + " not found"));
    }

    @Override
    public BusinessTripExpenseType getById(Long id) {
        return findById(id);
    }

    @Override
    public BusinessTripExpenseType update(Long id, BusinessTripExpenseTypeRequest dto) {
        try {
            BusinessTripExpenseType businessTripExpenseType = findById(id);
            businessTripExpenseType.setCode(dto.code());
            businessTripExpenseType.setName(dto.name());
            dto.children().forEach(businessTripExpenseTypeRequest -> businessTripExpenseType.addChild(toEntity(businessTripExpenseTypeRequest)));
            return save(businessTripExpenseType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      businessTripExpenseTypeRepository.delete(findById(id));
    }

    @Override
    public BusinessTripExpenseTypeResponse toDTO(BusinessTripExpenseType businessTripExpenseType) {
        return new BusinessTripExpenseTypeResponse(
                businessTripExpenseType.getId(),
                businessTripExpenseType.getCode(),
                businessTripExpenseType.getName(),
                Optional.ofNullable(businessTripExpenseType.getParent())
                        .map(BusinessTripExpenseType::getName)
                        .orElse(null),
                Optional.ofNullable(businessTripExpenseType.getChildren())
                        .orElse(emptyList())
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList()),
                 statusService.toCompactDTO(businessTripExpenseType.getStatus()),
                businessTripExpenseType.getCreatedDate()
        );
    }

   @Override
    public BusinessTripExpenseTypeCompactResponse toCompactDTO(BusinessTripExpenseType businessTripExpenseType) {
        return new BusinessTripExpenseTypeCompactResponse(
                businessTripExpenseType.getId(),
                businessTripExpenseType.getCode(),
                businessTripExpenseType.getName()
        );
    }

    private BusinessTripExpenseType toEntity(BusinessTripExpenseTypeRequest dto) {
        var separationReason = BusinessTripExpenseType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
        dto.children().forEach(businessTripExpenseTypeRequest -> separationReason.addChild(toEntity(businessTripExpenseTypeRequest)));
    return separationReason;
    }

    private BusinessTripExpenseType save(BusinessTripExpenseType businessTripExpenseType) {
        try {
            return businessTripExpenseTypeRepository.save(businessTripExpenseType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private BusinessTripExpenseType findById(Long id) {
        return businessTripExpenseTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Separation Reason with id: " + id + " not found"));
    }
}
