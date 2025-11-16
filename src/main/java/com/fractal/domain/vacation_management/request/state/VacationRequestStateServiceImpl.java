package com.fractal.domain.vacation_management.request.state;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.vacation_management.request.VacationRequest;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class VacationRequestStateServiceImpl implements VacationRequestStateService {

    private final VacationRequestStateRepository stateRepository;
    private final StatusService statusService;
    @Override
    public VacationRequestState create(VacationRequest vacationRequest) {
        var state = VacationRequestState.builder()
                .vacationRequest(vacationRequest)
                .status(vacationRequest.getStatus())
                .build();
        return save(state);
    }
    @Override
    public List<VacationRequestState> getAll() {
        return stateRepository.findAll();
    }

    @Override
    public VacationRequestState getById(Long id) {
        return findById(id);
    }

    @Override
    public List<VacationRequestState> getAllByVacationRequestId(Long vacationRequestId) {
        return stateRepository.findAllByVacationRequestId(vacationRequestId);
    }

    @Override
    public VacationRequestState update(Long id, VacationRequest vacationRequest) {
        try {
            VacationRequestState state = findById(id);
            state.setVacationRequest(vacationRequest);
            state.setStatus(vacationRequest.getStatus());
            return save(state);
       }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        stateRepository.delete(findById(id));
    }

    public VacationRequestStateResponse toDTO(VacationRequestState state) {
     return new VacationRequestStateResponse(
             state.getId(),
             statusService.toCompactDTO(state.getStatus()),
             state.getCreatedDate()
     );
    }

    @Override
    public VacationRequestState save(VacationRequestState state) {
        try {
            return stateRepository.save(state);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private VacationRequestState findById(Long id) {
        return stateRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}
