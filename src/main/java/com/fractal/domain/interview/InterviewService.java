package com.fractal.domain.interview;

import com.fractal.domain.interview.dto.InterviewRequest;
import com.fractal.domain.interview.dto.InterviewResponse;

import java.util.List;


public interface InterviewService {
    Interview create(InterviewRequest dto);
    List<Interview> getAll();
    Interview getById(Long id);
    Interview update(Long id, InterviewRequest dto);
    void deleteById(Long id);
    Interview save(Interview interview);
    InterviewResponse toDTO(Interview interview);

}
