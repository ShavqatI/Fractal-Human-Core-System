package com.fractal.controller.organization_management.department;

import com.fractal.domain.organization_management.department.DepartmentService;
import com.fractal.domain.organization_management.department.dto.DepartmentRequest;
import com.fractal.domain.organization_management.department.dto.DepartmentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organization-management/department/{departmentId}/child")
@RequiredArgsConstructor
public class DepartmentChildController {

    private final DepartmentService departmentService;

    @PostMapping()
    public ResponseEntity<DepartmentResponse> create(@PathVariable Long departmentId, @RequestBody @Valid DepartmentRequest dto) {
        return new ResponseEntity<>(departmentService.toDTO(departmentService.addChild(departmentId,dto)), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> update(@PathVariable Long departmentId, @PathVariable Long id, @RequestBody @Valid DepartmentRequest dto) {
        return ResponseEntity.ok(departmentService.toDTO(departmentService.updateChild(departmentId,id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long departmentId, @PathVariable Long id) {
        departmentService.deleteChild(departmentId,id);
        return ResponseEntity.noContent().build();
    }
}
