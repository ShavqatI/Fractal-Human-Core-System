package com.fractal.domain.employment.internal.compensation_component.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponent;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentRequest;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentResponse;
import com.fractal.domain.employment.payment_frequency.PaymentFrequencyService;
import com.fractal.domain.employment.salary_classification.SalaryClassificationService;
import com.fractal.domain.finance.currency.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
class CompensationComponentMapperServiceImpl implements CompensationComponentMapperService {

    private final SalaryClassificationService salaryClassificationService;
    private final PaymentFrequencyService paymentFrequencyService;
    private final CurrencyService currencyService;
    private final StatusService statusService;

    @Override
    public CompensationComponentResponse toDTO(CompensationComponent compensationComponent) {
        return new CompensationComponentResponse(
                compensationComponent.getId(),
                salaryClassificationService.toCompactDTO(compensationComponent.getSalaryClassification()),
                paymentFrequencyService.toDTO(compensationComponent.getPaymentFrequency()),
                compensationComponent.getStartDate(),
                compensationComponent.getEndDate(),
                currencyService.toDTO(compensationComponent.getCurrency()),
                compensationComponent.getGrossAmount(),
                compensationComponent.getNetAmount(),
                compensationComponent.getTaxAmount(),
                compensationComponent.getDeductionAmount(),
                compensationComponent.getTaxable(),
                statusService.toCompactDTO(compensationComponent.getStatus()),
                compensationComponent.getCreatedDate()
        );
    }

    @Override
    public CompensationComponent toEntity(CompensationComponentRequest dto) {
        return mapToEntity(new CompensationComponent(), dto);
    }

    @Override
    public CompensationComponent toEntity(CompensationComponent compensationComponent, CompensationComponentRequest dto) {
        return mapToEntity(compensationComponent, dto);
    }

    private CompensationComponent mapToEntity(CompensationComponent compensationComponent, CompensationComponentRequest dto) {
        compensationComponent.setSalaryClassification(salaryClassificationService.getById(dto.salaryClassificationId()));
        compensationComponent.setPaymentFrequency(paymentFrequencyService.getById(dto.paymentFrequencyId()));
        compensationComponent.setStartDate(dto.startDate());
        compensationComponent.setEndDate(dto.endDate());
        compensationComponent.setCurrency(currencyService.getById(dto.currencyId()));
        compensationComponent.setGrossAmount(dto.grossAmount());
        compensationComponent.setNetAmount(dto.netAmount());
        compensationComponent.setTaxAmount(dto.taxAmount());
        compensationComponent.setDeductionAmount(dto.deductionAmount());
        compensationComponent.setTaxable(dto.taxable());
        compensationComponent.setStatus(statusService.getById(dto.statusId()));
        return compensationComponent;
    }

    private BigDecimal toBigDecimal(String string) {
        return BigDecimal.valueOf(Double.valueOf(string));
    }

}
