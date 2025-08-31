package com.fractal.domain.recruitment.interview.evaluation.section.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.recruitment.interview.evaluation.section.InterviewEvaluationSection;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionCompactResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.question.mapper.InterviewEvaluationQuestionMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InterviewEvaluationSectionMapperServiceImpl implements InterviewEvaluationSectionMapperService {

    private final StatusService statusService;
    private final InterviewEvaluationQuestionMapperService questionMapperService;

    @Override
    public InterviewEvaluationSectionResponse toDTO(InterviewEvaluationSection section) {
        return new InterviewEvaluationSectionResponse(
                section.getId(),
                section.getCode(),
                section.getName(),
                Optional.ofNullable(section.getQuestions())
                        .orElse(emptyList())
                        .stream()
                        .map(questionMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(section.getChildren())
                        .orElse(emptyList())
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(section.getStatus()),
                section.getCreatedDate()
        );
    }

    @Override
    public InterviewEvaluationSectionCompactResponse toCompactDTO(InterviewEvaluationSection section) {
        return new InterviewEvaluationSectionCompactResponse(
                section.getId(),
                section.getCode(),
                section.getName()
        );
    }

    @Override
    public InterviewEvaluationSection toEntity(InterviewEvaluationSectionRequest dto) {
        return mapToEntity(new InterviewEvaluationSection(),dto);
    }

    @Override
    public InterviewEvaluationSection toEntity(InterviewEvaluationSection section, InterviewEvaluationSectionRequest dto) {
       return mapToEntity(section,dto);
    }

    private InterviewEvaluationSection mapToEntity(InterviewEvaluationSection section, InterviewEvaluationSectionRequest dto) {
        section.setCode(dto.code());
        section.setName(dto.name());
        dto.questions().forEach(question-> section.addQuestion(questionMapperService.toEntity(question)));
        dto.children().forEach(child-> section.addChild(toEntity(child)));
        section.setStatus(statusService.getById(dto.statusId()));
        return section;

    }


}
