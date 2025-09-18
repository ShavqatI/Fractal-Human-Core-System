package com.fractal.domain.testing.test.session.answer.selected;


import com.fractal.domain.testing.test.session.answer.selected.dto.SelectedAnswerRequest;
import com.fractal.domain.testing.test.session.answer.selected.dto.SelectedAnswerResponse;

import java.util.List;
public interface SelectedAnswerService {

    SelectedAnswer create(Long questionId, SelectedAnswerRequest dto);
    List<SelectedAnswer> getAllByQuestionId(Long questionId);
    SelectedAnswer getById(Long questionId , Long id);
    SelectedAnswerResponse toDTO(SelectedAnswer selectedAnswer);
    SelectedAnswer update(Long questionId, Long id, SelectedAnswerRequest dto);
    void delete(Long questionId,Long id);
}
