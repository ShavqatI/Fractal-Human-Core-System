package com.fractal.domain.employee_management.subordinate.type;

import com.fractal.domain.employee_management.subordinate.type.dto.SubordinateTypeRequest;
import com.fractal.domain.employee_management.subordinate.type.dto.SubordinateTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class SubordinateTypeServiceImpl implements SubordinateTypeService {

    private final SubordinateTypeRepository subordinateTypeRepository;

    @Override
    public SubordinateType create(SubordinateTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<SubordinateType> getAll() {
        return subordinateTypeRepository.findAll();
    }

    @Override
    public SubordinateType getByCode(String code) {
        return subordinateTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Employment Type with code: " + code + " not found"));
    }

    @Override
    public SubordinateType getById(Long id) {
        return findById(id);
    }

    @Override
    public SubordinateType update(Long id, SubordinateTypeRequest dto) {
        try {
            SubordinateType subordinateType = findById(id);
            subordinateType.setCode(dto.code());
            subordinateType.setName(dto.name());
            return save(subordinateType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        subordinateTypeRepository.delete(findById(id));
    }

    @Override
    public SubordinateTypeResponse toDTO(SubordinateType subordinateType) {
        return new SubordinateTypeResponse(
                subordinateType.getId(),
                subordinateType.getCode(),
                subordinateType.getName(),
                subordinateType.getCreatedDate()
        );
    }

    private SubordinateType toEntity(SubordinateTypeRequest dto) {
        return SubordinateType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private SubordinateType save(SubordinateType subordinateType) {
        try {
            return subordinateTypeRepository.save(subordinateType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private SubordinateType findById(Long id) {
        return subordinateTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Subordinate type with id: " + id + " not found"));
    }

}
