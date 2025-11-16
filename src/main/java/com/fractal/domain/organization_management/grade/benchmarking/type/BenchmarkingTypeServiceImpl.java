package com.fractal.domain.organization_management.grade.benchmarking.type;

import com.fractal.domain.organization_management.grade.benchmarking.type.dto.BenchmarkingTypeRequest;
import com.fractal.domain.organization_management.grade.benchmarking.type.dto.BenchmarkingTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class BenchmarkingTypeServiceImpl implements BenchmarkingTypeService {

    private final BenchmarkingTypeRepository benchmarkingTypeRepository;

    @Override
    public BenchmarkingType create(BenchmarkingTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<BenchmarkingType> getAll() {
        return benchmarkingTypeRepository.findAll();
    }

    @Override
    public BenchmarkingType getByCode(String code) {
        return benchmarkingTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Insurance Type with code: " + code + " not found"));
    }

    @Override
    public BenchmarkingType getById(Long id) {
        return findById(id);
    }

    @Override
    public BenchmarkingType update(Long id, BenchmarkingTypeRequest dto) {
        try {
            BenchmarkingType benchmarkingType = findById(id);
            benchmarkingType.setCode(dto.code());
            benchmarkingType.setName(dto.name());
            return save(benchmarkingType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        benchmarkingTypeRepository.delete(findById(id));
    }

    @Override
    public BenchmarkingTypeResponse toDTO(BenchmarkingType benchmarkingType) {
        return new BenchmarkingTypeResponse(
                benchmarkingType.getId(),
                benchmarkingType.getCode(),
                benchmarkingType.getName(),
                benchmarkingType.getCreatedDate()
        );
    }

    private BenchmarkingType toEntity(BenchmarkingTypeRequest dto) {
        return BenchmarkingType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private BenchmarkingType save(BenchmarkingType benchmarkingType) {
        try {
            return benchmarkingTypeRepository.save(benchmarkingType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private BenchmarkingType findById(Long id) {
        return benchmarkingTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Insurance Type with id: " + id + " not found"));
    }

}
