package com.fractal.domain.employee_management.performance;

import com.fractal.domain.interview.Interview;
import com.fractal.domain.interview.dto.InterviewRequest;
import com.fractal.domain.interview.dto.InterviewResponse;

import java.util.List;


public interface PerformanceService {
    Interview create(InterviewRequest dto);

    List<Interview> getAll();

    Performance getById(Long id);

    Interview update(Long id, InterviewRequest dto);

    void deleteById(Long id);

    Performance save(Performance performance);

    InterviewResponse toDTO(Interview interview);

}
