package com.fractal.domain.interview.evaluation.session.answer.selected.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.interview.evaluation.section.question.answer.mapper.InterviewEvaluationAnswerMapperService;
import com.fractal.domain.interview.evaluation.session.answer.selected.InterviewEvaluationSessionSelectedAnswer;
import com.fractal.domain.interview.evaluation.session.answer.selected.dto.InterviewEvaluationSessionSelectedAnswerCompactResponse;
import com.fractal.domain.interview.evaluation.session.answer.selected.dto.InterviewEvaluationSessionSelectedAnswerRequest;
import com.fractal.domain.interview.evaluation.session.answer.selected.dto.InterviewEvaluationSessionSelectedAnswerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class InterviewEvaluationSessionSelectedAnswerMapperServiceImpl implements InterviewEvaluationSessionSelectedAnswerMapperService {

    private final StatusService statusService;
    private final InterviewEvaluationAnswerMapperService answerMapperService;

    @Override
    public InterviewEvaluationSessionSelectedAnswerResponse toDTO(InterviewEvaluationSessionSelectedAnswer selectedAnswer) {
        return new InterviewEvaluationSessionSelectedAnswerResponse(
                selectedAnswer.getId(),
                answerMapperService.toDTO(selectedAnswer.getAnswer()),
                selectedAnswer.getSelectedDate(),
                selectedAnswer.getCreatedDate()
        );
    }

    @Override
    public InterviewEvaluationSessionSelectedAnswerCompactResponse toCompactDTO(InterviewEvaluationSessionSelectedAnswer selectedAnswer) {
        return new InterviewEvaluationSessionSelectedAnswerCompactResponse(
                selectedAnswer.getId(),
                selectedAnswer.getSelectedDate(),
                selectedAnswer.getCreatedDate()
        );
    }

    @Override
    public InterviewEvaluationSessionSelectedAnswer toEntity(InterviewEvaluationSessionSelectedAnswerRequest dto) {
        return mapToEntity(new InterviewEvaluationSessionSelectedAnswer(),dto);
    }

    @Override
    public InterviewEvaluationSessionSelectedAnswer toEntity(InterviewEvaluationSessionSelectedAnswer selectedAnswer, InterviewEvaluationSessionSelectedAnswerRequest dto) {
       return mapToEntity(selectedAnswer,dto);
    }

    private InterviewEvaluationSessionSelectedAnswer mapToEntity(InterviewEvaluationSessionSelectedAnswer selectedAnswer, InterviewEvaluationSessionSelectedAnswerRequest dto) {
        //selectedAnswer.setAnswer(answerMapperService);

        //selectedAnswer.setStatus(statusService.getById(dto.statusId()));
        return selectedAnswer;

    }


}
