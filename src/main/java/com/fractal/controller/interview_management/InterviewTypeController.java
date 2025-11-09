package com.fractal.controller.interview_management;


import com.fractal.domain.interview.type.InterviewTypeService;
import com.fractal.domain.interview.type.dto.InterviewTypeRequest;
import com.fractal.domain.interview.type.dto.InterviewTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/interview/type")
@RequiredArgsConstructor
public class InterviewTypeController {

    private final InterviewTypeService interviewTypeService;
    @PostMapping
    public ResponseEntity<InterviewTypeResponse> create(@RequestBody @Valid InterviewTypeRequest dto) {
        return new ResponseEntity<>(interviewTypeService.toDTO(interviewTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InterviewTypeResponse>> getAll() {
        return ResponseEntity.ok(interviewTypeService.getAll().stream().map(interviewTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InterviewTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(interviewTypeService.toDTO(interviewTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<InterviewTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(interviewTypeService.toDTO(interviewTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<InterviewTypeResponse> update(@PathVariable Long id, @RequestBody @Valid InterviewTypeRequest dto) {
      return  ResponseEntity.ok(interviewTypeService.toDTO(interviewTypeService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        interviewTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
