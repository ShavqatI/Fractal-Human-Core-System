package com.fractal.domain.employee_management.business_trip.expense.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.business_trip.expense.BusinessTripExpense;
import com.fractal.domain.employee_management.business_trip.expense.dto.BusinessTripExpenseRequest;
import com.fractal.domain.employee_management.business_trip.expense.dto.BusinessTripExpenseResponse;
import com.fractal.domain.finance.currency.CurrencyService;
import com.fractal.domain.finance.expense.resource.mapper.ExpenseResourceMapperService;
import com.fractal.domain.finance.expense.type.ExpenseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class BusinessTripExpenseMapperServiceImpl implements BusinessTripExpenseMapperService {

    private final ExpenseTypeService expenseTypeService;
    private final ExpenseResourceMapperService resourceMapperService;
    private final CurrencyService currencyService;
    private final StatusService statusService;

    @Override
    public BusinessTripExpenseResponse toDTO(BusinessTripExpense expense) {
        return new BusinessTripExpenseResponse(
                expense.getId(),
                expenseTypeService.toCompactDTO(expense.getExpenseType()),
                currencyService.toCompactDTO(expense.getCurrency()),
                expense.getAmount(),
                expense.getDescription(),
                expense.getDate(),
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
    public BusinessTripExpense toEntity(BusinessTripExpenseRequest dto) {
        var expense = mapToEntity(new BusinessTripExpense(), dto);
        expense.setStatus(statusService.getByCode("CREATED"));
        return expense;
    }

    @Override
    public BusinessTripExpense toEntity(BusinessTripExpense expense, BusinessTripExpenseRequest dto) {
        return mapToEntity(expense, dto);
    }

    private BusinessTripExpense mapToEntity(BusinessTripExpense expense, BusinessTripExpenseRequest dto) {
        expense.setExpenseType(expenseTypeService.getById(dto.expenseTypeId()));
        expense.setCurrency(currencyService.getById(dto.currencyId()));
        expense.setAmount(dto.amount());
        expense.setDate(dto.date());
        expense.setDescription(dto.description());
        dto.files().forEach(file -> expense.addResource(resourceMapperService.toEntity(file, null)));
        return expense;
    }

}
