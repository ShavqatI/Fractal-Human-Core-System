package com.fractal.domain.interview.evaluation.section.question.answer.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.interview.evaluation.section.question.answer.InterviewEvaluationAnswer;
import com.fractal.domain.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerRequest;
import com.fractal.domain.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class InterviewEvaluationAnswerMapperServiceImpl implements InterviewEvaluationAnswerMapperService {

    private final StatusService statusService;

    @Override
    public InterviewEvaluationAnswerResponse toDTO(InterviewEvaluationAnswer answer) {
        return new InterviewEvaluationAnswerResponse(
                answer.getId(),
                answer.getText(),
                statusService.toCompactDTO(answer.getStatus()),
                answer.getCreatedDate()
        );
    }

    @Override
    public InterviewEvaluationAnswer toEntity(InterviewEvaluationAnswerRequest dto) {
        return mapToEntity(new InterviewEvaluationAnswer(), dto);
    }

    @Override
    public InterviewEvaluationAnswer toEntity(InterviewEvaluationAnswer answer, InterviewEvaluationAnswerRequest dto) {
        return mapToEntity(answer, dto);
    }

    private InterviewEvaluationAnswer mapToEntity(InterviewEvaluationAnswer answer, InterviewEvaluationAnswerRequest dto) {
        answer.setText(dto.text());
        answer.setStatus(statusService.getById(dto.statusId()));
        return answer;

    }


}
