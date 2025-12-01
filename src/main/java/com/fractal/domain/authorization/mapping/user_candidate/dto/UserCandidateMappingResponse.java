package com.fractal.domain.authorization.mapping.user_candidate.dto;

import com.fractal.domain.authorization.user.dto.UserCompactResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;

import java.time.LocalDateTime;

public record UserCandidateMappingResponse(
        Long id,
        UserCompactResponse username,
        CandidateCompactResponse candidate,
        StatusCompactResponse status,
        LocalDateTime createdDate

) {

}
