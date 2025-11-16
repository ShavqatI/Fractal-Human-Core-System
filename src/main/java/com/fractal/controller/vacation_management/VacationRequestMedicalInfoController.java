package com.fractal.controller.vacation_management;


import com.fractal.domain.vacation_management.request.medical_info.VacationRequestMedicalInfoService;
import com.fractal.domain.vacation_management.request.medical_info.dto.VacationRequestMedicalInfoRequest;
import com.fractal.domain.vacation_management.request.medical_info.dto.VacationRequestMedicalInfoResponse;
import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityRequest;
import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/vacation-management/request/{vacationRequestId}/medical-info")
@RequiredArgsConstructor
public class VacationRequestMedicalInfoController {

    private final VacationRequestMedicalInfoService medicalInfoService;

    @PostMapping()
    public ResponseEntity<VacationRequestMedicalInfoResponse> create(@PathVariable Long vacationRequestId, @RequestBody @Valid VacationRequestMedicalInfoRequest dto) {
        return new ResponseEntity<>(medicalInfoService.toDTO(medicalInfoService.create(vacationRequestId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<VacationRequestMedicalInfoResponse>> getAll(@PathVariable Long vacationRequestId) {
        return ResponseEntity.ok(medicalInfoService.getAllByVacationRequestId(vacationRequestId).stream().map(medicalInfoService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<VacationRequestMedicalInfoResponse> getById(@PathVariable Long vacationRequestId, @PathVariable Long id) {
        return ResponseEntity.ok(medicalInfoService.toDTO(medicalInfoService.getById(vacationRequestId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<VacationRequestMedicalInfoResponse> update(@PathVariable Long vacationRequestId, @PathVariable Long id, @RequestBody @Valid VacationRequestMedicalInfoRequest dto) {
        return ResponseEntity.ok(medicalInfoService.toDTO(medicalInfoService.update(vacationRequestId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long vacationRequestId, @PathVariable Long id) {
        medicalInfoService.delete(vacationRequestId,id);
        return ResponseEntity.noContent().build();
    }



}
