package com.fractal.domain.employee_management.business_trip.expense.mapper;

import com.fractal.domain.dictionary.currency.CurrencyService;
import com.fractal.domain.employee_management.business_trip.expense.BusinessTripExpense;
import com.fractal.domain.employee_management.business_trip.expense.dto.BusinessTripExpenseRequest;
import com.fractal.domain.employee_management.business_trip.expense.dto.BusinessTripExpenseResponse;
import com.fractal.domain.employee_management.business_trip.expense.resource.mapper.BusinessTripExpenseResourceMapperService;
import com.fractal.domain.employee_management.business_trip.expense.type.BusinessTripExpenseTypeService;
import com.fractal.domain.employee_management.order.resource.mapper.OrderResourceMapperService;
import com.fractal.domain.employee_management.order.type.OrderTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class BusinessTripExpenseMapperServiceImpl implements BusinessTripExpenseMapperService {

    private final BusinessTripExpenseTypeService expenseTypeService;
    private final BusinessTripExpenseResourceMapperService resourceMapperService;
    private final CurrencyService currencyService;

    @Override
    public BusinessTripExpenseResponse toDTO(BusinessTripExpense expense) {
        return new BusinessTripExpenseResponse(
                   expense.getId(),
                   expenseTypeService.toDTO(expense.getBusinessTripExpenseType()),
                   currencyService.toCompactDTO(expense.getCurrency()),
                   expense.getAmount(),
                   expense.getDescription(),
                   expense.getDate(),
                   Optional.ofNullable(expense.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(resourceMapperService::toDTO)
                        .collect(Collectors.toList()),
                   expense.getCreatedDate()

        );
    }

    @Override
    public BusinessTripExpense toEntity(BusinessTripExpenseRequest dto) {
        return mapToEntity(new BusinessTripExpense(),dto);
    }

    @Override
    public BusinessTripExpense toEntity(BusinessTripExpense expense, BusinessTripExpenseRequest dto) {
        return mapToEntity(expense,dto);
    }

    private BusinessTripExpense mapToEntity(BusinessTripExpense expense, BusinessTripExpenseRequest dto) {
        expense.setBusinessTripExpenseType(expenseTypeService.getById(dto.businessTripExpenseTypeId()));
        expense.setCurrency(currencyService.getById(dto.currencyId()));
        expense.setAmount(dto.amount());
        expense.setDate(dto.date());
        expense.setDescription(dto.description());
        dto.files().forEach(file-> expense.addResource(resourceMapperService.toEntity(file,null)));
        return expense;
    }

}
