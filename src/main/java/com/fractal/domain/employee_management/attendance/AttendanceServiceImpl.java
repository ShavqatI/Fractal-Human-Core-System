package com.fractal.domain.employee_management.attendance;

import com.fractal.domain.employee_management.attendance.absence.AbsenceService;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceBatchRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;
import com.fractal.domain.employee_management.attendance.mapper.AttendanceMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapperService mapperService;
    private final AbsenceService absenceService;

    @Override
    @Transactional
    public Attendance create(AttendanceRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<Attendance> create(List<AttendanceBatchRequest> dto) {
        List<Attendance> attendances = dto.stream()
                .filter(attendanceBatchRequest -> attendanceBatchRequest.absence() == null)
                .map(attendanceBatchRequest -> save(mapperService.toEntity(attendanceBatchRequest)))
                .collect(Collectors.toList());
        dto.stream()
                .filter(attendanceBatchRequest -> attendanceBatchRequest.absence() != null)
                .forEach(attendanceBatchRequest -> absenceService.create(attendanceBatchRequest.absence()));

        return attendances;
    }

    @Override
    public List<Attendance> getAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance getById(Long id) {
        return findById(id);
    }

    @Override
    public List<Attendance> getAllByEmployeeId(Long employeeId) {
        return attendanceRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public Attendance update(Long id, AttendanceRequest dto) {
        try {
            Attendance attendance = mapperService.toEntity(findById(id), dto);
            return save(attendance);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        attendanceRepository.delete(findById(id));
    }

    @Override
    public AttendanceResponse toDTO(Attendance attendance) {
        return mapperService.toDTO(attendance);
    }

    private Attendance save(Attendance attendance) {
        try {
            return attendanceRepository.save(attendance);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Attendance findById(Long id) {
        return attendanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Attendance with id: " + id + " not found"));
    }
}
