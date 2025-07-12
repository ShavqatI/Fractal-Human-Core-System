package com.fractal.domain.localization.layout_label.detail;

import com.fractal.domain.localization.layout_label.detail.dto.LayoutLabelDetailRequest;
import com.fractal.domain.localization.layout_label.detail.dto.LayoutLabelDetailResponse;

import java.util.List;

public interface LayoutLabelDetailService {
    LayoutLabelDetail create(Long layoutLabelId, LayoutLabelDetailRequest dto);
    List<LayoutLabelDetail> getAllByLayoutLabelId(Long layoutLabelId);
    LayoutLabelDetail getById(Long layoutLabelId,Long id);
    LayoutLabelDetail update(Long layoutLabelId,Long id, LayoutLabelDetailRequest dto);
    void delete(Long layoutLabelId, Long id);
    LayoutLabelDetailResponse toDTO(LayoutLabelDetail layoutLabelDetail);
}
