package com.fractal.domain.recruitment.interview.evaluation.session.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.InterviewEvaluationSessionAnswerSubmission;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.mapper.InterviewEvaluationSessionSelectedAnswerMapperService;
import com.fractal.domain.recruitment.interview.evaluation.session.dto.InterviewEvaluationSessionAnswerSubmissionRequest;
import com.fractal.domain.recruitment.interview.evaluation.session.dto.InterviewEvaluationSessionAnswerSubmissionResponse;
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
    public InterviewEvaluationSessionAnswerSubmissionResponse toDTO(InterviewEvaluationSessionAnswerSubmission submission) {
        return new InterviewEvaluationSessionAnswerSubmissionResponse(
                submission.getId(),
                null,
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
    public InterviewEvaluationSessionAnswerSubmission toEntity(InterviewEvaluationSessionAnswerSubmissionRequest dto) {
        return mapToEntity(new InterviewEvaluationSessionAnswerSubmission(),dto);
    }

    @Override
    public InterviewEvaluationSessionAnswerSubmission toEntity(InterviewEvaluationSessionAnswerSubmission submission, InterviewEvaluationSessionAnswerSubmissionRequest dto) {
       return mapToEntity(submission,dto);
    }

    private InterviewEvaluationSessionAnswerSubmission mapToEntity(InterviewEvaluationSessionAnswerSubmission submission, InterviewEvaluationSessionAnswerSubmissionRequest dto) {
        //submission.setQuestion(null);
        dto.answers().forEach(answer -> submission.addAnswer(answerMapperService.toEntity(answer)));
        submission.setStatus(statusService.getById(dto.statusId()));
        return submission;

    }


}
