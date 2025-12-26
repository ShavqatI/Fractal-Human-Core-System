package com.fractal.domain.employee_management.attendance;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.attendance.absence.AbsenceService;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceCancelRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceBatchRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceCancelRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;
import com.fractal.domain.employee_management.attendance.mapper.AttendanceMapperService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceStateException;
import lombok.RequiredArgsConstructor;
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
                .map(attendanceBatchRequest ->
                        {
                            var attendance = mapperService.toEntity(attendanceBatchRequest);
                            if(attendanceBatchRequest.absence() != null){
                               attendance.setAbsence(absenceService.create(attendanceBatchRequest.absence()));
                            }
                            return save(attendance);
                        }
                        ).collect(Collectors.toList());
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
        return attendanceRepository.findAllByUserIdAndStatusId(authenticatedService.getUser().getId(), statusService.getByCode("REVIEWED").getId());
    }
    @Override
    public List<Attendance> getAllByUserIdApproved() {
        return attendanceRepository.findAllByUserIdAndStatusId(authenticatedService.getUser().getId(), statusService.getByCode("APPROVED").getId());
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
            if(attendance.getAbsence() != null){
                absenceService.review(attendance.getAbsence().getId());
            }
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
            if(attendance.getAbsence() != null){
                absenceService.approve(attendance.getAbsence().getId());
            }
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

    @Override
    public Attendance cancel(AttendanceCancelRequest dto) {
        var attendance = getById(dto.id());
        if (attendance.getStatus().getCode().equals("REVIEWED") || attendance.getStatus().getCode().equals("CREATED")) {
            attendance.setCanceledDate(LocalDateTime.now());
            attendance.setCanceledUser(authenticatedService.getUser());
            attendance.setCanceledReason(dto.reason());
            attendance.setStatus(statusService.getByCode("CANCELED"));
            if(attendance.getAbsence() != null){
                absenceService.cancel( new AbsenceCancelRequest(attendance.getAbsence().getId(), dto.reason()));
            }
            return save(attendance);
        } else {
            throw new ResourceStateException("The status is not valid is: " + attendance.getStatus().getName());
        }
    }
}
