package com.fractal.domain.training_management.training.expense.mapper;

import com.fractal.domain.dictionary.currency.CurrencyService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.finance.expense.resource.mapper.ExpenseResourceMapperService;
import com.fractal.domain.finance.expense.type.ExpenseTypeService;
import com.fractal.domain.training_management.training.expense.TrainingExpense;
import com.fractal.domain.training_management.training.expense.dto.TrainingExpenseRequest;
import com.fractal.domain.training_management.training.expense.dto.TrainingExpenseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class TrainingExpenseMapperServiceImpl implements TrainingExpenseMapperService {

    private final ExpenseTypeService expenseTypeService;
    private final CurrencyService currencyService;
    private final StatusService statusService;
    private final ExpenseResourceMapperService resourceMapperService;

    @Override
    public TrainingExpenseResponse toDTO(TrainingExpense expense) {
        return new TrainingExpenseResponse(
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
    public TrainingExpense toEntity(TrainingExpenseRequest dto) {
        return mapToEntity(new TrainingExpense(), dto);
    }

    @Override
    public TrainingExpense toEntity(TrainingExpense location, TrainingExpenseRequest dto) {
        return mapToEntity(location, dto);
    }

    private TrainingExpense mapToEntity(TrainingExpense expense, TrainingExpenseRequest dto) {
        expense.setExpenseType(expenseTypeService.getById(dto.expenseTypeId()));
        expense.setDate(dto.date());
        expense.setCurrency(currencyService.getById(dto.currencyId()));
        expense.setAmount(dto.amount());
        expense.setDescription(dto.description());
        expense.setInvoiceNumber(dto.invoiceNumber());
        expense.setStatus(statusService.getById(dto.statusId()));
        dto.files().forEach(file-> expense.addResource(resourceMapperService.toEntity(file,null)));
        return expense;
    }
}
