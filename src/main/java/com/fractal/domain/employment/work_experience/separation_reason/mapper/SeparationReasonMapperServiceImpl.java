package com.fractal.domain.employment.work_experience.separation_reason.mapper;

import com.fractal.domain.employment.separation_reason_type.SeparationReasonTypeService;
import com.fractal.domain.employment.work_experience.separation_reason.SeparationReason;
import com.fractal.domain.employment.work_experience.separation_reason.dto.SeparationReasonRequest;
import com.fractal.domain.employment.work_experience.separation_reason.dto.SeparationReasonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SeparationReasonMapperServiceImpl implements SeparationReasonMapperService {

    private final SeparationReasonTypeService separationReasonTypeService;

    @Override
    public SeparationReasonResponse toDTO(SeparationReason separationReason) {
        return new SeparationReasonResponse(
                separationReason.getId(),
                separationReasonTypeService.toCompactDTO(separationReason.getSeparationReasonType()),
                separationReason.getCreatedDate()
        );
    }
    @Override
    public SeparationReason toEntity(SeparationReasonRequest dto) {
        return mapToEntity(new SeparationReason(),dto);
    }

    @Override
    public SeparationReason toEntity(SeparationReason separationReason, SeparationReasonRequest dto) {
       return mapToEntity(separationReason,dto);
    }

    private SeparationReason mapToEntity(SeparationReason separationReason, SeparationReasonRequest dto) {
        separationReason.setSeparationReasonType(separationReasonTypeService.getById(dto.separationReasonTypeId()));
        return separationReason;

    }


}
