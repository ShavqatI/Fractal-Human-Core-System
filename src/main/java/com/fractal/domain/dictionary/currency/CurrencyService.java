package com.fractal.domain.dictionary.currency;

import com.fractal.domain.dictionary.currency.dto.CurrencyRequest;
import com.fractal.domain.dictionary.currency.dto.CurrencyResponse;

import java.util.List;

public interface CurrencyService {

    Currency create(CurrencyRequest dto);
    List<Currency> getAll();
    Currency getByCode(String code);
    Currency getById(Long id);
    Currency update(Long id, CurrencyRequest dto);
    void deleteById(Long id);
    CurrencyResponse toDTO(Currency currency);
}
