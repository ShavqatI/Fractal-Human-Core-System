package com.fractal.domain.employee_management.attendance.absence.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.attendance.absence.Absence;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceRequest;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceResponse;
import com.fractal.domain.employee_management.attendance.absence.type.AbsenceTypeService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
class AbsenceMapperServiceImpl implements AbsenceMapperService {

    private final StatusService statusService;
    private final AbsenceTypeService absenceTypeService;
    private final EmployeeService employeeService;
    @Override
    public AbsenceResponse toDTO(Absence absence) {
        return new AbsenceResponse(
                absence.getId(),
                employeeService.toCompactDTO(absence.getEmployee()),
                absenceTypeService.toDTO(absence.getAbsenceType()),
                statusService.toCompactDTO(absence.getStatus()),
                absence.getStartDate(),
                absence.getEndDate(),
                absence.getDuration(),
                absence.getReason(),
                absence.getRemarks(),
                absence.getCreatedDate()
        );
    }


    @Override
    public Absence toEntity(AbsenceRequest dto) {
        return mapToEntity(new Absence(), dto);
    }

    @Override
    public Absence toEntity(Absence absence, AbsenceRequest dto) {
        return mapToEntity(absence, dto);
    }

    private Absence mapToEntity(Absence absence, AbsenceRequest dto) {
        absence.setEmployee(employeeService.getById(dto.employeeId()));
        absence.setAbsenceType(absenceTypeService.getById(dto.absenceTypeId()));
        absence.setStatus(statusService.getById(dto.statusId()));
        absence.setStartDate(dto.startDate());
        absence.setEndDate(dto.endDate());
        absence.setDuration((int) Duration.between(dto.startDate(),dto.endDate()).toDays());
        absence.setReason(dto.reason());
        absence.setRemarks(dto.remarks());
        return absence;
    }
}
