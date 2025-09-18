package com.fractal.domain.testing.test.session.answer.selected.mapper;

import com.fractal.domain.testing.test.session.answer.selected.SelectedAnswer;
import com.fractal.domain.testing.test.session.answer.selected.dto.SelectedAnswerRequest;
import com.fractal.domain.testing.test.session.answer.selected.dto.SelectedAnswerResponse;

public interface SelectedAnswerMapperService {
    SelectedAnswerResponse toDTO(SelectedAnswer selectedAnswer);
    SelectedAnswer toEntity(SelectedAnswerRequest dto);
    SelectedAnswer toEntity(SelectedAnswer selectedAnswer, SelectedAnswerRequest dto);
}


