package com.fractal.domain.interview.evaluation.session.submission.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.interview.evaluation.session.submission.InterviewEvaluationSessionAnswerSubmission;
import com.fractal.domain.interview.evaluation.session.submission.dto.InterviewEvaluationSessionAnswerSubmissionCompactResponse;
import com.fractal.domain.interview.evaluation.session.submission.dto.InterviewEvaluationSessionAnswerSubmissionRequest;
import com.fractal.domain.interview.evaluation.session.submission.dto.InterviewEvaluationSessionAnswerSubmissionResponse;
import com.fractal.domain.interview.evaluation.session.submission.selected_answer.mapper.InterviewEvaluationSessionSelectedAnswerMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InterviewEvaluationSessionAnswerSubmissionMapperServiceImpl implements InterviewEvaluationSessionAnswerSubmissionMapperService {

    private final StatusService statusService;
    private final InterviewEvaluationSessionSelectedAnswerMapperService answerMapperService;


    @Override
    public InterviewEvaluationSessionAnswerSubmissionResponse toDTO(InterviewEvaluationSessionAnswerSubmission answerSubmission) {
        return new InterviewEvaluationSessionAnswerSubmissionResponse(
                answerSubmission.getId(),
                null,
                Optional.ofNullable(answerSubmission.getSelectedAnswers())
                        .orElse(emptyList())
                        .stream()
                        .map(answerMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(answerSubmission.getStatus()),
                answerSubmission.getCreatedDate()
        );
    }

    @Override
    public InterviewEvaluationSessionAnswerSubmissionCompactResponse toCompactDTO(InterviewEvaluationSessionAnswerSubmission answerSubmission) {
        return new InterviewEvaluationSessionAnswerSubmissionCompactResponse(
                answerSubmission.getId(),
                null,
                Optional.ofNullable(answerSubmission.getSelectedAnswers())
                        .orElse(emptyList())
                        .stream()
                        .map(answerMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(answerSubmission.getStatus()),
                answerSubmission.getCreatedDate()
        );
    }

    @Override
    public InterviewEvaluationSessionAnswerSubmission toEntity(InterviewEvaluationSessionAnswerSubmissionRequest dto) {
        return mapToEntity(new InterviewEvaluationSessionAnswerSubmission(),dto);
    }

    @Override
    public InterviewEvaluationSessionAnswerSubmission toEntity(InterviewEvaluationSessionAnswerSubmission submission, InterviewEvaluationSessionAnswerSubmissionRequest dto) {
       return mapToEntity(submission,dto);
    }

    private InterviewEvaluationSessionAnswerSubmission mapToEntity(InterviewEvaluationSessionAnswerSubmission submission, InterviewEvaluationSessionAnswerSubmissionRequest dto) {
        //submission.setQuestion(null);
        dto.selectedAnswers().forEach(answer -> submission.addAnswer(answerMapperService.toEntity(answer)));
        submission.setStatus(statusService.getById(dto.statusId()));
        return submission;

    }


}
