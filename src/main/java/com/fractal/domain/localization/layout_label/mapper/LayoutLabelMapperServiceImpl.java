package com.fractal.domain.localization.layout_label.mapper;

import com.fractal.domain.localization.layout_label.LayoutLabel;
import com.fractal.domain.localization.layout_label.detail.mapper.LayoutLabelDetailMapperService;
import com.fractal.domain.localization.layout_label.dto.LayoutLabelRequest;
import com.fractal.domain.localization.layout_label.dto.LayoutLabelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class LayoutLabelMapperServiceImpl implements LayoutLabelMapperService {

    private final LayoutLabelDetailMapperService detailMapperService;
    @Override
    public LayoutLabelResponse toDTO(LayoutLabel layoutLabel) {
        return new LayoutLabelResponse(
                layoutLabel.getId(),
                layoutLabel.getName(),
                Optional.ofNullable(layoutLabel.getLayoutLabelDetails())
                        .orElse(emptyList())
                        .stream()
                        .map(detailMapperService::toDTO)
                        .collect(Collectors.toList()),
                layoutLabel.getCreatedDate()
        );
    }

    @Override
    public LayoutLabel toEntity(LayoutLabelRequest dto) {
        return mapToEntity(new LayoutLabel(),dto);
    }

    @Override
    public LayoutLabel toEntity(LayoutLabel layoutLabel, LayoutLabelRequest dto) {
        return mapToEntity(layoutLabel,dto);
    }

    private LayoutLabel mapToEntity(LayoutLabel layoutLabel, LayoutLabelRequest dto) {
        layoutLabel.setName(dto.name());
        dto.details().forEach(detail->layoutLabel.addDetail(detailMapperService.toEntity(detail)));
        return layoutLabel;
    }
}
