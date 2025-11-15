package com.fractal.domain.recruitment.candidate.usecase.account;

import com.fractal.domain.authorization.mapping.user_candidate.UserCandidateMappingService;
import com.fractal.domain.authorization.mapping.user_candidate.dto.UserCandidateMappingRequest;
import com.fractal.domain.authorization.role.RoleService;
import com.fractal.domain.authorization.user.UserService;
import com.fractal.domain.authorization.user.dto.UserRequest;
import com.fractal.domain.authorization.user.role.dto.UserRoleRequest;
import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.employee_management.address.EmployeeAddress;
import com.fractal.domain.employee_management.address.mapper.EmployeeAddressMapperService;
import com.fractal.domain.employee_management.citizenship.mapper.EmployeeCitizenshipMapperService;
import com.fractal.domain.employee_management.contact.mapper.EmployeeContactMapperService;
import com.fractal.domain.employee_management.education.mapper.EmployeeEducationMapperService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.employee.resource.mapper.EmployeeResourceMapperService;
import com.fractal.domain.employee_management.employment.mapper.EmployeeEmploymentMapperService;
import com.fractal.domain.employee_management.identification_document.mapper.EmployeeIdentificationDocumentMapperService;
import com.fractal.domain.employee_management.language_skill.mapper.EmployeeLanguageSkillMapperService;
import com.fractal.domain.employee_management.military_service.mapper.EmployeeMilitaryServiceMapperService;
import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.dto.CandidateRequest;
import com.fractal.domain.recruitment.candidate.mapper.CandidateMapperService;
import com.fractal.domain.recruitment.candidate.usecase.account.dto.CandidateAccountRequest;
import com.fractal.domain.recruitment.candidate.usecase.account.dto.CandidateAccountResponse;
import com.fractal.security.PasswordGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateAccountServiceImpl implements CandidateAccountService {

    private final CandidateService candidateService;
    private final UserService userService;
    private final StatusService statusService;
    private final CandidateMapperService candidateMapperService;
    private final UserCandidateMappingService userCandidateMappingService;
    private final RoleService roleService;


    @Override
    @Transactional
    public Candidate create(CandidateAccountRequest dto) {
        var candidate = candidateService.save(candidateMapperService.toEntity(dto));
        var candidateContact = candidate.getContacts().stream().filter(contact -> contact.getContactType().getCode().equals("EMAIL")).findFirst().get();
        var password = PasswordGeneratorService.generate(8);
        var status = statusService.getByCode("ACTIVE");
        var user = userService.create(new UserRequest(candidateContact.getValue().toLowerCase(),password,List.of(new UserRoleRequest(roleService.getByCode("CANDIDATE").getId(),status.getId()))));
        userCandidateMappingService.create(new UserCandidateMappingRequest(user.getId(),candidate.getId(),status.getId()));
        return candidate;
    }

    @Override
    public CandidateAccountResponse toDTO(Candidate candidate) {
        return candidateMapperService.toAccountDTO(candidate);
    }
}
