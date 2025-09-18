package com.fractal.domain.testing.question.answer.mapper;

import com.fractal.domain.testing.question.answer.Answer;
import com.fractal.domain.testing.question.answer.dto.AnswerRequest;
import com.fractal.domain.testing.question.answer.dto.AnswerResponse;

public interface AnswerMapperService {
    AnswerResponse toDTO(Answer answer);
    Answer toEntity(AnswerRequest dto);
    Answer toEntity(Answer answer, AnswerRequest dto);
}


