package com.fractal.domain.employment.state;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employment.Employment;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmploymentStateServiceImpl implements EmploymentStateService {

    private final EmploymentStateRepository stateRepository;
    private final StatusService statusService;

    @Override
    public EmploymentState create(Employment employment) {
        var state = EmploymentState.builder()
                .employment(employment)
                .status(employment.getStatus())
                .build();
        return save(state);
    }

    @Override
    public List<EmploymentState> getAll() {
        return stateRepository.findAll();
    }

    @Override
    public EmploymentState getById(Long id) {
        return findById(id);
    }

    @Override
    public List<EmploymentState> getAllByEmploymentId(Long compensationComponentId) {
        return stateRepository.findAllByEmploymentId(compensationComponentId);
    }

    @Override
    public EmploymentState update(Long id, Employment employment) {
        try {
            EmploymentState state = findById(id);
            state.setEmployment(employment);
            state.setStatus(employment.getStatus());
            return save(state);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        stateRepository.delete(findById(id));
    }

    public EmploymentStateResponse toDTO(EmploymentState state) {
        return new EmploymentStateResponse(
                state.getId(),
                statusService.toCompactDTO(state.getStatus()),
                state.getCreatedDate()
        );
    }

    @Override
    public EmploymentState save(EmploymentState state) {
        try {
            return stateRepository.save(state);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private EmploymentState findById(Long id) {
        return stateRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }


}
