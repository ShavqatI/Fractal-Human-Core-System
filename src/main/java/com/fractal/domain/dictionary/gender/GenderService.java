package com.fractal.domain.dictionary.gender;

import com.fractal.domain.dictionary.gender.dto.GenderRequest;
import com.fractal.domain.dictionary.gender.dto.GenderResponse;

import java.util.List;

public interface GenderService {

    Gender create(GenderRequest dto);

    List<Gender> getAll();

    Gender getByCode(String code);

    Gender getById(Long id);

    Gender update(Long id, GenderRequest dto);

    void deleteById(Long id);

    GenderResponse toDTO(Gender gender);
}
