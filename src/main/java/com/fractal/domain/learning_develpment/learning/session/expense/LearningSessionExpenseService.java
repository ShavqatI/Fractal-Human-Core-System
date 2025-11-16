package com.fractal.domain.learning_develpment.learning.session.expense;

import com.fractal.domain.learning_develpment.learning.session.expense.dto.LearningSessionExpenseRequest;
import com.fractal.domain.learning_develpment.learning.session.expense.dto.LearningSessionExpenseResponse;

import java.util.List;

public interface LearningSessionExpenseService {
    LearningSessionExpense create(Long sessionId, LearningSessionExpenseRequest dto);

    List<LearningSessionExpense> getAllByLearningSessionId(Long sessionId);

    LearningSessionExpense getById(Long sessionId, Long id);

    LearningSessionExpenseResponse toDTO(LearningSessionExpense expense);

    LearningSessionExpense update(Long sessionId, Long id, LearningSessionExpenseRequest dto);

    void delete(Long sessionId, Long id);


}
