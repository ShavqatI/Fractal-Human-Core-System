package com.fractal.domain.localization.layout_label.detail.mapper;

import com.fractal.domain.localization.layout_label.detail.LayoutLabelDetail;
import com.fractal.domain.localization.layout_label.detail.dto.LayoutLabelDetailRequest;
import com.fractal.domain.localization.layout_label.detail.dto.LayoutLabelDetailResponse;

public interface LayoutLabelDetailMapperService {
    LayoutLabelDetailResponse toDTO(LayoutLabelDetail layoutLabelDetail);
    LayoutLabelDetail toEntity(LayoutLabelDetailRequest dto);
    LayoutLabelDetail toEntity(LayoutLabelDetail layoutLabelDetail, LayoutLabelDetailRequest dto);
}


