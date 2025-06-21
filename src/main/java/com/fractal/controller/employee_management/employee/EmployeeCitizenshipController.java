package com.fractal.controller.employee_management.employee;


import com.fractal.domain.employee_management.citizenship.CitizenshipService;
import com.fractal.domain.employee_management.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.employee_management.citizenship.dto.CitizenshipResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/citizenship")
@RequiredArgsConstructor
public class EmployeeCitizenshipController {

    private final CitizenshipService citizenshipService;

    @PostMapping()
    public ResponseEntity<CitizenshipResponse> create(@PathVariable Long employeeId, @RequestBody @Valid CitizenshipRequest dto) {
        return new ResponseEntity<>(citizenshipService.toDTO(citizenshipService.create(employeeId,dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CitizenshipResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(citizenshipService.getAllByEmployeeId(employeeId).stream().map(citizenshipService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CitizenshipResponse> getById(@PathVariable Long employeeId,@PathVariable Long id) {
        return ResponseEntity.ok(citizenshipService.toDTO(citizenshipService.getById(employeeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CitizenshipResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid CitizenshipRequest dto) {
        return ResponseEntity.ok(citizenshipService.toDTO(citizenshipService.update(employeeId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        citizenshipService.delete(employeeId,id);
        return ResponseEntity.noContent().build();
    }


}
