package com.fractal.domain.authorization.mapping.user_candidate.dto;

import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.employee_management.employee.dto.EmployeeCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;

import java.time.LocalDateTime;

public record UserCandidateMappingResponse(
        Long id,
        String username,
        CandidateCompactResponse candidate,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {

}
