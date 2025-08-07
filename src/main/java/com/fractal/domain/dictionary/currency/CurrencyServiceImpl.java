package com.fractal.domain.dictionary.currency;

import com.fractal.domain.dictionary.currency.dto.CurrencyCompactResponse;
import com.fractal.domain.dictionary.currency.dto.CurrencyRequest;
import com.fractal.domain.dictionary.currency.dto.CurrencyResponse;
import com.fractal.domain.location.country.CountryService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CountryService countryService;

    @Override
    public Currency create(CurrencyRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency getByCode(String code) {
        return currencyRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Currency with code: " + code + " not found"));

    }

    @Override
    public Currency getById(Long id) {
        return findById(id);
    }

    @Override
    public Currency update(Long id, CurrencyRequest dto) {
        try {
            Currency currency = findById(id);
            currency.setCode(dto.code());
            currency.setName(dto.name());
            currency.setNumericCode(dto.numericCode());
            currency.setCountry(countryService.getById(dto.countryId()));
            return save(currency);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      currencyRepository.delete(findById(id));
    }

    @Override
    public CurrencyResponse toDTO(Currency currency) {
        return new CurrencyResponse(
                currency.getId(),
                currency.getCode(),
                currency.getNumericCode(),
                currency.getName(),
                countryService.toDTO(currency.getCountry()),
                currency.getCreatedDate()
        );
    }

    @Override
    public CurrencyCompactResponse toCompactDTO(Currency currency) {
        return new CurrencyCompactResponse(
                currency.getId(),
                currency.getCode(),
                currency.getNumericCode(),
                currency.getName()
        );
    }

    private Currency toEntity(CurrencyRequest dto) {
        return Currency.builder()
                .code(dto.code())
                .name(dto.name())
                .numericCode(dto.numericCode())
                .country(countryService.getById(dto.countryId()))
                .build();
    }

    private Currency save(Currency gender) {
        try {
            return currencyRepository.save(gender);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Currency findById(Long id) {
        return currencyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Currency with id: " + id + " not found"));
    }
}
