package com.fractal.domain.employment.internal.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.internal.agreement.mapper.InternalEmploymentAgreementMapperService;
import com.fractal.domain.employment.internal.compensation_component.mapper.CompensationComponentMapperService;
import com.fractal.domain.employment.internal.dto.InternalEmploymentRequest;
import com.fractal.domain.employment.internal.dto.InternalEmploymentResponse;
import com.fractal.domain.employment.internal.dto.TerminationRequest;
import com.fractal.domain.employment.kind.EmploymentKindService;
import com.fractal.domain.employment.punishment.mapper.PunishmentMapperService;
import com.fractal.domain.employment.separation_reason.mapper.SeparationReasonMapperService;
import com.fractal.domain.employment.type.EmploymentTypeService;
import com.fractal.domain.organization_management.department.DepartmentService;
import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.organization_management.position.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InternalEmploymentMapperServiceImpl implements InternalEmploymentMapperService {

    private final InternalEmploymentAgreementMapperService agreementMapperService;
    private final OrganizationService organizationService;
    private final DepartmentService departmentService;
    private final PositionService positionService;
    private final EmploymentTypeService employmentTypeService;
    private final StatusService statusService;
    private final SeparationReasonMapperService separationReasonMapperService;
    private final EmploymentKindService employmentKindService;
    private final CompensationComponentMapperService compensationComponentMapperService;
    private final PunishmentMapperService punishmentMapperService;


    @Override
    public InternalEmploymentResponse toDTO(InternalEmployment employment) {
       return new InternalEmploymentResponse(
                    employment.getId(),
                    employmentKindService.getByCode("INTERNAL").getCode(),
                    employment.getStartDate(),
                    employment.getEndDate(),
                    organizationService.toCompactDTO(employment.getOrganization()),
                    departmentService.toCompactDTO(employment.getDepartment()),
                    positionService.toCompactDTO(employment.getPosition()),
                    employmentTypeService.toCompactDTO(employment.getEmploymentType()),
                    Optional.ofNullable(employment.getAgreements())
                            .orElse(emptyList())
                            .stream()
                            .map(agreementMapperService::toDTO)
                            .collect(Collectors.toList()),
                    Optional.ofNullable(employment.getSeparationReasons())
                            .orElse(emptyList())
                            .stream()
                            .map(separationReasonMapperService::toDTO)
                            .collect(Collectors.toList()),
                    Optional.ofNullable(employment.getCompensationComponents())
                            .orElse(emptyList())
                            .stream()
                            .map(compensationComponentMapperService::toDTO)
                            .collect(Collectors.toList()),
                    statusService.toCompactDTO(employment.getStatus()),
                    employment.getCreatedDate(),
                    employment.getUpdatedDate()
            );


    }
    @Override
    public InternalEmployment toEntity(InternalEmploymentRequest dto) {
        var employment = mapToEntity(new InternalEmployment(), dto);
        employment.setStatus(statusService.getByCode("CREATED"));
        return employment;
    }

    @Override
    public InternalEmployment toEntity(InternalEmployment employment, InternalEmploymentRequest dto) {
        return mapToEntity(employment, dto);
    }

    @Override
    public InternalEmployment toEntity(InternalEmployment employment, TerminationRequest dto) {
        employment.setEndDate(dto.endDate());
        employment.setStatus(statusService.getByCode("CREATED"));
        dto.separationReasons().forEach(separationReason -> employment.addSeparationReason(separationReasonMapperService.toEntity(separationReason)));
        return employment;
    }

    @Override
    public InternalEmployment copy(InternalEmployment employment) {
        return InternalEmployment.builder()
                    .id(employment.getId())
                    .employmentType(employment.getEmploymentType())
                    .startDate(employment.getStartDate())
                    .endDate(employment.getEndDate())
                    .status(employment.getStatus())
                    .createdUser(employment.getCreatedUser())
                    .createdDate(employment.getCreatedDate())
                    .updatedUser(employment.getUpdatedUser())
                    .updatedDate(employment.getUpdatedDate())
                    .organization(employment.getOrganization())
                    .department(employment.getDepartment())
                    .position(employment.getPosition())
                    .agreements(employment.getAgreements())
                    .reviewedUser(employment.getReviewedUser())
                    .reviewedDate(employment.getReviewedDate())
                    .approvedUser(employment.getApprovedUser())
                    .approvedDate(employment.getApprovedDate())
                    .states(employment.getStates())
                    .build();

    }

    private InternalEmployment mapToEntity(InternalEmployment employment, InternalEmploymentRequest dto) {
        employment.setStartDate(dto.startDate());
        employment.setEndDate(dto.endDate());
        employment.setOrganization(organizationService.getById(dto.organizationId()));
        employment.setDepartment(departmentService.getById(dto.departmentId()));
        employment.setPosition(positionService.getById(dto.positionId()));
        employment.setEmploymentType(employmentTypeService.getById(dto.employmentTypeId()));

        dto.agreements().forEach(agreementRequest -> employment.addAgreement(agreementMapperService.toEntity(agreementRequest)));
        dto.separationReasons().forEach(separationReason -> employment.addSeparationReason(separationReasonMapperService.toEntity(separationReason)));
        dto.compensationComponents().forEach(compensationComponent -> employment.addCompensationComponent(compensationComponentMapperService.toEntity(compensationComponent)));
        dto.punishments().forEach(punishment -> employment.addPunishment(punishmentMapperService.toEntity(punishment)));
        return employment;
    }
}
