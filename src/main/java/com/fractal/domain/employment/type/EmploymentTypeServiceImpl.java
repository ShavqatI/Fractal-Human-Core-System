package com.fractal.domain.employment.type;

import com.fractal.domain.employment.type.dto.EmploymentTypeCompactResponse;
import com.fractal.domain.employment.type.dto.EmploymentTypeRequest;
import com.fractal.domain.employment.type.dto.EmploymentTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmploymentTypeServiceImpl implements EmploymentTypeService {

    private final EmploymentTypeRepository employmentTypeRepository;

    @Override
    public EmploymentType create(EmploymentTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<EmploymentType> getAll() {
        return employmentTypeRepository.findAll();
    }

    @Override
    public EmploymentType getByCode(String code) {
        return employmentTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Employment Type with code: " + code + " not found"));
    }

    @Override
    public EmploymentType getById(Long id) {
        return findById(id);
    }

    @Override
    public EmploymentType update(Long id, EmploymentTypeRequest dto) {
        try {
            EmploymentType employmentType = findById(id);
            employmentType.setCode(dto.code());
            employmentType.setName(dto.name());
            return save(employmentType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        employmentTypeRepository.delete(findById(id));
    }

    @Override
    public EmploymentTypeResponse toDTO(EmploymentType employmentType) {
        return new EmploymentTypeResponse(
                employmentType.getId(),
                employmentType.getCode(),
                employmentType.getName(),
                employmentType.getCreatedDate()
        );
    }

    @Override
    public EmploymentTypeCompactResponse toCompactDTO(EmploymentType employmentType) {
        return new EmploymentTypeCompactResponse(
                employmentType.getId(),
                employmentType.getCode(),
                employmentType.getName()
        );
    }

    private EmploymentType toEntity(EmploymentTypeRequest dto) {
        return EmploymentType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private EmploymentType save(EmploymentType employmentType) {
        try {
            return employmentTypeRepository.save(employmentType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private EmploymentType findById(Long id) {
        return employmentTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employment Type with id: " + id + " not found"));
    }

}
