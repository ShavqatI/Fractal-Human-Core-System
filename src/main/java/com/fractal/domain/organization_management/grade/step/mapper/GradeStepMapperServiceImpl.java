package com.fractal.domain.organization_management.grade.step.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.organization_management.grade.step.GradeStep;
import com.fractal.domain.organization_management.grade.step.dto.GradeStepRequest;
import com.fractal.domain.organization_management.grade.step.dto.GradeStepResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GradeStepMapperServiceImpl implements GradeStepMapperService {


    private final StatusService statusService;


    @Override
    public GradeStepResponse toDTO(GradeStep step) {
        return new GradeStepResponse(
                step.getId(),
                step.getMinSalary(),
                step.getMaxSalary(),
                statusService.toCompactDTO(step.getStatus()),
                step.getCreatedDate()

        );
    }

    @Override
    public GradeStep toEntity(GradeStepRequest dto) {
        return mapToEntity(new GradeStep(),dto);
    }

    @Override
    public GradeStep toEntity(GradeStep step, GradeStepRequest dto) {
       return mapToEntity(step,dto);
    }

    private GradeStep mapToEntity(GradeStep step, GradeStepRequest dto) {
        step.setStatus(statusService.getById(dto.statusId()));
        step.setMinSalary(dto.minSalary());
        step.setMaxSalary(dto.maxSalary());
        return step;
    }

}
