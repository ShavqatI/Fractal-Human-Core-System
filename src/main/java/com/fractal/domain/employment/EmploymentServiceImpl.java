package com.fractal.domain.employment;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponent;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponentService;
import com.fractal.domain.employment.internal.compensation_component.dto.ApprovalWorkflowAwareRequest;
import com.fractal.domain.employment.state.EmploymentStateService;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
class EmploymentServiceImpl implements EmploymentService {

    private final EmploymentRepository employmentRepository;
    private final AuthenticatedService authenticatedService;
    private final StatusService statusService;
    private final EmploymentStateService stateService;


    @Override
    public Employment getById(Long id) {
        return employmentRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }

    @Override
    public Employment save(Employment employment) {
        try {
            employment = employmentRepository.save(employment);
            stateService.create(employment);
            return employment;

        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public Employment activate(Long id) {
        var employment = getById(id);
        if (employment.getStatus().getCode().equals("APPROVED")) {
            employment.setStatus(statusService.getByCode("ACTIVE"));
            return save(employment);
        } else {
            throw new ResourceStateException("The status is not valid is: " + employment.getStatus().getName());
        }
    }

    @Override
    public Employment close(Long id, LocalDate endDate) {
        var employment = getById(id);
        if (!employment.getStatus().getCode().equals("CLOSE")) {
            employment.setStatus(statusService.getByCode("CLOSE"));
            employment.setEndDate(endDate);
            return save(employment);
        } else {
            throw new ResourceStateException("The status is not valid is: " + employment.getStatus().getName());
        }
    }

    @Override
    public Employment review(Long id) {
        var employment = getById(id);
        if (employment.getStatus().getCode().equals("CREATED")) {
            employment.setReviewedDate(LocalDateTime.now());
            employment.setReviewedUser(authenticatedService.getUser());
            employment.setStatus(statusService.getByCode("REVIEWED"));

            return save(employment);
        } else {
            throw new ResourceStateException("The status is not valid is: " + employment.getStatus().getName());
        }
    }

    @Override
    public Employment approve(Long id) {
        var employment = getById(id);
        if (employment.getStatus().getCode().equals("REVIEWED")) {
            employment.setApprovedDate(LocalDateTime.now());
            employment.setApprovedUser(authenticatedService.getUser());
            employment.setStatus(statusService.getByCode("APPROVED"));
            return save(employment);
        } else {
            throw new ResourceStateException("The status is not valid is: " + employment.getStatus().getName());
        }

    }
}
