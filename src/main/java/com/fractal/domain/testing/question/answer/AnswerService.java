package com.fractal.domain.testing.question.answer;


import com.fractal.domain.testing.question.answer.dto.AnswerRequest;
import com.fractal.domain.testing.question.answer.dto.AnswerResponse;

import java.util.List;
public interface AnswerService {

    Answer create(Long questionId, AnswerRequest dto);
    List<Answer> getAllByQuestionId(Long questionId);
    Answer getById(Long questionId , Long id);
    Answer getById(Long id);
    AnswerResponse toDTO(Answer answer);
    Answer update(Long questionId, Long id, AnswerRequest dto);
    void delete(Long questionId,Long id);
}
