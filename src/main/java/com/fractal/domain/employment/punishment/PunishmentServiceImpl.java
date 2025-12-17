package com.fractal.domain.employment.punishment;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employment.EmploymentService;
import com.fractal.domain.employment.punishment.dto.PunishmentApprovalWorkflowAwareRequest;
import com.fractal.domain.employment.punishment.dto.PunishmentCompactResponse;
import com.fractal.domain.employment.punishment.dto.PunishmentRequest;
import com.fractal.domain.employment.punishment.dto.PunishmentResponse;
import com.fractal.domain.employment.punishment.mapper.PunishmentMapperService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceStateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
class PunishmentServiceImpl implements PunishmentService {

    private final PunishmentRepository punishmentRepository;
    private final PunishmentMapperService mapperService;
    private final EmploymentService employmentService;
    private final StatusService statusService;
    private final AuthenticatedService authenticatedService;


    @Override
    public Punishment create(Long employmentId, PunishmentRequest dto) {
        var employment = employmentService.getById(employmentId);
        var punishment = mapperService.toEntity(dto);
        punishment.setEmployment(employment);
        employment.addPunishment(punishment);
        return punishmentRepository.save(punishment);
    }

    @Override
    public List<Punishment> getAllByEmploymentId(Long employmentId) {
        return punishmentRepository.findAllByEmploymentId(employmentId);
    }

    @Override
    public Punishment getById(Long employmentId, Long id) {
        return punishmentRepository.findByEmploymentIdAndId(employmentId, id).orElseThrow(() -> new ResourceNotFoundException("Separation Reason with id: " + id + " not found"));
    }

    @Override
    public Punishment update(Long employmentId, Long id, PunishmentRequest dto) {
        var employment = employmentService.getById(employmentId);
        var punishment = employment.getPunishments()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Separation Reason  with id: " + id + " not found"));
        punishment = punishmentRepository.save(mapperService.toEntity(punishment, dto));
        employmentService.save(employment);
        return punishment;

    }

    @Override
    public void delete(Long employmentId, Long id) {
        var employment = employmentService.getById(employmentId);
        var punishment = employment.getPunishments()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Separation Reason  with id: " + id + " not found"));
        employment.removePunishment(punishment);
        employmentService.save(employment);
    }

    @Override
    public PunishmentResponse toDTO(Punishment punishment) {
        return mapperService.toDTO(punishment);
    }

    @Override
    public PunishmentCompactResponse toCompactDTO(Punishment punishment) {
        return mapperService.toCompactDTO(punishment);
    }

    @Override
    public Punishment review(PunishmentApprovalWorkflowAwareRequest dto) {
        var punishment = getById(dto.employmentId(),dto.id());
        if (punishment.getStatus().getCode().equals("CREATED")) {
            punishment.setReviewedDate(LocalDateTime.now());
            punishment.setReviewedUser(authenticatedService.getUser());
            punishment.setStatus(statusService.getByCode("REVIEWED"));
            return punishmentRepository.save(punishment);
        } else {
            throw new ResourceStateException("The status is not valid is: " + punishment.getStatus().getName());
        }
    }

    @Override
    public Punishment approve(PunishmentApprovalWorkflowAwareRequest dto) {
        var punishment = getById(dto.employmentId(),dto.id());
        if (punishment.getStatus().getCode().equals("REVIEWED")) {
            punishment.setApprovedDate(LocalDateTime.now());
            punishment.setApprovedUser(authenticatedService.getUser());
            punishment.setStatus(statusService.getByCode("APPROVED"));
            activate(dto.employmentId(),dto.id());
            return punishmentRepository.save(punishment);
        } else {
            throw new ResourceStateException("The status is not valid is: " + punishment.getStatus().getName());
        }
    }

    @Override
    public Punishment activate(Long employmentId, Long id) {
        var punishment = getById(employmentId,id);
        if (punishment.getStatus().getCode().equals("APPROVED")) {
            punishment.setStatus(statusService.getByCode("ACTIVE"));
            return punishmentRepository.save(punishment);
        } else {
            throw new ResourceStateException("The status is not valid is: " + punishment.getStatus().getName());
        }
    }

    @Override
    public Punishment cancel(PunishmentApprovalWorkflowAwareRequest dto) {
        var punishment = getById(dto.employmentId(),dto.id());
        if (punishment.getStatus().getCode().equals("REVIEWED")) {
            punishment.setApprovedDate(LocalDateTime.now());
            punishment.setApprovedUser(authenticatedService.getUser());
            punishment.setStatus(statusService.getByCode("APPROVED"));
            activate(dto.employmentId(),dto.id());
            return punishmentRepository.save(punishment);
        } else {
            throw new ResourceStateException("The status is not valid is: " + punishment.getStatus().getName());
        }
    }
}
