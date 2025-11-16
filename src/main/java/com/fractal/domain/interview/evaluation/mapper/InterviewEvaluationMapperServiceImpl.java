package com.fractal.domain.interview.evaluation.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.interview.evaluation.InterviewEvaluation;
import com.fractal.domain.interview.evaluation.dto.InterviewEvaluationRequest;
import com.fractal.domain.interview.evaluation.dto.InterviewEvaluationResponse;
import com.fractal.domain.interview.evaluation.section.mapper.InterviewEvaluationSectionMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InterviewEvaluationMapperServiceImpl implements InterviewEvaluationMapperService {

    private final StatusService statusService;
    private final InterviewEvaluationSectionMapperService sectionMapperService;

    @Override
    public InterviewEvaluationResponse toDTO(InterviewEvaluation evaluation) {
        return new InterviewEvaluationResponse(
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
    public InterviewEvaluation toEntity(InterviewEvaluationRequest dto) {
        return mapToEntity(new InterviewEvaluation(), dto);
    }

    @Override
    public InterviewEvaluation toEntity(InterviewEvaluation evaluation, InterviewEvaluationRequest dto) {
        return mapToEntity(evaluation, dto);
    }

    private InterviewEvaluation mapToEntity(InterviewEvaluation evaluation, InterviewEvaluationRequest dto) {
        evaluation.setCode(dto.code());
        evaluation.setName(dto.name());
        dto.sections().forEach(section -> evaluation.addSection(sectionMapperService.toEntity(section)));
        evaluation.setStatus(statusService.getById(dto.statusId()));
        return evaluation;

    }


}
