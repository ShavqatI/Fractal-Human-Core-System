package com.fractal.domain.employee_management.attendance.absence;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.attendance.Attendance;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceCancelRequest;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceCompactRequest;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceRequest;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceResponse;
import com.fractal.domain.employee_management.attendance.absence.mapper.AbsenceMapperService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceStateException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
class AbsenceServiceImpl implements AbsenceService {

    private final AbsenceRepository absenceRepository;
    private final AbsenceMapperService mapperService;
    private final StatusService statusService;
    private final AuthenticatedService authenticatedService;

    @Override
    @Transactional
    public Absence create(AbsenceRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public Absence create(AbsenceCompactRequest dto) {
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
            Absence absence = mapperService.toEntity(findById(id), dto);
            return save(absence);
        } catch (DataAccessException e) {
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
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Absence findById(Long id) {
        return absenceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Absence with id: " + id + " not found"));
    }

    @Override
    public Absence review(Long id) {
        var absence = getById(id);
        if (absence.getStatus().getCode().equals("CREATED")) {
            absence.setReviewedDate(LocalDateTime.now());
            absence.setReviewedUser(authenticatedService.getUser());
            absence.setStatus(statusService.getByCode("REVIEWED"));
            return save(absence);
        } else {
            throw new ResourceStateException("The status is not valid is: " + absence.getStatus().getName());
        }
    }

    @Override
    public Absence approve(Long id) {
        var absence = getById(id);
        if (absence.getStatus().getCode().equals("REVIEWED")) {
            absence.setApprovedDate(LocalDateTime.now());
            absence.setApprovedUser(authenticatedService.getUser());
            absence.setStatus(statusService.getByCode("APPROVED"));
            return save(absence);
        } else {
            throw new ResourceStateException("The status is not valid is: " + absence.getStatus().getName());
        }
    }

    @Override
    public Absence cancel(AbsenceCancelRequest dto) {
        var absence = getById(dto.id());
        if (absence.getStatus().getCode().equals("REVIEWED") || absence.getStatus().getCode().equals("CREATED")) {
            absence.setCanceledDate(LocalDateTime.now());
            absence.setCanceledUser(authenticatedService.getUser());
            absence.setCanceledReason(dto.reason());
            absence.setStatus(statusService.getByCode("CANCELED"));
            return save(absence);
        } else {
            throw new ResourceStateException("The status is not valid is: " + absence.getStatus().getName());
        }
    }
}
