package com.fractal.domain.vacation_management.request.responsibility.mapper;

import com.fractal.domain.vacation_management.request.responsibility.VacationRequestResponsibility;
import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityRequest;
import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class VacationRequestResponsibilityMapperServiceImpl implements VacationRequestResponsibilityMapperService {
    @Override
    public VacationRequestResponsibilityResponse toDTO(VacationRequestResponsibility responsibility) {
        return new VacationRequestResponsibilityResponse(
                responsibility.getId(),
                responsibility.getResponsibility(),
                responsibility.getCreatedDate()

        );
    }

    @Override
    public VacationRequestResponsibility toEntity(VacationRequestResponsibilityRequest dto) {
        return mapToEntity(new VacationRequestResponsibility(), dto);
    }

    @Override
    public VacationRequestResponsibility toEntity(VacationRequestResponsibility responsibility, VacationRequestResponsibilityRequest dto) {
        return mapToEntity(responsibility, dto);
    }

    private VacationRequestResponsibility mapToEntity(VacationRequestResponsibility responsibility, VacationRequestResponsibilityRequest dto) {
        responsibility.setResponsibility(dto.responsibility());
        return responsibility;
    }

}
