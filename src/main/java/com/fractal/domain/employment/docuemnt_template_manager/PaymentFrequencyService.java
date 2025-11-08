package com.fractal.domain.employment.docuemnt_template_manager;

import com.fractal.domain.employment.docuemnt_template_manager.dto.PaymentFrequencyRequest;
import com.fractal.domain.employment.docuemnt_template_manager.dto.PaymentFrequencyResponse;

import java.util.List;

public interface PaymentFrequencyService {

    PaymentFrequency create(PaymentFrequencyRequest dto);
    List<PaymentFrequency> getAll();
    PaymentFrequency getByCode(String code);
    PaymentFrequency getById(Long id);
    PaymentFrequency update(Long id, PaymentFrequencyRequest dto);
    void deleteById(Long id);
    PaymentFrequencyResponse toDTO(PaymentFrequency paymentFrequency);
}
