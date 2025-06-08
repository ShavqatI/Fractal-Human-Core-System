package com.fractal.controller.employee_management.employee;


import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/relative")
@RequiredArgsConstructor
public class EmployeeRelativeController {

    private final EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<EmployeeResponse> create(@PathVariable Long employeeId, @RequestBody @Valid RelativeRequest dto) {
        return new ResponseEntity<>(employeeService.toDTO(employeeService.addRelative(employeeId,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid RelativeRequest dto) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.updateRelative(employeeId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        employeeService.deleteRelative(employeeId,id);
        return ResponseEntity.noContent().build();
    }
}
