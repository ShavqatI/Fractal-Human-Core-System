package com.fractal.domain.training_management.training.expense;

import com.fractal.domain.training_management.training.expense.dto.TrainingExpenseRequest;
import com.fractal.domain.training_management.training.expense.dto.TrainingExpenseResponse;

import java.util.List;

public interface TrainingExpenseService {
    TrainingExpense create(Long trainingId, TrainingExpenseRequest dto);
    List<TrainingExpense> getAllByTrainingId(Long trainingId);
    TrainingExpense getById(Long trainingId , Long id);
    TrainingExpenseResponse toDTO(TrainingExpense location);
    TrainingExpense update(Long trainingId, Long id, TrainingExpenseRequest dto);
    void delete(Long trainingId,Long id);


}
