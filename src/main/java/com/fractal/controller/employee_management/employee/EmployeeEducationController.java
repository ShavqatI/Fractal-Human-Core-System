package com.fractal.controller.employee_management.employee;


import com.fractal.domain.employee_management.education.dto.EducationRequest;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/education")
@RequiredArgsConstructor
public class EmployeeEducationController {

    private final EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<EmployeeResponse> create(@PathVariable Long employeeId, @RequestBody @Valid EducationRequest dto) {
        return new ResponseEntity<>(employeeService.toDTO(employeeService.addEducation(employeeId,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid EducationRequest dto) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.updateEducation(employeeId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        employeeService.deleteEducation(employeeId,id);
        return ResponseEntity.noContent().build();
    }


}
