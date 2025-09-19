package com.fractal.domain.employee_management.attendance.absence;

import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceRequest;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceResponse;
import com.fractal.domain.employee_management.attendance.absence.mapper.AbsenceMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class AbsenceServiceImpl implements AbsenceService {

    private final AbsenceRepository absenceRepository;
    private final AbsenceMapperService mapperService;

    @Override
    @Transactional
    public Absence create(AbsenceRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<Absence> getAll() {
        return absenceRepository.findAll();
    }

    @Override
    public Absence getById(Long id) {
        return findById(id);
    }

    @Override
    public List<Absence> getAllByEmployeeId(Long employeeId) {
        return absenceRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    @Transactional
    public Absence update(Long id, AbsenceRequest dto) {
        try {
            Absence absence = mapperService.toEntity(findById(id),dto);
            return save(absence);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
      absenceRepository.delete(findById(id));
    }

    @Override
    public AbsenceResponse toDTO(Absence absence) {
        return mapperService.toDTO(absence);
    }

    private Absence save(Absence absence) {
        try {
            return absenceRepository.save(absence);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Absence findById(Long id) {
        return absenceRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Absence with id: " + id + " not found"));
    }
}
