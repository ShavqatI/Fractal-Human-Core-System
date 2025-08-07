package com.fractal.domain.organization_management.grade.mapper;

import com.fractal.domain.dictionary.currency.CurrencyService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.organization_management.grade.Grade;
import com.fractal.domain.organization_management.grade.dto.GradeRequest;
import com.fractal.domain.organization_management.grade.dto.GradeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GradeMapperServiceImpl implements GradeMapperService {

    private final CurrencyService currencyService;
    private final StatusService statusService;


    @Override
    public GradeResponse toDTO(Grade grade) {
        return new GradeResponse(
                grade.getId(),
                grade.getCode(),
                grade.getName(),
                currencyService.toCompactDTO(grade.getCurrency()),
                grade.getMinSalary(),
                grade.getMaxSalary(),
                grade.getStartDate(),
                grade.getEndDate(),
                statusService.toCompactDTO(grade.getStatus()),
                grade.getNotes(),
                grade.getCreatedDate(),
                grade.getUpdatedDate()
        );
    }

    @Override
    public Grade toEntity(GradeRequest dto) {
        return mapToEntity(new Grade(),dto);
    }

    @Override
    public Grade toEntity(Grade grade, GradeRequest dto) {
        return mapToEntity(grade,dto);
    }

    private Grade mapToEntity(Grade grade, GradeRequest dto) {
        grade.setCode(dto.code());
        grade.setName(dto.name());
        grade.setCurrency(currencyService.getById(dto.currencyId()));
        grade.setMinSalary(dto.minSalary());
        grade.setMaxSalary(dto.maxSalary());
        grade.setStartDate(dto.startDate());
        grade.setEndDate(dto.endDate());
        grade.setStatus(statusService.getById(dto.statusId()));
        grade.setNotes(dto.notes());
        return grade;
    }

}
