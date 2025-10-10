/*
package com.fractal.domain.interview.template.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.interview.template.InterviewTemplate;
import com.fractal.domain.interview.template.dto.InterviewTemplateRequest;
import com.fractal.domain.interview.template.dto.InterviewTemplateResponse;
import com.fractal.domain.interview.template.section.mapper.InterviewTemplateSectionMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InterviewTemplateMapperServiceImpl implements InterviewTemplateMapperService {

    private final StatusService statusService;
    private final InterviewTemplateSectionMapperService sectionMapperService;

    @Override
    public InterviewTemplateResponse toDTO(InterviewTemplate evaluation) {
        return new InterviewTemplateResponse(
                evaluation.getId(),
                evaluation.getCode(),
                evaluation.getName(),
                Optional.ofNullable(evaluation.getSections())
                        .orElse(emptyList())
                        .stream()
                        .map(sectionMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(evaluation.getStatus()),
                evaluation.getCreatedDate()
        );
    }
    @Override
    public InterviewTemplate toEntity(InterviewTemplateRequest dto) {
        return mapToEntity(new InterviewTemplate(),dto);
    }

    @Override
    public InterviewTemplate toEntity(InterviewTemplate evaluation, InterviewTemplateRequest dto) {
       return mapToEntity(evaluation,dto);
    }

    private InterviewTemplate mapToEntity(InterviewTemplate evaluation, InterviewTemplateRequest dto) {
        evaluation.setCode(dto.code());
        evaluation.setName(dto.name());
        dto.sections().forEach(section-> evaluation.addSection(sectionMapperService.toEntity(section)));
        evaluation.setStatus(statusService.getById(dto.statusId()));
        return evaluation;

    }


}
*/
