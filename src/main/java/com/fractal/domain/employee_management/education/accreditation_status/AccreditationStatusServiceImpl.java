package com.fractal.domain.employee_management.education.accreditation_status;

import com.fractal.domain.employee_management.education.accreditation_status.dto.AccreditationStatusRequest;
import com.fractal.domain.employee_management.education.degree_type.dto.DegreeTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
class AccreditationStatusServiceImpl implements AccreditationStatusService {

    private final AccreditationStatusRepository accreditationStatusRepository;

    @Override
    public AccreditationStatus create(AccreditationStatusRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<AccreditationStatus> getAll() {
        return accreditationStatusRepository.findAll();
    }

    @Override
    public AccreditationStatus getByCode(String code) {
        return accreditationStatusRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Employment Type with code: " + code + " not found"));
    }

    @Override
    public AccreditationStatus getById(Long id) {
        return findById(id);
    }

    @Override
    public AccreditationStatus update(Long id, AccreditationStatusRequest dto) {
        try {
            AccreditationStatus educationDocumentType = findById(id);
            educationDocumentType.setCode(dto.code());
            educationDocumentType.setName(dto.name());
            return save(educationDocumentType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      accreditationStatusRepository.delete(findById(id));
    }

    @Override
    public DegreeTypeResponse toDTO(AccreditationStatus accreditationStatus) {
        return new DegreeTypeResponse(
                accreditationStatus.getId(),
                accreditationStatus.getCode(),
                accreditationStatus.getName(),
                accreditationStatus.getCreatedDate()
        );
    }

    private AccreditationStatus toEntity(AccreditationStatusRequest dto) {
        return AccreditationStatus.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private AccreditationStatus save(AccreditationStatus accreditationStatus) {
        try {
            return accreditationStatusRepository.save(accreditationStatus);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private AccreditationStatus findById(Long id) {
        return accreditationStatusRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Accreditation Status with id: " + id + " not found"));
    }

}
