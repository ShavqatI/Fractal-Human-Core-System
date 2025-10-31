package com.fractal.domain.dictionary.industry;

import com.fractal.domain.dictionary.industry.dto.IndustryRequest;
import com.fractal.domain.dictionary.industry.dto.IndustryResponse;

import java.util.List;

public interface IndustryService {

    Industry create(IndustryRequest dto);
    List<Industry> getAll();
    Industry getByCode(String code);
    Industry getById(Long id);
    Industry update(Long id, IndustryRequest dto);
    void deleteById(Long id);
    IndustryResponse toDTO(Industry industry);
}
