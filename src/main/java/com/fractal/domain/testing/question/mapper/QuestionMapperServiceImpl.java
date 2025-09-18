package com.fractal.domain.testing.question.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.testing.question.Question;
import com.fractal.domain.testing.question.answer.mapper.AnswerMapperService;
import com.fractal.domain.testing.question.dto.QuestionCompactResponse;
import com.fractal.domain.testing.question.dto.QuestionRequest;
import com.fractal.domain.testing.question.dto.QuestionResponse;
import com.fractal.domain.testing.question.type.QuestionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class QuestionMapperServiceImpl implements QuestionMapperService {

    private final AnswerMapperService answerMapperService;
    private final QuestionTypeService questionTypeService;
    private final StatusService statusService;
    @Override
    public QuestionResponse toDTO(Question question) {
        return new QuestionResponse(
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
    public QuestionCompactResponse toCompactDTO(Question question) {
        return new QuestionCompactResponse(question.getId(),question.getText());
    }

    @Override
    public Question toEntity(QuestionRequest dto) {
        return mapToEntity(new Question(), dto);
    }

    @Override
    public Question toEntity(Question question, QuestionRequest dto) {
        return mapToEntity(question, dto);
    }

    private Question mapToEntity(Question question, QuestionRequest dto) {
        question.setText(dto.text());
        question.setQuestionType(questionTypeService.getById(dto.questionTypeId()));
        question.setMaxSelectableOptions(dto.maxSelectableOptions());
        question.setStatus(statusService.getById(dto.statusId()));
        dto.answers().forEach(answer-> question.addAnswer(answerMapperService.toEntity(answer)));
        return question;
    }
}
