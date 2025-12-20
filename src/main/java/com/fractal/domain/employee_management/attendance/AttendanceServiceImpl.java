package com.fractal.domain.employee_management.attendance;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.docuemnt_template_manager.DocumentTemplateManagerService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.attendance.absence.AbsenceService;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceBatchRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendancePeriodReportRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceRequest;
import com.fractal.domain.employee_management.attendance.dto.AttendanceResponse;
import com.fractal.domain.employee_management.attendance.mapper.AttendanceMapperService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import com.fractal.domain.order.vacation.VacationOrder;
import com.fractal.domain.resource.FileService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceStateException;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapperService mapperService;
    private final AbsenceService absenceService;
    private final AuthenticatedService authenticatedService;
    private final StatusService statusService;
    private final FileService fileService;
    private final DocumentTemplateManagerService documentTemplateManagerService;
    private final EmployeeUseCaseService employeeUseCaseService;


    @Value("${resource-storage.temporary}")
    private String resourceStoragePath;

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

    @Override
    public Path periodReport(AttendancePeriodReportRequest dto) {
        try {
            Path outputPath = Path.of(resourceStoragePath + UUID.randomUUID() + ".xlsx");
            Map<Employee, List<LocalDate>> attendances = attendanceRepository.findForPeriodReport(dto.startDate(), dto.endDate()).stream()
                    .collect(Collectors.groupingBy(
                            Attendance::getEmployee,         // group by Employee
                            Collectors.mapping(
                                    Attendance::getDate,    // extract date
                                    Collectors.toList()     // collect as list
                            )
                    ));
            FileInputStream fis = new FileInputStream(documentTemplateManagerService.getByCode("DIGITALSTAMP").getFilePath());
            Workbook workbook = new XSSFWorkbook(fis);
            fis.close();

            Sheet sheet = workbook.getSheetAt(0); // first sheet

            var rowIndex = 1;
            for (Map.Entry<Employee, List<LocalDate>> entry : attendances.entrySet()) {
                Employee employee = entry.getKey();
                List<LocalDate> dates = entry.getValue();
                Row row = sheet.getRow(rowIndex);
                if (row == null) row = sheet.createRow(1);
                row.getCell(1).setCellValue(employeeUseCaseService.getFullName(employee));
                var cellIndex = 2;
                for (LocalDate date : dates) {
                    Cell cell = row.getCell(cellIndex);
                    if (cell == null) cell = row.createCell(2);
                    cell.setCellValue(date);
                }
            }
            FileOutputStream fos = new FileOutputStream(outputPath.toFile());
            workbook.write(fos);
            fos.close();
            workbook.close();
            return outputPath;
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
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
        return dto.stream().map(id-> review(id)).collect(Collectors.toList());
    }

}
