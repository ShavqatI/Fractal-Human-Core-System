package com.fractal.domain.localization.layout_label.detail.mapper;

import com.fractal.domain.localization.language.LanguageService;
import com.fractal.domain.localization.layout_label.detail.LayoutLabelDetail;
import com.fractal.domain.localization.layout_label.detail.dto.LayoutLabelDetailRequest;
import com.fractal.domain.localization.layout_label.detail.dto.LayoutLabelDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class LayoutLabelDetailMapperServiceImpl implements LayoutLabelDetailMapperService {

    private final LanguageService languageService;

    @Override
    public LayoutLabelDetailResponse toDTO(LayoutLabelDetail layoutLabelDetail) {
        return new LayoutLabelDetailResponse(
                layoutLabelDetail.getId(),
                languageService.toDTO(layoutLabelDetail.getLanguage()),
                layoutLabelDetail.getDescription(),
                layoutLabelDetail.getCreatedDate()

        );
    }

    @Override
    public LayoutLabelDetail toEntity(LayoutLabelDetailRequest dto) {
        return mapToEntity(new LayoutLabelDetail(), dto);
    }

    @Override
    public LayoutLabelDetail toEntity(LayoutLabelDetail layoutLabelDetail, LayoutLabelDetailRequest dto) {
        return mapToEntity(layoutLabelDetail, dto);
    }

    private LayoutLabelDetail mapToEntity(LayoutLabelDetail layoutLabelDetail, LayoutLabelDetailRequest dto) {
        layoutLabelDetail.setDescription(dto.description());
        layoutLabelDetail.setLanguage(languageService.getById(dto.languageId()));
        return layoutLabelDetail;
    }
}
