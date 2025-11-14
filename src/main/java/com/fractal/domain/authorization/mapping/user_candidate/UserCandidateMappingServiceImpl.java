package com.fractal.domain.authorization.mapping.user_candidate;

import com.fractal.domain.authorization.mapping.user_candidate.dto.UserCandidateMappingRequest;
import com.fractal.domain.authorization.mapping.user_candidate.dto.UserCandidateMappingResponse;
import com.fractal.domain.authorization.user.UserService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class UserCandidateMappingServiceImpl implements UserCandidateMappingService {

    private final UserCandidateMappingRepository userCandidateMappingRepository;
    private final UserService userService;
    private final CandidateService candidateService;
    private final StatusService statusService;

    @Override
    public UserCandidateMapping create(UserCandidateMappingRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<UserCandidateMapping> getAll() {
        return userCandidateMappingRepository.findAll();
    }


    @Override
    public UserCandidateMapping getById(Long id) {
        return findById(id);
    }

    @Override
    public UserCandidateMapping update(Long id, UserCandidateMappingRequest dto) {
        try {
            UserCandidateMapping userCandidateMapping = findById(id);
            userCandidateMapping.setUser(userService.getById(dto.userId()));
            userCandidateMapping.setCandidate(candidateService.getById(dto.candidateId()));
            userCandidateMapping.setStatus(statusService.getById(dto.statusId()));
            return save(userCandidateMapping);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        userCandidateMappingRepository.delete(findById(id));
    }

    @Override
    public UserCandidateMappingResponse toDTO(UserCandidateMapping userCandidateMapping) {
        return new UserCandidateMappingResponse(
                userCandidateMapping.getId(),
                userCandidateMapping.getUser().getUsername(),
                candidateService.toCompactDTO(userCandidateMapping.getCandidate()),
                statusService.toCompactDTO(userCandidateMapping.getStatus()),
                userCandidateMapping.getCreatedDate()
        );
    }

    private UserCandidateMapping toEntity(UserCandidateMappingRequest dto) {
        return UserCandidateMapping.builder()
                .user(userService.getById(dto.userId()))
                .candidate(candidateService.getById(dto.candidateId()))
                .status(statusService.getById(dto.statusId()))
                .build();
    }

    private UserCandidateMapping save(UserCandidateMapping userCandidateMapping) {
        try {
            return userCandidateMappingRepository.save(userCandidateMapping);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private UserCandidateMapping findById(Long id) {
        return userCandidateMappingRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("UserEmployeeMapping  with id: " + id + " not found"));
    }
}
