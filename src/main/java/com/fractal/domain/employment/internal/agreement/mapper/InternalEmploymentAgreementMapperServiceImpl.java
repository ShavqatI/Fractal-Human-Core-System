package com.fractal.domain.employment.internal.agreement.mapper;

import com.fractal.domain.agreement.resource.mapper.AgreementResourceMapperService;
import com.fractal.domain.agreement.type.AgreementTypeService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employment.internal.agreement.InternalEmploymentAgreement;
import com.fractal.domain.employment.internal.agreement.dto.InternalEmploymentAgreementRequest;
import com.fractal.domain.employment.internal.agreement.dto.InternalEmploymentAgreementResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InternalEmploymentAgreementMapperServiceImpl implements InternalEmploymentAgreementMapperService {
    private final AgreementTypeService agreementTypeService;
    private final AgreementResourceMapperService resourceMapperService;
    private final StatusService statusService;
    @Override
    public InternalEmploymentAgreementResponse toDTO(InternalEmploymentAgreement agreement) {
        return new InternalEmploymentAgreementResponse(
                agreement.getId(),
                agreementTypeService.toDTO(agreement.getAgreementType()),
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
    public InternalEmploymentAgreement toEntity(InternalEmploymentAgreementRequest dto) {
        return mapToEntity(new InternalEmploymentAgreement(),dto);
    }

    @Override
    public InternalEmploymentAgreement toEntity(InternalEmploymentAgreement agreement, InternalEmploymentAgreementRequest dto) {
       return mapToEntity(agreement,dto);
    }

    private InternalEmploymentAgreement mapToEntity(InternalEmploymentAgreement agreement, InternalEmploymentAgreementRequest dto) {
        agreementTypeService.getById(dto.agreementTypeId());
        agreement.setNumber(dto.number());
        agreement.setStartDate(dto.startDate());
        agreement.setEndDate(dto.endDate());
        agreement.setStatus(statusService.getById(dto.statusId()));
        dto.files().forEach(file-> agreement.addResource(resourceMapperService.toEntity(file,null)));
        return agreement;
    }

}
