package com.fractal.domain.localization.layout_label.dto;

import java.util.List;

public record LayoutLabelListRequest(
       List<String> list,
       String languageCode
) {}
