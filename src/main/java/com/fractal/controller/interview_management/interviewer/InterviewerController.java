package com.fractal.controller.interview_management.interviewer;


import com.fractal.domain.interview.interviewer.InterviewerService;
import com.fractal.domain.interview.interviewer.dto.InterviewerRequest;
import com.fractal.domain.interview.interviewer.dto.InterviewerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/interview/{interviewId}/interviewer")
@RequiredArgsConstructor
public class InterviewerController {

    private final InterviewerService interviewerService;

    @PostMapping()
    public ResponseEntity<InterviewerResponse> create(@PathVariable Long interviewId, @RequestBody @Valid InterviewerRequest dto) {
        return new ResponseEntity<>(interviewerService.toDTO(interviewerService.create(interviewId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InterviewerResponse>> getAll(@PathVariable Long interviewId) {
        return ResponseEntity.ok(interviewerService.getAllByInterviewId(interviewId).stream().map(interviewerService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterviewerResponse> getById(@PathVariable Long interviewId, @PathVariable Long id) {
        return ResponseEntity.ok(interviewerService.toDTO(interviewerService.getById(interviewId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewerResponse> update(@PathVariable Long interviewId, @PathVariable Long id, @RequestBody @Valid InterviewerRequest dto) {
        return ResponseEntity.ok(interviewerService.toDTO(interviewerService.update(interviewId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long interviewId, @PathVariable Long id) {
        interviewerService.delete(interviewId, id);
        return ResponseEntity.noContent().build();
    }


}
