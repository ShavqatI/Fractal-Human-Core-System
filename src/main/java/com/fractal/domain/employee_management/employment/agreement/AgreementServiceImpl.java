package com.fractal.domain.employee_management.employment.agreement;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementRequest;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementResponse;
import com.fractal.domain.employee_management.employment.agreement.resource.AgreementResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class AgreementServiceImpl implements AgreementService {

    private final StatusService statusService;
    private final AgreementResourceService resourceService;

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
                        .map(resourceService::toDTO)
                        .collect(Collectors.toList()),
                agreement.getCreatedDate(),
                agreement.getUpdatedDate()
        );
    }

    @Override
    public Agreement toEntity(AgreementRequest dto) {
        var agreement = Agreement.builder()
                .number(dto.number())
                .startDate(dto.startDate())
                .endDate(dto.endDate())
                .status(statusService.getById(dto.statusId()))
                .build();
        dto.files().forEach(file-> agreement.addResource(resourceService.toEntity(file,null)));
      return agreement;
    }
}
