package com.fractal.domain.testing.question;


import com.fractal.domain.testing.question.dto.QuestionCompactResponse;
import com.fractal.domain.testing.question.dto.QuestionRequest;
import com.fractal.domain.testing.question.dto.QuestionResponse;

import java.util.List;

public interface QuestionService {

    Question create(Long testId, QuestionRequest dto);

    List<Question> getAllByTestId(Long testId);

    Question getById(Long testId, Long id);

    Question getById(Long id);

    QuestionResponse toDTO(Question question);

    QuestionCompactResponse toCompactDTO(Question question);

    Question update(Long testId, Long id, QuestionRequest dto);

    void delete(Long testId, Long id);

    Question save(Question question);

}
