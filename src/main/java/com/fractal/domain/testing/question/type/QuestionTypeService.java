package com.fractal.domain.testing.question.type;

import com.fractal.domain.testing.question.type.dto.QuestionTypeRequest;
import com.fractal.domain.testing.question.type.dto.QuestionTypeResponse;

import java.util.List;

public interface QuestionTypeService {
    QuestionType create(QuestionTypeRequest dto);

    List<QuestionType> getAll();

    QuestionType getByCode(String code);

    QuestionType getById(Long id);

    QuestionType update(Long id, QuestionTypeRequest dto);

    void deleteById(Long id);

    QuestionTypeResponse toDTO(QuestionType questionType);
}
