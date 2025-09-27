package com.fractal.domain.interview.template.section.question.answer.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.interview.template.section.question.answer.InterviewTemplateAnswer;
import com.fractal.domain.interview.template.section.question.answer.dto.InterviewTemplateAnswerRequest;
import com.fractal.domain.interview.template.section.question.answer.dto.InterviewTemplateAnswerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class InterviewEvaluationAnswerMapperServiceImpl implements InterviewEvaluationAnswerMapperService {

    private final StatusService statusService;

    @Override
    public InterviewTemplateAnswerResponse toDTO(InterviewTemplateAnswer answer) {
        return new InterviewTemplateAnswerResponse(
                answer.getId(),
                answer.getText(),
                statusService.toCompactDTO(answer.getStatus()),
                answer.getCreatedDate()
        );
    }
    @Override
    public InterviewTemplateAnswer toEntity(InterviewTemplateAnswerRequest dto) {
        return mapToEntity(new InterviewTemplateAnswer(),dto);
    }

    @Override
    public InterviewTemplateAnswer toEntity(InterviewTemplateAnswer answer, InterviewTemplateAnswerRequest dto) {
       return mapToEntity(answer,dto);
    }

    private InterviewTemplateAnswer mapToEntity(InterviewTemplateAnswer answer, InterviewTemplateAnswerRequest dto) {
        answer.setText(dto.text());
        answer.setStatus(statusService.getById(dto.statusId()));
        return answer;

    }


}
