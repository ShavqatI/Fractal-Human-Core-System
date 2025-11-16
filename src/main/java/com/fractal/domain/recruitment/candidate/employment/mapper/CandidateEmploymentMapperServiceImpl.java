package com.fractal.domain.recruitment.candidate.employment.mapper;

import com.fractal.domain.employment.external.ExternalEmployment;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.employment.external.dto.ExternalEmploymentResponse;
import com.fractal.domain.employment.external.mapper.ExternalEmploymentMapperService;
import com.fractal.domain.recruitment.candidate.employment.CandidateEmployment;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateEmploymentMapperServiceImpl implements CandidateEmploymentMapperService {

    private final ExternalEmploymentMapperService employmentMapperService;

    @Override
    public ExternalEmploymentResponse toDTO(CandidateEmployment employment) {
        return employmentMapperService.toDTO((ExternalEmployment) Hibernate.unproxy(employment.getEmployment()));
    }

    @Override
    public CandidateEmployment toEntity(ExternalEmploymentRequest dto) {
        return mapToEntity(new CandidateEmployment(), dto);
    }

    @Override
    public CandidateEmployment toEntity(CandidateEmployment employment, ExternalEmploymentRequest dto) {
        return mapToEntity(employment, dto);
    }

    private CandidateEmployment mapToEntity(CandidateEmployment employment, ExternalEmploymentRequest dto) {
        employment.setEmployment(employmentMapperService.toEntity(dto));
        return employment;
    }


}
