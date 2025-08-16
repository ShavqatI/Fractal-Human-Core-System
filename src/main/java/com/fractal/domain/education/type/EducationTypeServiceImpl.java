package com.fractal.domain.education.type;

import com.fractal.domain.education.type.dto.EducationTypeRequest;
import com.fractal.domain.education.type.dto.EducationTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
class EducationTypeServiceImpl implements EducationTypeService {

    private final EducationTypeRepository educationTypeRepository;

    @Override
    public EducationType create(EducationTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<EducationType> getAll() {
        return educationTypeRepository.findAll();
    }

    @Override
    public EducationType getByCode(String code) {
        return educationTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Employment Type with code: " + code + " not found"));
    }

    @Override
    public EducationType getById(Long id) {
        return findById(id);
    }

    @Override
    public EducationType update(Long id, EducationTypeRequest dto) {
        try {
            EducationType educationType = findById(id);
            educationType.setCode(dto.code());
            educationType.setName(dto.name());
            return save(educationType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      educationTypeRepository.delete(findById(id));
    }

    @Override
    public EducationTypeResponse toDTO(EducationType educationType) {
        return new EducationTypeResponse(
                educationType.getId(),
                educationType.getCode(),
                educationType.getName(),
                educationType.getCreatedDate()
        );
    }

    private EducationType toEntity(EducationTypeRequest dto) {
        return EducationType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private EducationType save(EducationType educationType) {
        try {
            return educationTypeRepository.save(educationType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private EducationType findById(Long id) {
        return educationTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Education Type with id: " + id + " not found"));
    }

}
