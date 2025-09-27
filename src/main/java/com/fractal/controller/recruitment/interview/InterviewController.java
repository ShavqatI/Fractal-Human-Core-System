package com.fractal.controller.recruitment.interview;


import com.fractal.domain.interview.InterviewService;
import com.fractal.domain.interview.dto.InterviewRequest;
import com.fractal.domain.interview.dto.InterviewResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/interview")
@RequiredArgsConstructor
public class InterviewController {

    private final InterviewService interviewTypeService;
    @PostMapping
    public ResponseEntity<InterviewResponse> create(@RequestBody @Valid InterviewRequest dto) {
        return new ResponseEntity<>(interviewTypeService.toDTO(interviewTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InterviewResponse>> getAll() {
        return ResponseEntity.ok(interviewTypeService.getAll().stream().map(interviewTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InterviewResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(interviewTypeService.toDTO(interviewTypeService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewResponse> update(@PathVariable Long id, @RequestBody @Valid InterviewRequest dto) {
      return  ResponseEntity.ok(interviewTypeService.toDTO(interviewTypeService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        interviewTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
