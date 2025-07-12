package com.fractal.domain.localization.language;

import com.fractal.domain.localization.language.dto.LanguageRequest;
import com.fractal.domain.localization.language.dto.LanguageResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class LanguageServiceImpl implements LanguageService {


    private final LanguageRepository languageRepository;

    @Override
    public Language create(LanguageRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language getByCode(String code) {
        return languageRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Language with code: " + code + " not found"));
    }

    @Override
    public Language getById(Long id) {
        return findById(id);
    }

    @Override
    public Language update(Long id, LanguageRequest dto) {
        try {
            Language language = findById(id);
            language.setCode(dto.code());
            language.setName(dto.name());
            return save(language);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        languageRepository.delete(findById(id));
    }

    @Override
    public LanguageResponse toDTO(Language language) {
        return new LanguageResponse(
                language.getId(),
                language.getCode(),
                language.getName(),
                language.getCreatedDate()
        );
    }

    private Language toEntity(LanguageRequest dto) {
        return Language.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
    }

    private Language save(Language language) {
        try {
            return languageRepository.save(language);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Language findById(Long id) {
        return languageRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Language with id: " + id + " not found"));
    }
}
