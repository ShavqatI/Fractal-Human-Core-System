package com.fractal.domain.training_management.training.expense.mapper;

import com.fractal.domain.training_management.training.expense.TrainingExpense;
import com.fractal.domain.training_management.training.expense.dto.TrainingExpenseRequest;
import com.fractal.domain.training_management.training.expense.dto.TrainingExpenseResponse;

public interface TrainingExpenseMapperService {
    TrainingExpenseResponse toDTO(TrainingExpense location);
    TrainingExpense toEntity(TrainingExpenseRequest dto);
    TrainingExpense toEntity(TrainingExpense location, TrainingExpenseRequest dto);
}


