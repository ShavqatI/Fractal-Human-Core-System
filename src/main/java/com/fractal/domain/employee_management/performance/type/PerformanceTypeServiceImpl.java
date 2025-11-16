package com.fractal.domain.employee_management.performance.type;

import com.fractal.domain.employee_management.performance.type.dto.PerformanceTypeRequest;
import com.fractal.domain.employee_management.performance.type.dto.PerformanceTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class PerformanceTypeServiceImpl implements PerformanceTypeService {

    private final PerformanceTypeRepository performanceTypeRepository;

    @Override
    public PerformanceType create(PerformanceTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<PerformanceType> getAll() {
        return performanceTypeRepository.findAll();
    }

    @Override
    public PerformanceType getByCode(String code) {
        return performanceTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Performance Type with code: " + code + " not found"));
    }

    @Override
    public PerformanceType getById(Long id) {
        return findById(id);
    }

    @Override
    public PerformanceType update(Long id, PerformanceTypeRequest dto) {
        try {
            PerformanceType performanceType = findById(id);
            performanceType.setCode(dto.code());
            performanceType.setName(dto.name());
            return save(performanceType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        performanceTypeRepository.delete(findById(id));
    }

    @Override
    public PerformanceTypeResponse toDTO(PerformanceType performanceType) {
        return new PerformanceTypeResponse(
                performanceType.getId(),
                performanceType.getCode(),
                performanceType.getName(),
                performanceType.getCreatedDate()
        );
    }

    private PerformanceType toEntity(PerformanceTypeRequest dto) {
        return PerformanceType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private PerformanceType save(PerformanceType performanceType) {
        try {
            return performanceTypeRepository.save(performanceType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private PerformanceType findById(Long id) {
        return performanceTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Performance Type with id: " + id + " not found"));
    }

}
