package com.fractal.domain.employment.internal.compensation_component;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employment.internal.InternalEmploymentService;
import com.fractal.domain.employment.internal.compensation_component.dto.ApprovalWorkflowAwareRequest;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentRequest;
import com.fractal.domain.employment.internal.compensation_component.dto.CompensationComponentResponse;
import com.fractal.domain.employment.internal.compensation_component.mapper.CompensationComponentMapperService;
import com.fractal.domain.employment.internal.compensation_component.state.CompensationComponentStateService;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
class CompensationComponentServiceImpl implements CompensationComponentService {

    private final CompensationComponentRepository compensationComponentRepository;
    private final CompensationComponentMapperService compensationComponentMapperService;
    private final InternalEmploymentService employmentService;
    private final AuthenticatedService authenticatedService;
    private final StatusService statusService;
    private final CompensationComponentStateService stateService;

    @Override
    @Transactional
    public CompensationComponent create(Long employmentId, CompensationComponentRequest dto) {
        var employment = employmentService.getById(employmentId);
        var compensationComponent = compensationComponentMapperService.toEntity(dto);
        employment.addCompensationComponent(compensationComponent);
        employmentService.save(employment);
        return compensationComponent;
    }

    @Override
    public List<CompensationComponent> getAllByInternalEmploymentId(Long employmentId) {
        return compensationComponentRepository.findAllByInternalEmploymentId(employmentId);
    }

    @Override
    public CompensationComponent getById(Long employmentId, Long id) {
        return compensationComponentRepository.findByInternalEmploymentIdAndId(employmentId, id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }

    @Override
    @Transactional
    public CompensationComponent update(Long employmentId, Long id, CompensationComponentRequest dto) {
        var employment = employmentService.getById(employmentId);
        var compensationComponent = employment.getCompensationComponents()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        compensationComponent = compensationComponentMapperService.toEntity(compensationComponent, dto);
        compensationComponentRepository.save(compensationComponent);
        employmentService.save(employment);
        return compensationComponent;
    }

    @Override
    @Transactional
    public void delete(Long employmentId, Long id) {
        var employment = employmentService.getById(employmentId);
        var compensationComponent = employment.getCompensationComponents()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        employment.removeCompensationComponent(compensationComponent);
        employmentService.save(employment);
    }

    @Override
    public CompensationComponentResponse toDTO(CompensationComponent agreement) {
        return compensationComponentMapperService.toDTO(agreement);
    }

    @Override
    public CompensationComponent save(CompensationComponent agreement) {
        try {
            return compensationComponentRepository.save(agreement);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public CompensationComponent getById(Long id) {
        return findById(id);
    }

    @Override
    public CompensationComponent review(ApprovalWorkflowAwareRequest dto) {
        var compensationComponent = getById(dto.employmentId(),dto.id());
        if (compensationComponent.getStatus().getCode().equals("CREATED")) {
            compensationComponent.setReviewedDate(LocalDateTime.now());
            compensationComponent.setReviewedUser(authenticatedService.getUser());
            compensationComponent.setStatus(statusService.getByCode("REVIEWED"));
            stateService.create(compensationComponent);
            return compensationComponent;
        } else {
            throw new ResourceStateException("The status is not valid is: " + compensationComponent.getStatus().getName());
        }
    }

    @Override
    public CompensationComponent approve(ApprovalWorkflowAwareRequest dto) {
        var compensationComponent = getById(dto.employmentId(),dto.id());
        if (compensationComponent.getStatus().getCode().equals("REVIEWED")) {
            compensationComponent.setApprovedDate(LocalDateTime.now());
            compensationComponent.setApprovedUser(authenticatedService.getUser());
            compensationComponent.setStatus(statusService.getByCode("APPROVED"));
            stateService.create(compensationComponent);
            activate(dto.employmentId(),dto.id());
            return compensationComponent;
        } else {
            throw new ResourceStateException("The status is not valid is: " + compensationComponent.getStatus().getName());
        }

    }

    @Override
    public CompensationComponent activate(Long employmentId, Long id) {
        var compensationComponent = getById(employmentId,id);
        if (compensationComponent.getStatus().getCode().equals("APPROVED")) {
            compensationComponent.setStatus(statusService.getByCode("ACTIVE"));
            stateService.create(compensationComponent);
            return compensationComponent;
        } else {
            throw new ResourceStateException("The status is not valid is: " + compensationComponent.getStatus().getName());
        }
    }

    private CompensationComponent findById(Long id) {
        return compensationComponentRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }
}
