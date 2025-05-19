package com.fractal.domain.employee_management.identification_document.type;

import com.fractal.domain.employee_management.identification_document.type.dto.IdentificationDocumentTypeRequest;
import com.fractal.domain.employee_management.identification_document.type.dto.IdentificationDocumentTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class IdentificationDocumentTypeServiceImpl implements IdentificationDocumentTypeService {

    private final IdentificationDocumentTypeRepository identificationDocumentTypeRepository;

    @Override
    public IdentificationDocumentType create(IdentificationDocumentTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<IdentificationDocumentType> getAll() {
        return identificationDocumentTypeRepository.findAll();
    }

    @Override
    public IdentificationDocumentType getByCode(String code) {
        return identificationDocumentTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Identification Document Type with code: " + code + " not found"));
    }

    @Override
    public IdentificationDocumentType getById(Long id) {
        return findById(id);
    }

    @Override
    public IdentificationDocumentType update(Long id, IdentificationDocumentTypeRequest dto) {
        try {
            IdentificationDocumentType identificationDocumentType = findById(id);
            identificationDocumentType.setCode(dto.code());
            identificationDocumentType.setName(dto.name());
            return save(identificationDocumentType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      identificationDocumentTypeRepository.delete(findById(id));
    }

    @Override
    public IdentificationDocumentTypeResponse toDTO(IdentificationDocumentType identificationDocumentType) {
        return new IdentificationDocumentTypeResponse(
                identificationDocumentType.getId(),
                identificationDocumentType.getCode(),
                identificationDocumentType.getName(),
                identificationDocumentType.getCreatedDate()
        );
    }

    private IdentificationDocumentType toEntity(IdentificationDocumentTypeRequest dto) {
        return IdentificationDocumentType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private IdentificationDocumentType save(IdentificationDocumentType identificationDocumentType) {
        try {
            return identificationDocumentTypeRepository.save(identificationDocumentType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private IdentificationDocumentType findById(Long id) {
        return identificationDocumentTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Identification Document Type with id: " + id + " not found"));
    }

}
