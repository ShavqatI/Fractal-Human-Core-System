package com.fractal.domain.learning_develpment.learning.session.expense.mapper;

import com.fractal.domain.learning_develpment.learning.session.expense.LearningSessionExpense;
import com.fractal.domain.learning_develpment.learning.session.expense.dto.LearningSessionExpenseRequest;
import com.fractal.domain.learning_develpment.learning.session.expense.dto.LearningSessionExpenseResponse;

public interface LearningSessionExpenseMapperService {
    LearningSessionExpenseResponse toDTO(LearningSessionExpense expense);

    LearningSessionExpense toEntity(LearningSessionExpenseRequest dto);

    LearningSessionExpense toEntity(LearningSessionExpense expense, LearningSessionExpenseRequest dto);
}


