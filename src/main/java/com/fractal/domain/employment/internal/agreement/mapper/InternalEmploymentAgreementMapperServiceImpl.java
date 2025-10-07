package com.fractal.domain.employment.internal.agreement.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employment.internal.agreement.InternalEmploymentAgreement;
import com.fractal.domain.employment.internal.agreement.dto.InternalEmploymentAgreementRequest;
import com.fractal.domain.employment.internal.agreement.dto.InternalEmploymentAgreementResponse;
import com.fractal.domain.employment.internal.agreement.resource.mapper.InternalEmploymentAgreementResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InternalEmploymentAgreementMapperServiceImpl implements InternalEmploymentAgreementMapperService {

    private final InternalEmploymentAgreementResourceMapperService resourceMapperService;
    private final StatusService statusService;
    @Override
    public InternalEmploymentAgreementResponse toDTO(InternalEmploymentAgreement agreement) {
        return new InternalEmploymentAgreementResponse(
                agreement.getId(),
                agreement.getNumber(),
                agreement.getStartDate(),
                agreement.getEndDate(),
                agreement.getStatus().getName(),
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

    private InternalEmploymentAgreement mapToEntity(InternalEmploymentAgreement internalEmploymentAgreement, InternalEmploymentAgreementRequest dto) {
        internalEmploymentAgreement.setNumber(dto.number());
        internalEmploymentAgreement.setStartDate(dto.startDate());
        internalEmploymentAgreement.setEndDate(dto.endDate());
        internalEmploymentAgreement.setStatus(statusService.getById(dto.statusId()));
        dto.files().forEach(file-> internalEmploymentAgreement.addResource(resourceMapperService.toEntity(file,null)));
        return internalEmploymentAgreement;
    }

}
