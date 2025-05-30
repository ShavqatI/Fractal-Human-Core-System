package com.fractal.domain.employee_management.employment.agreement;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementRequest;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AgreementServiceImpl implements AgreementService {

    private final StatusService statusService;

    @Override
    public AgreementResponse toDTO(Agreement agreement) {
        return new AgreementResponse(
                agreement.getId(),
                agreement.getNumber(),
                agreement.getStartDate(),
                agreement.getEndDate(),
                agreement.getStatus().getName(),
                agreement.getCreatedDate(),
                agreement.getUpdatedDate()
        );
    }

    @Override
    public Agreement toEntity(AgreementRequest dto) {
        return Agreement.builder()
                .number(dto.number())
                .startDate(dto.startDate())
                .endDate(dto.endDate())
                .status(statusService.getById(dto.statusId()))
                .build();
    }
}
