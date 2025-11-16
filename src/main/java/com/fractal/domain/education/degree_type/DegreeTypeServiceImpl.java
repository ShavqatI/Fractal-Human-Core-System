package com.fractal.domain.education.degree_type;

import com.fractal.domain.education.degree_type.dto.DegreeTypeRequest;
import com.fractal.domain.education.degree_type.dto.DegreeTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class DegreeTypeServiceImpl implements DegreeTypeService {

    private final DegreeTypeRepository degreeTypeRepository;

    @Override
    public DegreeType create(DegreeTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<DegreeType> getAll() {
        return degreeTypeRepository.findAll();
    }

    @Override
    public DegreeType getByCode(String code) {
        return degreeTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Employment Type with code: " + code + " not found"));
    }

    @Override
    public DegreeType getById(Long id) {
        return findById(id);
    }

    @Override
    public DegreeType update(Long id, DegreeTypeRequest dto) {
        try {
            DegreeType educationDocumentType = findById(id);
            educationDocumentType.setCode(dto.code());
            educationDocumentType.setName(dto.name());
            return save(educationDocumentType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        degreeTypeRepository.delete(findById(id));
    }

    @Override
    public DegreeTypeResponse toDTO(DegreeType degreeType) {
        return new DegreeTypeResponse(
                degreeType.getId(),
                degreeType.getCode(),
                degreeType.getName(),
                degreeType.getCreatedDate()
        );
    }

    private DegreeType toEntity(DegreeTypeRequest dto) {
        return DegreeType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private DegreeType save(DegreeType degreeType) {
        try {
            return degreeTypeRepository.save(degreeType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private DegreeType findById(Long id) {
        return degreeTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Degree Type with id: " + id + " not found"));
    }

}
