package com.fractal.domain.employee_management.attendance;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.attendance.absence.AbsenceService;
import com.fractal.domain.employee_management.attendance.dto.AttendanceBatchRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;
import com.fractal.domain.employee_management.attendance.mapper.AttendanceMapperService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceStateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapperService mapperService;
    private final AbsenceService absenceService;
    private final AuthenticatedService authenticatedService;
    private final StatusService statusService;

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
    public List<Attendance> getAllByUserId() {
        return attendanceRepository.findAllByUserId(authenticatedService.getUser().getId());
    }
    @Override
    public List<Attendance> getAllByUserIdCreated() {
        return attendanceRepository.findAllByUserIdAndStatusId(authenticatedService.getUser().getId(), statusService.getByCode("CREATED").getId());
    }
    @Override
    public List<Attendance> getAllByUserIdReviewed() {
        return attendanceRepository.findAllByUserIdAndStatusId(authenticatedService.getUser().getId(), statusService.getByCode("CREATED").getId());
    }
    @Override
    public List<Attendance> getAllByUserIdApproved() {
        return attendanceRepository.findAllByUserIdAndStatusId(authenticatedService.getUser().getId(), statusService.getByCode("CREATED").getId());
    }

    @Override
    public List<Attendance> getAllByPeriod(LocalDate startDate, LocalDate endDate) {
        return attendanceRepository.findAllByPeriod(startDate, endDate);
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

    @Override
    public Attendance review(Long id) {
        var attendance = getById(id);
        if (attendance.getStatus().getCode().equals("CREATED")) {
            attendance.setReviewedDate(LocalDateTime.now());
            attendance.setReviewedUser(authenticatedService.getUser());
            attendance.setStatus(statusService.getByCode("REVIEWED"));
            return save(attendance);
        } else {
            throw new ResourceStateException("The status is not valid is: " + attendance.getStatus().getName());
        }
    }

    @Override
    public Attendance approve(Long id) {
        var attendance = getById(id);
        if (attendance.getStatus().getCode().equals("REVIEWED")) {
            attendance.setApprovedDate(LocalDateTime.now());
            attendance.setApprovedUser(authenticatedService.getUser());
            attendance.setStatus(statusService.getByCode("APPROVED"));
            return save(attendance);
        } else {
            throw new ResourceStateException("The status is not valid is: " + attendance.getStatus().getName());
        }

    }

    @Override
    public List<Attendance> review(List<Long> dto) {
        return dto.stream().map(id-> review(id)).collect(Collectors.toList());
    }

    @Override
    public List<Attendance> approve(List<Long> dto) {
        return dto.stream().map(id-> approve(id)).collect(Collectors.toList());
    }

}
