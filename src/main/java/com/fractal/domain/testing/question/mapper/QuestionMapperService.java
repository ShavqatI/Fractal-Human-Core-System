package com.fractal.domain.testing.question.mapper;

import com.fractal.domain.testing.question.Question;
import com.fractal.domain.testing.question.dto.QuestionCompactResponse;
import com.fractal.domain.testing.question.dto.QuestionRequest;
import com.fractal.domain.testing.question.dto.QuestionResponse;

public interface QuestionMapperService {
    QuestionResponse toDTO(Question question);

    QuestionCompactResponse toCompactDTO(Question question);

    Question toEntity(QuestionRequest dto);

    Question toEntity(Question question, QuestionRequest dto);
}


