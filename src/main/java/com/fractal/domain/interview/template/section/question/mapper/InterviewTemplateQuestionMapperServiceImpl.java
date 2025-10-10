/*
package com.fractal.domain.interview.template.section.question.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.interview.template.section.question.InterviewTemplateQuestion;
import com.fractal.domain.interview.template.section.question.answer.mapper.InterviewEvaluationAnswerMapperService;
import com.fractal.domain.interview.template.section.question.dto.InterviewTemplateQuestionCompactResponse;
import com.fractal.domain.interview.template.section.question.dto.InterviewTemplateQuestionRequest;
import com.fractal.domain.interview.template.section.question.dto.InterviewTemplateQuestionResponse;
import com.fractal.domain.testing.question.type.QuestionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InterviewTemplateQuestionMapperServiceImpl implements InterviewTemplateQuestionMapperService {

    private final StatusService statusService;
    private final InterviewEvaluationAnswerMapperService answerMapperService;
    private final QuestionTypeService questionTypeService;

    @Override
    public InterviewTemplateQuestionResponse toDTO(InterviewTemplateQuestion question) {
        return new InterviewTemplateQuestionResponse(
                question.getId(),
                question.getText(),
                questionTypeService.toDTO(question.getQuestionType()),
                Optional.ofNullable(question.getAnswers())
                        .orElse(emptyList())
                        .stream()
                        .map(answerMapperService::toDTO)
                        .collect(Collectors.toList()),
                question.getMaxSelectableOptions(),
                statusService.toCompactDTO(question.getStatus()),
                question.getCreatedDate()
        );
    }

    @Override
    public InterviewTemplateQuestionCompactResponse toCompactDTO(InterviewTemplateQuestion question) {
        return new InterviewTemplateQuestionCompactResponse(
                question.getId(),
                question.getText());
    }

    @Override
    public InterviewTemplateQuestion toEntity(InterviewTemplateQuestionRequest dto) {
        return mapToEntity(new InterviewTemplateQuestion(),dto);
    }

    @Override
    public InterviewTemplateQuestion toEntity(InterviewTemplateQuestion question, InterviewTemplateQuestionRequest dto) {
       return mapToEntity(question,dto);
    }

    private InterviewTemplateQuestion mapToEntity(InterviewTemplateQuestion question, InterviewTemplateQuestionRequest dto) {
        question.setText(dto.text());
        question.setQuestionType(questionTypeService.getById(dto.questionTypeId()));
        dto.answers().forEach(answer-> question.addAnswer(answerMapperService.toEntity(answer)));
        question.setMaxSelectableOptions(dto.maxSelectableOptions());
        question.setStatus(statusService.getById(dto.statusId()));
        return question;

    }


}
*/
