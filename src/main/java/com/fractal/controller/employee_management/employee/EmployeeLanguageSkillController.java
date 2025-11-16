package com.fractal.controller.employee_management.employee;


import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.employee_management.language_skill.EmployeeLanguageSkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/language-skill")
@RequiredArgsConstructor
public class EmployeeLanguageSkillController {

    private final EmployeeLanguageSkillService languageSkillService;

    @PostMapping
    public ResponseEntity<LanguageSkillResponse> create(@PathVariable Long employeeId, @RequestBody @Valid LanguageSkillRequest dto) {
        return new ResponseEntity<>(languageSkillService.toDTO(languageSkillService.create(employeeId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LanguageSkillResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(languageSkillService.getAllByCandidateId(employeeId).stream().map(languageSkillService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageSkillResponse> getById(@PathVariable Long employeeId, @PathVariable Long id) {
        return ResponseEntity.ok(languageSkillService.toDTO(languageSkillService.getById(employeeId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageSkillResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid LanguageSkillRequest dto) {
        return ResponseEntity.ok(languageSkillService.toDTO(languageSkillService.update(employeeId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        languageSkillService.delete(employeeId, id);
        return ResponseEntity.noContent().build();
    }

}
