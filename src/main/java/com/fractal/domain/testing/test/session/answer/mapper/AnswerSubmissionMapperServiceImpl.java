package com.fractal.domain.testing.test.session.answer.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.testing.question.QuestionService;
import com.fractal.domain.testing.test.session.answer.AnswerSubmission;
import com.fractal.domain.testing.test.session.answer.dto.AnswerSubmissionRequest;
import com.fractal.domain.testing.test.session.answer.dto.AnswerSubmissionResponse;
import com.fractal.domain.testing.test.session.answer.selected.mapper.SelectedAnswerMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class AnswerSubmissionMapperServiceImpl implements AnswerSubmissionMapperService {

    private final SelectedAnswerMapperService answerMapperService;
    private final QuestionService questionService;
    private final StatusService statusService;
    @Override
    public AnswerSubmissionResponse toDTO(AnswerSubmission submission) {
        return new AnswerSubmissionResponse(
                submission.getId(),
                questionService.toCompactDTO(submission.getQuestion()),
                Optional.ofNullable(submission.getSelectedAnswers())
                        .orElse(emptyList())
                        .stream()
                        .map(answerMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(submission.getStatus()),
                submission.getCreatedDate()

        );
    }

    @Override
    public AnswerSubmission toEntity(AnswerSubmissionRequest dto) {
        return mapToEntity(new AnswerSubmission(), dto);
    }

    @Override
    public AnswerSubmission toEntity(AnswerSubmission submission, AnswerSubmissionRequest dto) {
        return mapToEntity(submission, dto);
    }

    private AnswerSubmission mapToEntity(AnswerSubmission submission, AnswerSubmissionRequest dto) {
        submission.setQuestion(questionService.getById(dto.questionId()));
        submission.setStatus(statusService.getById(dto.statusId()));
        dto.answers().forEach(answer-> submission.addAnswer(answerMapperService.toEntity(answer)));
        return submission;
    }
}
