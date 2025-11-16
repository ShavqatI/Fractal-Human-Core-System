package com.fractal.domain.education.language_skill.proficiency;

import com.fractal.domain.education.language_skill.proficiency.dto.LanguageProficiencyRequest;
import com.fractal.domain.education.language_skill.proficiency.dto.LanguageProficiencyResponse;

import java.util.List;

public interface LanguageProficiencyService {

    LanguageProficiency create(LanguageProficiencyRequest dto);

    List<LanguageProficiency> getAll();

    LanguageProficiency getByCode(String code);

    LanguageProficiency getById(Long id);

    LanguageProficiency update(Long id, LanguageProficiencyRequest dto);

    void deleteById(Long id);

    LanguageProficiencyResponse toDTO(LanguageProficiency languageProficiency);
}
