package com.fractal.domain.authorization.mapping.user_candidate;

import com.fractal.domain.authorization.mapping.user_candidate.dto.UserCandidateMappingRequest;
import com.fractal.domain.authorization.mapping.user_candidate.dto.UserCandidateMappingResponse;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.recruitment.candidate.Candidate;

import java.util.List;

public interface UserCandidateMappingService {

    UserCandidateMapping create(UserCandidateMappingRequest dto);
    List<UserCandidateMapping> getAll();
    UserCandidateMapping getById(Long id);
    Candidate getCandidate(User user);
    UserCandidateMapping update(Long id, UserCandidateMappingRequest dto);
    void deleteById(Long id);
    UserCandidateMappingResponse toDTO(UserCandidateMapping userCandidateMapping);
}
