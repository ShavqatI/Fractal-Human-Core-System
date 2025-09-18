package com.fractal.domain.testing.test.session.answer.selected.mapper;

import com.fractal.domain.testing.question.answer.AnswerService;
import com.fractal.domain.testing.test.session.answer.selected.SelectedAnswer;
import com.fractal.domain.testing.test.session.answer.selected.dto.SelectedAnswerRequest;
import com.fractal.domain.testing.test.session.answer.selected.dto.SelectedAnswerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class SelectedAnswerMapperServiceImpl implements SelectedAnswerMapperService {

    private final AnswerService answerService;
    @Override
    public SelectedAnswerResponse toDTO(SelectedAnswer selectedAnswer) {
        return new SelectedAnswerResponse(
                selectedAnswer.getId(),
                answerService.toDTO(selectedAnswer.getAnswer()),
                selectedAnswer.getSelectedDate(),
                selectedAnswer.getCreatedDate()

        );
    }

    @Override
    public SelectedAnswer toEntity(SelectedAnswerRequest dto) {
        return mapToEntity(new SelectedAnswer(), dto);
    }

    @Override
    public SelectedAnswer toEntity(SelectedAnswer selectedAnswer, SelectedAnswerRequest dto) {
        return mapToEntity(selectedAnswer, dto);
    }

    private SelectedAnswer mapToEntity(SelectedAnswer selectedAnswer, SelectedAnswerRequest dto) {
        selectedAnswer.setAnswer(answerService.getById(dto.answerId()));
        selectedAnswer.setSelectedDate(dto.selectedDate());
        return selectedAnswer;
    }
}
