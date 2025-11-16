package com.fractal.domain.education.document_type;

import com.fractal.domain.education.document_type.dto.EducationDocumentTypeRequest;
import com.fractal.domain.education.document_type.dto.EducationDocumentTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class EducationDocumentTypeServiceImpl implements EducationDocumentTypeService {

    private final EducationDocumentTypeRepository educationDocumentTypeRepository;

    @Override
    public EducationDocumentType create(EducationDocumentTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<EducationDocumentType> getAll() {
        return educationDocumentTypeRepository.findAll();
    }

    @Override
    public EducationDocumentType getByCode(String code) {
        return educationDocumentTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Employment Type with code: " + code + " not found"));
    }

    @Override
    public EducationDocumentType getById(Long id) {
        return findById(id);
    }

    @Override
    public EducationDocumentType update(Long id, EducationDocumentTypeRequest dto) {
        try {
            EducationDocumentType educationDocumentType = findById(id);
            educationDocumentType.setCode(dto.code());
            educationDocumentType.setName(dto.name());
            return save(educationDocumentType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        educationDocumentTypeRepository.delete(findById(id));
    }

    @Override
    public EducationDocumentTypeResponse toDTO(EducationDocumentType educationDocumentType) {
        return new EducationDocumentTypeResponse(
                educationDocumentType.getId(),
                educationDocumentType.getCode(),
                educationDocumentType.getName(),
                educationDocumentType.getCreatedDate()
        );
    }

    private EducationDocumentType toEntity(EducationDocumentTypeRequest dto) {
        return EducationDocumentType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private EducationDocumentType save(EducationDocumentType educationDocumentType) {
        try {
            return educationDocumentTypeRepository.save(educationDocumentType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private EducationDocumentType findById(Long id) {
        return educationDocumentTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Education Type with id: " + id + " not found"));
    }

}
