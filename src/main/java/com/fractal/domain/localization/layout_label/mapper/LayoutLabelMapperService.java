package com.fractal.domain.localization.layout_label.mapper;

import com.fractal.domain.localization.layout_label.LayoutLabel;
import com.fractal.domain.localization.layout_label.dto.LayoutLabelRequest;
import com.fractal.domain.localization.layout_label.dto.LayoutLabelResponse;

public interface LayoutLabelMapperService {
    LayoutLabelResponse toDTO(LayoutLabel layoutLabel);

    LayoutLabel toEntity(LayoutLabelRequest dto);

    LayoutLabel toEntity(LayoutLabel layoutLabel, LayoutLabelRequest dto);
}


