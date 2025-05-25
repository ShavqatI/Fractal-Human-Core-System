package com.fractal.domain.employee_management.attendance.absence.type;

import com.fractal.domain.employee_management.attendance.absence.type.dto.AbsenceTypeRequest;
import com.fractal.domain.employee_management.attendance.absence.type.dto.AbsenceTypeResponse;
import com.fractal.domain.employee_management.education.type.EducationType;
import com.fractal.domain.employee_management.education.type.dto.EducationTypeRequest;
import com.fractal.domain.employee_management.education.type.dto.EducationTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
class AbsenceTypeServiceImpl implements AbsenceTypeService {

    private final AbsenceTypeRepository absenceTypeRepository;

    @Override
    public AbsenceType create(AbsenceTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<AbsenceType> getAll() {
        return absenceTypeRepository.findAll();
    }

    @Override
    public AbsenceType getByCode(String code) {
        return absenceTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Absence Type with code: " + code + " not found"));
    }

    @Override
    public AbsenceType getById(Long id) {
        return findById(id);
    }

    @Override
    public AbsenceType update(Long id, AbsenceTypeRequest dto) {
        try {
            AbsenceType absenceType = findById(id);
            absenceType.setCode(dto.code());
            absenceType.setName(dto.name());
            return save(absenceType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      absenceTypeRepository.delete(findById(id));
    }

    @Override
    public AbsenceTypeResponse toDTO(AbsenceType absenceType) {
        return new AbsenceTypeResponse(
                absenceType.getId(),
                absenceType.getCode(),
                absenceType.getName(),
                absenceType.getCreatedDate()
        );
    }

    private AbsenceType toEntity(AbsenceTypeRequest dto) {
        return AbsenceType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private AbsenceType save(AbsenceType absenceType) {
        try {
            return absenceTypeRepository.save(absenceType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private AbsenceType findById(Long id) {
        return absenceTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Absence Type with id: " + id + " not found"));
    }

}
