package com.fractal.controller.interview_management;


import com.fractal.domain.interview.interviewee.IntervieweeService;
import com.fractal.domain.interview.interviewee.dto.IntervieweeRequest;
import com.fractal.domain.interview.interviewee.dto.IntervieweeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/interview/{interviewId}/interviewee")
@RequiredArgsConstructor
public class IntervieweeController {

    private final IntervieweeService intervieweeService;

    @PostMapping()
    public ResponseEntity<IntervieweeResponse> create(@PathVariable Long interviewId, @RequestBody @Valid IntervieweeRequest dto) {
        return new ResponseEntity<>(intervieweeService.toDTO(intervieweeService.create(interviewId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<IntervieweeResponse>> getAll(@PathVariable Long interviewId) {
        return ResponseEntity.ok(intervieweeService.getAllByInterviewId(interviewId).stream().map(intervieweeService::toDTO).collect(Collectors.toList()));
    }
   /* @GetMapping("/{id}")
    public ResponseEntity<IntervieweeResponse> getById(@PathVariable Long interviewId, @PathVariable Long id) {
        return ResponseEntity.ok(intervieweeService.toDTO(intervieweeService.getById(interviewId,id)));
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<IntervieweeResponse> update(@PathVariable Long interviewId, @PathVariable Long id, @RequestBody @Valid IntervieweeRequest dto) {
        return ResponseEntity.ok(intervieweeService.toDTO(intervieweeService.update(interviewId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long interviewId, @PathVariable Long id) {
        intervieweeService.delete(interviewId, id);
        return ResponseEntity.noContent().build();
    }


}

