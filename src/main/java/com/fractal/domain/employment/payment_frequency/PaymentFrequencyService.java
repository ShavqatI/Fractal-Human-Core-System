package com.fractal.domain.employment.payment_frequency;

import com.fractal.domain.employment.payment_frequency.dto.PaymentFrequencyRequest;
import com.fractal.domain.employment.payment_frequency.dto.PaymentFrequencyResponse;

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
