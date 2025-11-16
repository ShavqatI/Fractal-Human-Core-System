package com.fractal.domain.dictionary.nationality;

import com.fractal.domain.dictionary.nationality.dto.NationalityRequest;
import com.fractal.domain.dictionary.nationality.dto.NationalityResponse;

import java.util.List;

public interface NationalityService {

    Nationality create(NationalityRequest dto);

    List<Nationality> getAll();

    Nationality getByCode(String code);

    Nationality getById(Long id);

    Nationality update(Long id, NationalityRequest dto);

    void deleteById(Long id);

    NationalityResponse toDTO(Nationality nationality);
}
