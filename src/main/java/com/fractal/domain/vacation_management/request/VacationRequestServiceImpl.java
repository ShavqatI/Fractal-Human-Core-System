package com.fractal.domain.vacation_management.request;

import com.fractal.domain.vacation_management.dto.VacationResponse;
import com.fractal.domain.vacation_management.request.dto.VacationRequestRequest;
import com.fractal.domain.vacation_management.request.dto.VacationRequestResponse;
import com.fractal.domain.vacation_management.request.mapper.VacationRequestMapperService;
import com.fractal.domain.vacation_management.request.state.VacationRequestState;
import com.fractal.domain.vacation_management.request.state.VacationRequestStateService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class VacationRequestServiceImpl implements VacationRequestService {

    private final VacationRequestRepository vacationRequestRepository;
    private final VacationRequestMapperService mapperService;
    private final VacationRequestStateService stateService;

    @Override
    public VacationRequest create(VacationRequestRequest dto) {
        var request = save(mapperService.toEntity(dto));
        stateService.create(request);
        return request;
    }

    @Override
    public List<VacationRequest> getAll() {
        return vacationRequestRepository.findAll();
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
          var request =  save(mapperService.toEntity(findById(id),dto));
          stateService.create(request);
          return request;
       }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        vacationRequestRepository.delete(findById(id));
    }

    public VacationRequestResponse toDTO(VacationRequest vacationRequest) {
        return mapperService.toDTO(vacationRequest);
    }

    @Override
    public VacationRequest save(VacationRequest vacationRequest) {
        try {
            return vacationRequestRepository.save(vacationRequest);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private VacationRequest findById(Long id) {
        return vacationRequestRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

}
