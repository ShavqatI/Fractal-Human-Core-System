package com.fractal.domain.recruitment.candidate.usecase.profile;

import com.fractal.domain.authorization.mapping.user_candidate.UserCandidateMappingService;
import com.fractal.domain.authorization.mapping.user_candidate.dto.UserCandidateMappingRequest;
import com.fractal.domain.authorization.role.RoleService;
import com.fractal.domain.authorization.user.UserService;
import com.fractal.domain.authorization.user.dto.UserRequest;
import com.fractal.domain.authorization.user.role.dto.UserRoleRequest;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.mapper.CandidateMapperService;
import com.fractal.domain.recruitment.candidate.usecase.profile.dto.CandidateProfileRequest;
import com.fractal.domain.recruitment.candidate.usecase.profile.dto.CandidateProfileResponse;
import com.fractal.security.PasswordGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateProfileServiceImpl implements CandidateProfileService {

    private final CandidateService candidateService;
    private final UserService userService;
    private final StatusService statusService;
    private final CandidateMapperService candidateMapperService;
    private final UserCandidateMappingService userCandidateMappingService;
    private final RoleService roleService;


    @Override
    @Transactional
    public Candidate create(CandidateProfileRequest dto) {
        var candidate = candidateService.save(candidateMapperService.toEntity(dto));
        var candidateContact = candidate.getContacts().stream().filter(contact -> contact.getContactType().getCode().equals("EMAIL")).findFirst().get();
        var password = PasswordGeneratorService.generate(8);
        var status = statusService.getByCode("ACTIVE");
        var user = userService.create(new UserRequest(candidateContact.getValue().toLowerCase(), password, List.of(new UserRoleRequest(roleService.getByCode("CANDIDATE").getId(), status.getId()))));
        userCandidateMappingService.create(new UserCandidateMappingRequest(user.getId(), candidate.getId(), status.getId()));
        return candidate;
    }

    @Override
    public CandidateProfileResponse toDTO(Candidate candidate) {
        return candidateMapperService.toAccountDTO(candidate);
    }
}
