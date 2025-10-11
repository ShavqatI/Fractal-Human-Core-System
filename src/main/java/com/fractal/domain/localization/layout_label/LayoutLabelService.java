package com.fractal.domain.localization.layout_label;

import com.fractal.domain.localization.layout_label.dto.LayoutLabelListRequest;
import com.fractal.domain.localization.layout_label.dto.LayoutLabelRequest;
import com.fractal.domain.localization.layout_label.dto.LayoutLabelResponse;

import java.util.List;

public interface LayoutLabelService {
    LayoutLabel create(LayoutLabelRequest dto);
    List<LayoutLabel> getAll();
    List<LayoutLabel> getAllByListAndLanguageCode(LayoutLabelListRequest dto);
    LayoutLabel getByName(String name);
    LayoutLabel getById(Long id);
    LayoutLabel update(Long id, LayoutLabelRequest dto);
    void deleteById(Long id);
    LayoutLabelResponse toDTO(LayoutLabel layoutLabel);
    LayoutLabel save(LayoutLabel layoutLabel);
}
