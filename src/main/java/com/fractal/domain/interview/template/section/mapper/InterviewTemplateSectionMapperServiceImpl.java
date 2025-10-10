/*
package com.fractal.domain.interview.template.section.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.interview.template.section.InterviewTemplateSection;
import com.fractal.domain.interview.template.section.dto.InterviewTemplateSectionCompactResponse;
import com.fractal.domain.interview.template.section.dto.InterviewTemplateSectionRequest;
import com.fractal.domain.interview.template.section.dto.InterviewTemplateSectionResponse;
import com.fractal.domain.interview.template.section.question.mapper.InterviewTemplateQuestionMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InterviewTemplateSectionMapperServiceImpl implements InterviewTemplateSectionMapperService {

    private final StatusService statusService;
    private final InterviewTemplateQuestionMapperService questionMapperService;

    @Override
    public InterviewTemplateSectionResponse toDTO(InterviewTemplateSection section) {
        return new InterviewTemplateSectionResponse(
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
    public InterviewTemplateSectionCompactResponse toCompactDTO(InterviewTemplateSection section) {
        return new InterviewTemplateSectionCompactResponse(
                section.getId(),
                section.getCode(),
                section.getName()
        );
    }

    @Override
    public InterviewTemplateSection toEntity(InterviewTemplateSectionRequest dto) {
        return mapToEntity(new InterviewTemplateSection(),dto);
    }

    @Override
    public InterviewTemplateSection toEntity(InterviewTemplateSection section, InterviewTemplateSectionRequest dto) {
       return mapToEntity(section,dto);
    }

    private InterviewTemplateSection mapToEntity(InterviewTemplateSection section, InterviewTemplateSectionRequest dto) {
        section.setCode(dto.code());
        section.setName(dto.name());
        dto.questions().forEach(question-> section.addQuestion(questionMapperService.toEntity(question)));
        dto.children().forEach(child-> section.addChild(toEntity(child)));
        section.setStatus(statusService.getById(dto.statusId()));
        return section;

    }


}
*/
