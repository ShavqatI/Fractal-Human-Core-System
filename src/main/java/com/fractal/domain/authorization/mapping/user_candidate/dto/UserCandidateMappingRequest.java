package com.fractal.domain.authorization.mapping.user_candidate.dto;

import jakarta.validation.constraints.NotNull;

public record UserCandidateMappingRequest(
        @NotNull
        Long userId,
        @NotNull
        Long candidateId,
        Long statusId
) {

}
