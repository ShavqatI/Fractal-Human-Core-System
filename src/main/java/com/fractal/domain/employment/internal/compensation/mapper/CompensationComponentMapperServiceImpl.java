package com.fractal.domain.employment.internal.compensation.mapper;

import com.fractal.domain.agreement.resource.mapper.AgreementResourceMapperService;
import com.fractal.domain.agreement.type.AgreementTypeService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employment.internal.compensation.CompensationComponent;
import com.fractal.domain.employment.internal.compensation.dto.CompensationComponentRequest;
import com.fractal.domain.employment.internal.compensation.dto.CompensationComponentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class CompensationComponentMapperServiceImpl implements CompensationComponentMapperService {
    private final AgreementTypeService agreementTypeService;
    private final AgreementResourceMapperService resourceMapperService;
    private final StatusService statusService;
    @Override
    public CompensationComponentResponse toDTO(CompensationComponent agreement) {
        return new CompensationComponentResponse(
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
    public CompensationComponent toEntity(CompensationComponentRequest dto) {
        return mapToEntity(new CompensationComponent(),dto);
    }

    @Override
    public CompensationComponent toEntity(CompensationComponent agreement, CompensationComponentRequest dto) {
       return mapToEntity(agreement,dto);
    }

    private CompensationComponent mapToEntity(CompensationComponent agreement, CompensationComponentRequest dto) {
        agreementTypeService.getById(dto.agreementTypeId());
        agreement.setNumber(dto.number());
        agreement.setStartDate(dto.startDate());
        agreement.setEndDate(dto.endDate());
        agreement.setStatus(statusService.getById(dto.statusId()));
        dto.files().forEach(file-> agreement.addResource(resourceMapperService.toEntity(file,null)));
        return agreement;
    }

}
