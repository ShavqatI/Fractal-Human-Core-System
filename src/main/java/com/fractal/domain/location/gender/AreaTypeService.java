package com.fractal.domain.location.gender;

import com.fractal.domain.location.gender.dto.AreaTypeRequest;
import com.fractal.domain.location.gender.dto.AreaTypeResponse;

import java.util.List;

public interface AreaTypeService {

    AreaType create(AreaTypeRequest dto);
    List<AreaType> getAll();
    AreaType getByCode(String code);
    AreaType getById(Long id);
    AreaType update(Long id, AreaTypeRequest dto);
    void deleteById(Long id);
    AreaTypeResponse toDTO(AreaType areaType);
}
