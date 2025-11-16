package com.fractal.domain.learning_develpment.learning.session.expense.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.finance.currency.CurrencyService;
import com.fractal.domain.finance.expense.resource.mapper.ExpenseResourceMapperService;
import com.fractal.domain.finance.expense.type.ExpenseTypeService;
import com.fractal.domain.learning_develpment.learning.session.expense.LearningSessionExpense;
import com.fractal.domain.learning_develpment.learning.session.expense.dto.LearningSessionExpenseRequest;
import com.fractal.domain.learning_develpment.learning.session.expense.dto.LearningSessionExpenseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class LearningSessionExpenseMapperServiceImpl implements LearningSessionExpenseMapperService {

    private final ExpenseTypeService expenseTypeService;
    private final CurrencyService currencyService;
    private final StatusService statusService;
    private final ExpenseResourceMapperService resourceMapperService;

    @Override
    public LearningSessionExpenseResponse toDTO(LearningSessionExpense expense) {
        return new LearningSessionExpenseResponse(
                expense.getId(),
                expenseTypeService.toCompactDTO(expense.getExpenseType()),
                expense.getDate(),
                currencyService.toDTO(expense.getCurrency()),
                expense.getAmount(),
                expense.getDescription(),
                expense.getInvoiceNumber(),
                Optional.ofNullable(expense.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(resourceMapperService::toDTO)
                        .collect(Collectors.toList()),
                statusService.toCompactDTO(expense.getStatus()),
                expense.getCreatedDate()

        );
    }

    @Override
    public LearningSessionExpense toEntity(LearningSessionExpenseRequest dto) {
        return mapToEntity(new LearningSessionExpense(), dto);
    }

    @Override
    public LearningSessionExpense toEntity(LearningSessionExpense expense, LearningSessionExpenseRequest dto) {
        return mapToEntity(expense, dto);
    }

    private LearningSessionExpense mapToEntity(LearningSessionExpense expense, LearningSessionExpenseRequest dto) {
        expense.setExpenseType(expenseTypeService.getById(dto.expenseTypeId()));
        expense.setDate(dto.date());
        expense.setCurrency(currencyService.getById(dto.currencyId()));
        expense.setAmount(dto.amount());
        expense.setDescription(dto.description());
        expense.setInvoiceNumber(dto.invoiceNumber());
        expense.setStatus(statusService.getById(dto.statusId()));
        dto.files().forEach(file -> expense.addResource(resourceMapperService.toEntity(file, null)));
        return expense;
    }
}
