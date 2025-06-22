package com.fractal.domain.employee_management.employment.agreement.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employment.agreement.Agreement;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementRequest;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementResponse;
import com.fractal.domain.employee_management.employment.agreement.resource.mapper.AgreementResourceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class AgreementMapperServiceImpl implements AgreementMapperService {

    private final AgreementResourceMapperService resourceMapperService;
    private final StatusService statusService;
    @Override
    public AgreementResponse toDTO(Agreement agreement) {
        return new AgreementResponse(
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
    public Agreement toEntity(AgreementRequest dto) {
        return mapToEntity(new Agreement(),dto);
    }

    @Override
    public Agreement toEntity(Agreement agreement, AgreementRequest dto) {
       return mapToEntity(agreement,dto);
    }

    private Agreement mapToEntity(Agreement agreement, AgreementRequest dto) {
        agreement.setNumber(dto.number());
        agreement.setStartDate(dto.startDate());
        agreement.setEndDate(dto.endDate());
        agreement.setStatus(statusService.getById(dto.statusId()));
        dto.files().forEach(file-> agreement.addResource(resourceMapperService.toEntity(file,null)));
        return agreement;
    }

}
