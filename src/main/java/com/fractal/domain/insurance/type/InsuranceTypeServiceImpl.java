package com.fractal.domain.insurance.type;

import com.fractal.domain.insurance.type.dto.InsuranceTypeRequest;
import com.fractal.domain.insurance.type.dto.InsuranceTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
class InsuranceTypeServiceImpl implements InsuranceTypeService {

    private final InsuranceTypeRepository insuranceTypeRepository;

    @Override
    public InsuranceType create(InsuranceTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<InsuranceType> getAll() {
        return insuranceTypeRepository.findAll();
    }

    @Override
    public InsuranceType getByCode(String code) {
        return insuranceTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Insurance Type with code: " + code + " not found"));
    }

    @Override
    public InsuranceType getById(Long id) {
        return findById(id);
    }

    @Override
    public InsuranceType update(Long id, InsuranceTypeRequest dto) {
        try {
            InsuranceType insuranceType = findById(id);
            insuranceType.setCode(dto.code());
            insuranceType.setName(dto.name());
            return save(insuranceType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      insuranceTypeRepository.delete(findById(id));
    }

    @Override
    public InsuranceTypeResponse toDTO(InsuranceType insuranceType) {
        return new InsuranceTypeResponse(
                insuranceType.getId(),
                insuranceType.getCode(),
                insuranceType.getName(),
                insuranceType.getCreatedDate()
        );
    }

    private InsuranceType toEntity(InsuranceTypeRequest dto) {
        return InsuranceType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private InsuranceType save(InsuranceType insuranceType) {
        try {
            return insuranceTypeRepository.save(insuranceType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private InsuranceType findById(Long id) {
        return insuranceTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Insurance Type with id: " + id + " not found"));
    }

}
