package com.fractal.domain.report.attendance;

import com.fractal.domain.dictionary.docuemnt_template_manager.DocumentTemplateManagerService;
import com.fractal.domain.employee_management.attendance.Attendance;
import com.fractal.domain.employee_management.attendance.AttendanceService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employee.usecase.EmployeeUseCaseService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class AttendanceReportServiceImpl implements AttendanceReportService {
    private final AttendanceService attendanceService;
    private final DocumentTemplateManagerService documentTemplateManagerService;
    private final EmployeeUseCaseService employeeUseCaseService;


    @Value("${resource-storage.temporary}")
    private String resourceStoragePath;
    @Override
    public Path byPeriod(AttendanceReportPeriodRequest dto) {
        try {
            Path outputPath = Path.of(resourceStoragePath + UUID.randomUUID() + ".xlsx");
            FileInputStream fis = new FileInputStream(documentTemplateManagerService.getByCode("ATTENDANCE_PERIOD_REPORT").getFilePath());
            Workbook workbook = new XSSFWorkbook(fis);
            fis.close();

            Map<Employee, List<LocalDate>> attendances = attendanceService.getAllByPeriod(dto.startDate(), dto.endDate()).stream()
                    .collect(Collectors.groupingBy(
                            Attendance::getEmployee,         // group by Employee
                            Collectors.mapping(
                                    Attendance::getDate,    // extract date
                                    Collectors.toList()     // collect as list
                            )
                    ));


            Sheet sheet = workbook.getSheetAt(0);

            Row periodRow = sheet.getRow(1);
            if (periodRow == null) periodRow = sheet.createRow(1);
            Cell startDateCell = periodRow.getCell(0);
            if (startDateCell == null) startDateCell = periodRow.createCell(0);
            startDateCell.setCellValue(dto.startDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            Cell endDateCell = periodRow.getCell(1);
            if (endDateCell == null) endDateCell = periodRow.createCell(1);
            endDateCell.setCellValue(dto.endDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));


            var headerRow = sheet.getRow(2);
            var headerDate = dto.startDate();
            var headerCellIndex = 2;
            CellStyle style = workbook.createCellStyle();
            style.setRotation((short) 90);


            while (!headerDate.isAfter(dto.endDate())) {
                Cell cell = headerRow.getCell(headerCellIndex);
                if (cell == null) cell = headerRow.createCell(headerCellIndex);
                cell.setCellValue(headerDate.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
                cell.setCellStyle(style);
                headerDate = headerDate.plusDays(1);
                headerCellIndex++;
            }

            var rowIndex = 3;
            for (Map.Entry<Employee, List<LocalDate>> entry : attendances.entrySet()) {
                Employee employee = entry.getKey();
                List<LocalDate> dates = entry.getValue();
                Row row = sheet.getRow(rowIndex);
                if (row == null) row = sheet.createRow(rowIndex);
                Cell cell = row.getCell(0);
                if (cell == null) cell = row.createCell(0);
                cell.setCellValue(employeeUseCaseService.getFullName(employee));
                cell = row.getCell(1);
                if (cell == null) cell = row.createCell(1);
                cell.setCellValue(employee.getUuid());

                var cellIndex = 2;
                for (LocalDate date : dates) {
                    cell = row.getCell(cellIndex);
                    if (cell == null) cell = row.createCell(cellIndex);
                    cell.setCellValue(date);
                    cellIndex++;
                }
                rowIndex++;
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
}
