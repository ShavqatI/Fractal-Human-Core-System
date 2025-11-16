package com.fractal.domain.organization_management.grade.band.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.organization_management.grade.band.GradeSalaryBand;
import com.fractal.domain.organization_management.grade.band.dto.GradeSalaryBandRequest;
import com.fractal.domain.organization_management.grade.band.dto.GradeSalaryBandResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GradeSalaryBandMapperServiceImpl implements GradeSalaryBandMapperService {


    private final StatusService statusService;


    @Override
    public GradeSalaryBandResponse toDTO(GradeSalaryBand salaryBand) {
        return new GradeSalaryBandResponse(
                salaryBand.getId(),
                salaryBand.getMinSalary(),
                salaryBand.getAverageSalary(),
                salaryBand.getMaxSalary(),
                statusService.toCompactDTO(salaryBand.getStatus()),
                salaryBand.getCreatedDate()

        );
    }

    @Override
    public GradeSalaryBand toEntity(GradeSalaryBandRequest dto) {
        return mapToEntity(new GradeSalaryBand(), dto);
    }

    @Override
    public GradeSalaryBand toEntity(GradeSalaryBand salaryBand, GradeSalaryBandRequest dto) {
        return mapToEntity(salaryBand, dto);
    }

    private GradeSalaryBand mapToEntity(GradeSalaryBand salaryBand, GradeSalaryBandRequest dto) {
        salaryBand.setStatus(statusService.getById(dto.statusId()));
        salaryBand.setMinSalary(dto.minSalary());
        salaryBand.setAverageSalary(dto.averageSalary());
        salaryBand.setMaxSalary(dto.maxSalary());
        return salaryBand;
    }

}
