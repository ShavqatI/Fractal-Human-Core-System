package com.fractal.domain.vacation_management.request;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.dictionary.status.StatusService;
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
        var request = save(mapperService.toEntity(dto));
        stateService.create(request);
        return request;
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
            var request = save(mapperService.toEntity(findById(id), dto));
            stateService.create(request);
            return request;
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
        request = save(request);
        stateService.create(request);
    }

    public VacationRequestResponse toDTO(VacationRequest vacationRequest) {
        return mapperService.toDTO(vacationRequest);
    }

    @Override
    @Transactional
    public VacationRequest save(VacationRequest vacationRequest) {
        try {
            return vacationRequestRepository.save(vacationRequest);
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
            stateService.create(vacationRequest);
            return vacationRequest;
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
            stateService.create(vacationRequest);
            return vacationRequest;
        } else {
            throw new ResourceStateException("The status of request is not valid is: " + vacationRequest.getStatus().getName());
        }
    }
}
