package com.fractal.domain.employment.punishment;

import com.fractal.domain.abstraction.ApprovalWorkflowAware;
import com.fractal.domain.abstraction.Cancelable;
import com.fractal.domain.employment.punishment.dto.PunishmentApprovalWorkflowAwareRequest;
import com.fractal.domain.employment.punishment.dto.PunishmentCompactResponse;
import com.fractal.domain.employment.punishment.dto.PunishmentRequest;
import com.fractal.domain.employment.punishment.dto.PunishmentResponse;

import java.util.List;

public interface PunishmentService extends ApprovalWorkflowAware<PunishmentApprovalWorkflowAwareRequest, Punishment>,Cancelable<PunishmentApprovalWorkflowAwareRequest, Punishment> {
    Punishment create(Long employmentId, PunishmentRequest dto);

    List<Punishment> getAllByEmploymentId(Long employmentId);

    Punishment getById(Long employmentId, Long id);

    Punishment update(Long employmentId, Long id, PunishmentRequest dto);

    void delete(Long employmentId, Long id);

    PunishmentResponse toDTO(Punishment punishment);
    PunishmentCompactResponse toCompactDTO(Punishment punishment);
    Punishment activate(Long employmentId, Long id);
}
