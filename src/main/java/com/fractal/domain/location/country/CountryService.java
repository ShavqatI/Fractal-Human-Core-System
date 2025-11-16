package com.fractal.domain.location.country;

import com.fractal.domain.location.country.dto.CountryCompactResponse;
import com.fractal.domain.location.country.dto.CountryRequest;
import com.fractal.domain.location.country.dto.CountryResponse;

import java.util.List;

public interface CountryService {
    Country create(CountryRequest dto);

    List<Country> getAll();

    Country getByCode(String code);

    Country getById(Long id);

    Country update(Long id, CountryRequest dto);

    void deleteById(Long id);

    CountryResponse toDTO(Country country);

    CountryCompactResponse toCompactDTO(Country country);
}
