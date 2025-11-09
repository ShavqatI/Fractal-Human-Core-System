package com.fractal.domain.interview.evaluation.session.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.interview.evaluation.section.question.InterviewEvaluationQuestionService;
import com.fractal.domain.interview.evaluation.session.InterviewEvaluationSession;
import com.fractal.domain.interview.evaluation.session.submission.mapper.InterviewEvaluationSessionAnswerSubmissionMapperService;
import com.fractal.domain.interview.evaluation.session.dto.InterviewEvaluationSessionRequest;
import com.fractal.domain.interview.evaluation.session.dto.InterviewEvaluationSessionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class InterviewEvaluationSessionMapperServiceImpl implements InterviewEvaluationSessionMapperService {

    private final StatusService statusService;
    private final InterviewEvaluationQuestionService questionService;
    private final InterviewEvaluationSessionAnswerSubmissionMapperService submissionMapperService;


    @Override
    public InterviewEvaluationSessionResponse toDTO(InterviewEvaluationSession session) {
        return new InterviewEvaluationSessionResponse(
                session.getId(),
                session.getStartDate(),
                session.getEndDate(),
                Optional.ofNullable(session.getSubmissions())
                        .orElse(emptyList())
                        .stream()
                        .map(submissionMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(session.getStatus()),
                session.getCreatedDate()
        );
    }
    @Override
    public InterviewEvaluationSession toEntity(InterviewEvaluationSessionRequest dto) {
        return mapToEntity(new InterviewEvaluationSession(),dto);
    }

    @Override
    public InterviewEvaluationSession toEntity(InterviewEvaluationSession session, InterviewEvaluationSessionRequest dto) {
       return mapToEntity(session,dto);
    }

    private InterviewEvaluationSession mapToEntity(InterviewEvaluationSession session, InterviewEvaluationSessionRequest dto) {
        session.setStartDate(dto.startDate());
        session.setStartDate(dto.endDate());
        dto.submissions().forEach(submission -> session.addSubmission(submissionMapperService.toEntity(submission)));
        session.setStatus(statusService.getById(dto.statusId()));
        return session;

    }


}
