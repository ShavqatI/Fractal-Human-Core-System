package com.fractal.domain.employment.external.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.external.ExternalEmployment;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.employment.external.dto.ExternalEmploymentResponse;
import com.fractal.domain.employment.kind.EmploymentKindService;
import com.fractal.domain.employment.separation_reason.mapper.SeparationReasonMapperService;
import com.fractal.domain.employment.type.EmploymentTypeService;
import com.fractal.domain.location.country.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class ExternalEmploymentMapperServiceImpl implements ExternalEmploymentMapperService {

    private final CountryService countryService;
    private final StatusService statusService;
    private final EmploymentTypeService employmentTypeService;
    private final SeparationReasonMapperService separationReasonMapperService;
    private final EmploymentKindService employmentKindService;
    @Override
    public ExternalEmploymentResponse toDTO(ExternalEmployment employment) {
        return new ExternalEmploymentResponse(
                employment.getId(),
                employmentKindService.getByCode("EXTERNAL").getCode(),
                countryService.toCompactDTO(employment.getCountry()),
                employment.getLocation(),
                employmentTypeService.toCompactDTO(employment.getEmploymentType()),
                employment.getStartDate(),
                employment.getEndDate(),
                employment.getOrganization(),
                employment.getDepartment(),
                employment.getDivision(),
                employment.getPosition(),
                employment.getResponsibilities(),
                employment.getAchievements(),
                Optional.ofNullable(employment.getSeparationReasons())
                        .orElse(emptyList())
                        .stream()
                        .map(separationReasonMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(employment.getStatus()),
                employment.getCreatedDate()
        );
    }
    @Override
    public ExternalEmployment toEntity(ExternalEmploymentRequest dto) {
        return mapToEntity(new ExternalEmployment(), dto);
    }

    @Override
    public ExternalEmployment toEntity(ExternalEmployment employment, ExternalEmploymentRequest dto) {
        return mapToEntity(employment, dto);
    }

    @Override
    public Employment copy(ExternalEmployment employment) {
        var externalEmployment = ExternalEmployment.builder().build();
        externalEmployment.setCountry(employment.getCountry());
        externalEmployment.setLocation(employment.getLocation());
        externalEmployment.setEmploymentType(employment.getEmploymentType());
        externalEmployment.setStartDate(employment.getStartDate());
        externalEmployment.setEndDate(employment.getEndDate());
        externalEmployment.setOrganization(employment.getOrganization());
        externalEmployment.setDepartment(employment.getDepartment());
        externalEmployment.setDivision(employment.getDivision());
        externalEmployment.setPosition(employment.getPosition());
        externalEmployment.setResponsibilities(employment.getResponsibilities());
        externalEmployment.setAchievements(employment.getAchievements());
        externalEmployment.setStatus(employment.getStatus());
        externalEmployment.getSeparationReasons().forEach(separationReason -> externalEmployment.addSeparationReason(separationReason));
        return externalEmployment;
    }

    private ExternalEmployment mapToEntity(ExternalEmployment employment, ExternalEmploymentRequest dto) {
        employment.setCountry(countryService.getById(dto.countryId()));
        employment.setLocation(dto.location());
        employment.setEmploymentType(employmentTypeService.getById(dto.employmentTypeId()));
        employment.setStartDate(dto.startDate());
        employment.setEndDate(dto.endDate());
        employment.setOrganization(dto.organization());
        employment.setDepartment(dto.department());
        employment.setDivision(dto.division());
        employment.setPosition(dto.position());
        employment.setResponsibilities(dto.responsibilities());
        employment.setAchievements(dto.achievements());
        employment.setStatus(statusService.getById(dto.statusId()));
        dto.separationReasons().forEach(separationReason-> employment.addSeparationReason(separationReasonMapperService.toEntity(separationReason)));
        return employment;
    }
}
