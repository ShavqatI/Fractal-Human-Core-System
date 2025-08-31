package com.fractal.domain.recruitment.interview.evaluation.section.question.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.recruitment.interview.evaluation.section.question.InterviewEvaluationQuestion;
import com.fractal.domain.recruitment.interview.evaluation.section.question.answer.mapper.InterviewEvaluationAnswerMapperService;
import com.fractal.domain.recruitment.interview.evaluation.section.question.dto.InterviewEvaluationQuestionCompactResponse;
import com.fractal.domain.recruitment.interview.evaluation.section.question.dto.InterviewEvaluationQuestionRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.question.dto.InterviewEvaluationQuestionResponse;
import com.fractal.domain.testing.question.type.QuestionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InterviewEvaluationQuestionMapperServiceImpl implements InterviewEvaluationQuestionMapperService {

    private final StatusService statusService;
    private final InterviewEvaluationAnswerMapperService answerMapperService;
    private final QuestionTypeService questionTypeService;

    @Override
    public InterviewEvaluationQuestionResponse toDTO(InterviewEvaluationQuestion question) {
        return new InterviewEvaluationQuestionResponse(
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
    public InterviewEvaluationQuestionCompactResponse toCompactDTO(InterviewEvaluationQuestion question) {
        return new InterviewEvaluationQuestionCompactResponse(
                question.getId(),
                question.getText());
    }

    @Override
    public InterviewEvaluationQuestion toEntity(InterviewEvaluationQuestionRequest dto) {
        return mapToEntity(new InterviewEvaluationQuestion(),dto);
    }

    @Override
    public InterviewEvaluationQuestion toEntity(InterviewEvaluationQuestion question, InterviewEvaluationQuestionRequest dto) {
       return mapToEntity(question,dto);
    }

    private InterviewEvaluationQuestion mapToEntity(InterviewEvaluationQuestion question, InterviewEvaluationQuestionRequest dto) {
        question.setText(dto.text());
        question.setQuestionType(questionTypeService.getById(dto.questionTypeId()));
        dto.answers().forEach(answer-> question.addAnswer(answerMapperService.toEntity(answer)));
        question.setMaxSelectableOptions(dto.maxSelectableOptions());
        question.setStatus(statusService.getById(dto.statusId()));
        return question;

    }


}
