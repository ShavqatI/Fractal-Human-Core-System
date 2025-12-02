package com.fractal.domain.employment.internal.compensation_component.state;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponent;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CompensationComponentStateServiceImpl implements CompensationComponentStateService {

    private final CompensationComponentRepository stateRepository;
    private final StatusService statusService;

    @Override
    public CompensationComponentState create(CompensationComponent compensationComponent) {
        var state = CompensationComponentState.builder()
                .compensationComponent(compensationComponent)
                .status(compensationComponent.getStatus())
                .build();
        return save(state);
    }

    @Override
    public List<CompensationComponentState> getAll() {
        return stateRepository.findAll();
    }

    @Override
    public CompensationComponentState getById(Long id) {
        return findById(id);
    }

    @Override
    public List<CompensationComponentState> getAllByCompensationComponentId(Long compensationComponentId) {
        return stateRepository.findAllByCompensationComponentId(compensationComponentId);
    }

    @Override
    public CompensationComponentState update(Long id, CompensationComponent compensationComponent) {
        try {
            CompensationComponentState state = findById(id);
            state.setCompensationComponent(compensationComponent);
            state.setStatus(compensationComponent.getStatus());
            return save(state);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        stateRepository.delete(findById(id));
    }

    public CompensationComponentStateResponse toDTO(CompensationComponentState state) {
        return new CompensationComponentStateResponse(
                state.getId(),
                statusService.toCompactDTO(state.getStatus()),
                state.getCreatedDate()
        );
    }

    @Override
    public CompensationComponentState save(CompensationComponentState state) {
        try {
            return stateRepository.save(state);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private CompensationComponentState findById(Long id) {
        return stateRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }


}
