package com.fractal.domain.authorization.mapping.user_candidate;

import com.fractal.domain.authorization.mapping.user_candidate.dto.UserCandidateMappingRequest;
import com.fractal.domain.authorization.mapping.user_candidate.dto.UserCandidateMappingResponse;

import java.util.List;

public interface UserCandidateMappingService {

    UserCandidateMapping create(UserCandidateMappingRequest dto);

    List<UserCandidateMapping> getAll();

    UserCandidateMapping getById(Long id);

    UserCandidateMapping update(Long id, UserCandidateMappingRequest dto);

    void deleteById(Long id);

    UserCandidateMappingResponse toDTO(UserCandidateMapping userCandidateMapping);
}
