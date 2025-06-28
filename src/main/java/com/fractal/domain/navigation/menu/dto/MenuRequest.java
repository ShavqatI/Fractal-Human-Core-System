package com.fractal.domain.navigation.menu.dto;

import com.fractal.domain.localization.layout_label.LayoutLabel;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.List;

public record MenuRequest(
        String name,
        String url,
        Integer level,
        String icon,
        Long layoutLabelId,
        Integer sequence,
        List<MenuRequest> children
) {}
