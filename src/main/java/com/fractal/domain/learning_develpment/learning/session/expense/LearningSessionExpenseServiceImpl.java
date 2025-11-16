package com.fractal.domain.learning_develpment.learning.session.expense;

import com.fractal.domain.learning_develpment.learning.session.LearningSessionService;
import com.fractal.domain.learning_develpment.learning.session.expense.dto.LearningSessionExpenseRequest;
import com.fractal.domain.learning_develpment.learning.session.expense.dto.LearningSessionExpenseResponse;
import com.fractal.domain.learning_develpment.learning.session.expense.mapper.LearningSessionExpenseMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class LearningSessionExpenseServiceImpl implements LearningSessionExpenseService {

    private final LearningSessionExpenseRepository expenseRepository;
    private final LearningSessionExpenseMapperService mapperService;
    private final LearningSessionService sessionService;

    @Override
    public LearningSessionExpense create(Long sessionId, LearningSessionExpenseRequest dto) {
        var session = sessionService.getById(sessionId);
        var expense = mapperService.toEntity(dto);
        session.addExpense(expense);
        sessionService.save(session);
        return expense;
    }

    @Override
    public List<LearningSessionExpense> getAllByLearningSessionId(Long sessionId) {
        return expenseRepository.findAllByLearningSessionId(sessionId);
    }

    @Override
    public LearningSessionExpense getById(Long sessionId, Long id) {
        return expenseRepository.findByLearningSessionIdAndId(sessionId, id).orElseThrow(() -> new ResourceNotFoundException("Learning Session Expense with id: " + id + " not found"));
    }

    @Override
    public LearningSessionExpenseResponse toDTO(LearningSessionExpense expense) {
        return mapperService.toDTO(expense);
    }

    @Override
    public LearningSessionExpense update(Long sessionId, Long id, LearningSessionExpenseRequest dto) {
        var session = sessionService.getById(sessionId);
        var expense = session.getExpenses()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Learning Session Expense with id: " + id + " not found"));
        expense = mapperService.toEntity(expense, dto);
        expenseRepository.save(expense);
        sessionService.save(session);
        return expense;
    }

    @Override
    public void delete(Long sessionId, Long id) {
        var session = sessionService.getById(sessionId);
        var expense = session.getExpenses()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Learning Session Expense with id: " + id + " not found"));
        session.removeExpense(expense);
        sessionService.save(session);
    }
}
