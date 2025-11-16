package com.fractal.domain.education.language_skill.proficiency;

import com.fractal.domain.education.language_skill.proficiency.dto.LanguageProficiencyRequest;
import com.fractal.domain.education.language_skill.proficiency.dto.LanguageProficiencyResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class LanguageProficiencyServiceImpl implements LanguageProficiencyService {

    private final LanguageProficiencyRepository languageProficiencyRepository;

    @Override
    public LanguageProficiency create(LanguageProficiencyRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<LanguageProficiency> getAll() {
        return languageProficiencyRepository.findAll();
    }

    @Override
    public LanguageProficiency getByCode(String code) {
        return languageProficiencyRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Week Day with code: " + code + " not found"));
    }

    @Override
    public LanguageProficiency getById(Long id) {
        return findById(id);
    }

    @Override
    public LanguageProficiency update(Long id, LanguageProficiencyRequest dto) {
        try {
            LanguageProficiency languageProficiency = findById(id);
            languageProficiency.setCode(dto.code());
            languageProficiency.setName(dto.name());
            return save(languageProficiency);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        languageProficiencyRepository.delete(findById(id));
    }

    @Override
    public LanguageProficiencyResponse toDTO(LanguageProficiency languageProficiency) {
        return new LanguageProficiencyResponse(
                languageProficiency.getId(),
                languageProficiency.getCode(),
                languageProficiency.getName(),
                languageProficiency.getCreatedDate()
        );
    }

    private LanguageProficiency toEntity(LanguageProficiencyRequest dto) {
        return LanguageProficiency.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private LanguageProficiency save(LanguageProficiency languageProficiency) {
        try {
            return languageProficiencyRepository.save(languageProficiency);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private LanguageProficiency findById(Long id) {
        return languageProficiencyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Language Proficiency with id: " + id + " not found"));
    }
}
