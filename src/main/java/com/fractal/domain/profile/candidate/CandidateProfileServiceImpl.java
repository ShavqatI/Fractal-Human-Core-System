package com.fractal.domain.profile.candidate;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.authorization.mapping.user_candidate.UserCandidateMappingService;
import com.fractal.domain.authorization.mapping.user_candidate.dto.UserCandidateMappingRequest;
import com.fractal.domain.authorization.role.RoleService;
import com.fractal.domain.authorization.user.UserService;
import com.fractal.domain.authorization.user.dto.UserRequest;
import com.fractal.domain.authorization.user.role.dto.UserRoleRequest;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.profile.candidate.dto.CandidateProfileCreateRequest;
import com.fractal.domain.profile.candidate.dto.CandidateProfileResponse;
import com.fractal.domain.profile.candidate.dto.CandidateProfileUpdateRequest;
import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;
import com.fractal.domain.recruitment.candidate.mapper.CandidateMapperService;
import com.fractal.security.PasswordGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateProfileServiceImpl implements CandidateProfileService {

    private final CandidateService candidateService;
    private final AuthenticatedService authenticatedService;
    private final UserService userService;
    private final StatusService statusService;
    private final CandidateMapperService candidateMapperService;
    private final UserCandidateMappingService userCandidateMappingService;
    private final RoleService roleService;


    @Override
    @Transactional
    public Candidate create(CandidateProfileCreateRequest dto) {
        var candidate = candidateService.save(candidateMapperService.toEntity(dto));
        var candidateContact = candidate.getContacts().stream().filter(contact -> contact.getContactType().getCode().equals("EMAIL")).findFirst().get();
        var password = PasswordGeneratorService.generate(8);
        var status = statusService.getByCode("ACTIVE");
        var user = userService.create(new UserRequest(candidateContact.getValue().toLowerCase(), password, List.of(new UserRoleRequest(roleService.getByCode("CANDIDATE").getId(), status.getId()))));
        userCandidateMappingService.create(new UserCandidateMappingRequest(user.getId(), candidate.getId(), status.getId()));
        return candidate;
    }

    @Override
    public Candidate getById() {
        return candidateService.getById(authenticatedService.getCandidateId());
    }

    @Override
    public Candidate update(CandidateProfileUpdateRequest dto) {
        var candidate = candidateService.getById(authenticatedService.getCandidateId());
        var updatedCandidate = candidateMapperService.toEntity(candidate,dto);
        return candidateService.save(updatedCandidate);
    }

    @Override
    public CandidateResponse toDTO(Candidate candidate) {
        return candidateService.toDTO(candidate);
    }

    @Override
    public CandidateCompactResponse toCompactDTO(Candidate candidate) {
        return candidateService.toCompactDTO(candidate);
    }

    @Override
    public CandidateProfileResponse toProfileDTO(Candidate candidate) {
        return candidateMapperService.toProfileDTO(candidate);
    }
}
