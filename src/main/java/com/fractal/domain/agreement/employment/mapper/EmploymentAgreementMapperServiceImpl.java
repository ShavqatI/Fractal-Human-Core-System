package com.fractal.domain.agreement.employment.mapper;

import com.fractal.domain.agreement.resource.mapper.AgreementResourceMapperService;
import com.fractal.domain.agreement.type.AgreementTypeService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.agreement.employment.EmploymentAgreement;
import com.fractal.domain.agreement.employment.dto.EmploymentAgreementResponse;
import com.fractal.domain.agreement.employment.dto.EmploymentAgreementRequest;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class EmploymentAgreementMapperServiceImpl implements EmploymentAgreementMapperService {

    private final AgreementTypeService agreementTypeService;
    private final AgreementResourceMapperService resourceMapperService;
    private final StatusService statusService;
    private final CompensationComponentService compensationComponentService;

    @Override
    public EmploymentAgreementResponse toDTO(EmploymentAgreement agreement) {
        return new EmploymentAgreementResponse(
                agreement.getId(),
                agreementTypeService.toDTO(agreement.getAgreementType()),
                agreement.getDate(),
                agreement.getNumber(),
                agreement.getStartDate(),
                agreement.getEndDate(),
                statusService.toCompactDTO(agreement.getStatus()),
                Optional.ofNullable(agreement.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(resourceMapperService::toDTO)
                        .collect(Collectors.toList()),
                agreement.getCreatedDate(),
                agreement.getUpdatedDate()
        );
    }

    @Override
    public EmploymentAgreement toEntity(EmploymentAgreementRequest dto) {
        var  agreement = mapToEntity(new EmploymentAgreement(), dto);
        agreement.setStatus(statusService.getByCode("CREATED"));
        return agreement;
    }

    @Override
    public EmploymentAgreement toEntity(EmploymentAgreement agreement, EmploymentAgreementRequest dto) {
        return mapToEntity(agreement, dto);
    }

    private EmploymentAgreement mapToEntity(EmploymentAgreement agreement, EmploymentAgreementRequest dto) {
        agreement.setCompensationComponent(compensationComponentService.getById(dto.employmentId(), dto.compensationComponentId()));
        agreement.setAgreementType(agreementTypeService.getById(dto.agreementTypeId()));
        agreement.setDate(dto.date());
        agreement.setNumber(dto.number());
        agreement.setStartDate(dto.startDate());
        agreement.setEndDate(dto.endDate());
        dto.files().forEach(file -> agreement.addResource(resourceMapperService.toEntity(file, null)));
        return agreement;
    }

}
