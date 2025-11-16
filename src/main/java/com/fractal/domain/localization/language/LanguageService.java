package com.fractal.domain.localization.language;

import com.fractal.domain.localization.language.dto.LanguageRequest;
import com.fractal.domain.localization.language.dto.LanguageResponse;

import java.util.List;

public interface LanguageService {
    Language create(LanguageRequest dto);

    List<Language> getAll();

    Language getByCode(String code);

    Language getById(Long id);

    Language update(Long id, LanguageRequest dto);

    void deleteById(Long id);

    LanguageResponse toDTO(Language language);

}
