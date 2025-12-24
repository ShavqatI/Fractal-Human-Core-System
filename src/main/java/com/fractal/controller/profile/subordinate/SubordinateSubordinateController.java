package com.fractal.controller.profile.subordinate;


import com.fractal.domain.employee_management.business_trip.dto.BusinessTripCancelRequest;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripProlongRequest;
import com.fractal.domain.employee_management.business_trip.dto.BusinessTripResponse;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.employee_management.subordinate.dto.SubordinateResponse;
import com.fractal.domain.profile.subordinate.business_trip.SubordinateBusinessTripRequest;
import com.fractal.domain.profile.subordinate.subordinate.SubordinateSubordinateService;
import com.fractal.domain.resource.FileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/subordinate/subordinate")
@RequiredArgsConstructor
public class SubordinateSubordinateController {

    private final SubordinateSubordinateService subordinateSubordinateService;
    private final EmployeeService employeeService;


    @GetMapping
    public ResponseEntity<List<SubordinateResponse>> getAll() {
        return ResponseEntity.ok(subordinateSubordinateService.getAll().stream().map(subordinateSubordinateService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/active-employees")
    public ResponseEntity<List<EmployeeCompactResponse>> getAllActiveEmployees() {
        return ResponseEntity.ok(subordinateSubordinateService.getAllActiveEmployees().stream().map(employeeService::toCompactDTO).collect(Collectors.toList()));
    }

}
