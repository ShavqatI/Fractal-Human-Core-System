package com.fractal.domain.training_management.training.expense;

import com.fractal.domain.training_management.training.TrainingService;
import com.fractal.domain.training_management.training.expense.dto.TrainingExpenseRequest;
import com.fractal.domain.training_management.training.expense.dto.TrainingExpenseResponse;
import com.fractal.domain.training_management.training.expense.mapper.TrainingExpenseMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class TrainingExpenseServiceImpl implements TrainingExpenseService {

    private final TrainingExpenseRepository expenseRepository;
    private final TrainingExpenseMapperService mapperService;
    private final TrainingService trainingService;

    @Override
    public TrainingExpense create(Long trainingId, TrainingExpenseRequest dto) {
        var training = trainingService.getById(trainingId);
        var expense = mapperService.toEntity(dto);
        training.addExpense(expense);
        trainingService.save(training);
        return expense;
    }

    @Override
    public List<TrainingExpense> getAllByTrainingId(Long trainingId) {
        return expenseRepository.findAllByTrainingId(trainingId);
    }

    @Override
    public TrainingExpense getById(Long trainingId, Long id) {
        return expenseRepository.findByTrainingIdAndId(trainingId,id).orElseThrow(()->new ResourceNotFoundException("Training Expense with id: " + id + " not found"));
    }

    @Override
    public TrainingExpenseResponse toDTO(TrainingExpense location) {
        return mapperService.toDTO(location);
    }

    @Override
    public TrainingExpense update(Long trainingId, Long id, TrainingExpenseRequest dto) {
        var training = trainingService.getById(trainingId);
        var expense = training.getExpenses()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Training Expense  with id: " + id + " not found"));
        expense = mapperService.toEntity( expense,dto);
        expenseRepository.save(expense);
        trainingService.save(training);
        return expense;
    }

    @Override
    public void delete(Long trainingId, Long id) {
        var training = trainingService.getById(trainingId);
        var expense =  training.getExpenses()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Trainin gExpense with id: " + id + " not found"));
        training.removeExpense(expense);
        trainingService.save(training);
    }
}
