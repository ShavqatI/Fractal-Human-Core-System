package com.fractal.controller.authorization.user;


import com.fractal.domain.authorization.mapping.user_employee.UserEmployeeMappingService;
import com.fractal.domain.authorization.mapping.user_employee.dto.UserEmployeeMappingRequest;
import com.fractal.domain.authorization.mapping.user_employee.dto.UserEmployeeMappingResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/authorization/user-employee-mapping")
@RequiredArgsConstructor
public class UserEmployeeMappingController {

    private final UserEmployeeMappingService userEmployeeMappingService;
    @PostMapping
    public ResponseEntity<UserEmployeeMappingResponse> create(@RequestBody @Valid UserEmployeeMappingRequest dto) {
        return new ResponseEntity<>(userEmployeeMappingService.toDTO(userEmployeeMappingService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<UserEmployeeMappingResponse>> getAll() {
        return ResponseEntity.ok(userEmployeeMappingService.getAll().stream().map(userEmployeeMappingService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserEmployeeMappingResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userEmployeeMappingService.toDTO(userEmployeeMappingService.getById(id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserEmployeeMappingResponse> update(@PathVariable Long id, @RequestBody @Valid UserEmployeeMappingRequest dto) {
      return  ResponseEntity.ok(userEmployeeMappingService.toDTO(userEmployeeMappingService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userEmployeeMappingService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
