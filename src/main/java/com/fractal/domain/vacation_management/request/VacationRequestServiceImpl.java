package com.fractal.domain.vacation_management.request;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.attendance.Attendance;
import com.fractal.domain.employee_management.attendance.absence.dto.AbsenceCancelRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestCancelRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;
import com.fractal.domain.vacation_management.request.mapper.VacationRequestMapperService;
import com.fractal.domain.vacation_management.request.state.VacationRequestStateService;
import com.fractal.exception.ResourceStateException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class VacationRequestServiceImpl implements VacationRequestService {

    private final VacationRequestRepository vacationRequestRepository;
    private final VacationRequestMapperService mapperService;
    private final VacationRequestStateService stateService;
    private final StatusService statusService;
    private final AuthenticatedService authenticatedService;

    @Override
    public VacationRequest create(VacationRequestRequest dto) {
        return save(mapperService.toEntity(dto));
    }

    @Override
    public List<VacationRequest> getAll() {
        return vacationRequestRepository.findAll().stream().sorted(Comparator.comparing(VacationRequest::getId).reversed()).collect(Collectors.toList());
    }

    @Override
    public VacationRequest getById(Long id) {
        return findById(id);
    }

    @Override
    public List<VacationRequest> getAllByEmployeeId(Long employeeId) {
        return vacationRequestRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public VacationRequest update(Long id, VacationRequestRequest dto) {
        try {
            return save(mapperService.toEntity(findById(id), dto));
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        vacationRequestRepository.delete(findById(id));
    }

    @Override
    public void close(Long id) {
        var request = findById(id);
        request.setStatus(statusService.getByCode("CLOSE"));
        save(request);

    }

    public VacationRequestResponse toDTO(VacationRequest vacationRequest) {
        return mapperService.toDTO(vacationRequest);
    }

    @Override
    @Transactional
    public VacationRequest save(VacationRequest vacationRequest) {
        try {
             vacationRequest = vacationRequestRepository.save(vacationRequest);
            stateService.create(vacationRequest);
            return vacationRequest;
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private VacationRequest findById(Long id) {
        return vacationRequestRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }

    @Override
    public VacationRequest review(Long id) {
        var vacationRequest = findById(id);
        if (vacationRequest.getStatus().getCode().equals("CREATED")) {
            vacationRequest.setReviewedDate(LocalDateTime.now());
            vacationRequest.setReviewedUser(authenticatedService.getUser());
            vacationRequest.setStatus(statusService.getByCode("REVIEWED"));
            return save(vacationRequest);
        } else {
            throw new ResourceStateException("The status of request is not valid is: " + vacationRequest.getStatus().getName());
        }
    }

    @Override
    public VacationRequest approve(Long id) {
        var vacationRequest = findById(id);
        if (vacationRequest.getStatus().getCode().equals("REVIEWED")) {
            vacationRequest.setApprovedDate(LocalDateTime.now());
            vacationRequest.setApprovedUser(authenticatedService.getUser());
            vacationRequest.setStatus(statusService.getByCode("APPROVED"));
            return save(vacationRequest);
        } else {
            throw new ResourceStateException("The status of request is not valid is: " + vacationRequest.getStatus().getName());
        }
    }

    @Override
    public VacationRequest cancel(VacationRequestCancelRequest dto) {
        var vacationRequest = getById(dto.id());
        if (vacationRequest.getStatus().getCode().equals("REVIEWED") || vacationRequest.getStatus().getCode().equals("CREATED")) {
            vacationRequest.setCanceledDate(LocalDateTime.now());
            vacationRequest.setCanceledUser(authenticatedService.getUser());
            vacationRequest.setCanceledReason(dto.reason());
            vacationRequest.setStatus(statusService.getByCode("CANCELED"));
            return save(vacationRequest);
        } else {
            throw new ResourceStateException("The status is not valid is: " + vacationRequest.getStatus().getName());
        }
    }
}
