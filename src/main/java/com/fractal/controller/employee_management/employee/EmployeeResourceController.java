package com.fractal.controller.employee_management.employee;


import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employee.dto.EmployeeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/resource")
@RequiredArgsConstructor
public class EmployeeResourceController {

    private final EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<EmployeeResponse> create(@PathVariable Long employeeId, @RequestBody @Valid MultipartFile file) {
        return new ResponseEntity<>(employeeService.toDTO(employeeService.addResource(employeeId,file,null)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid MultipartFile file) {
        return ResponseEntity.ok(employeeService.toDTO(employeeService.updateResource(employeeId,id, file)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        employeeService.deleteResource(employeeId,id);
        return ResponseEntity.noContent().build();
    }

}
