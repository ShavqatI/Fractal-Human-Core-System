package com.fractal.domain.employee_management.employment.state;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmployeeEmploymentStateServiceImpl implements EmployeeEmploymentStateService {

    private final EmployeeEmploymentStateRepository stateRepository;
    private final StatusService statusService;

    @Override
    public EmployeeEmploymentState create(EmployeeEmployment employeeEmployment) {
        var state = EmployeeEmploymentState.builder()
                .employeeEmployment(employeeEmployment)
                .status(employeeEmployment.getStatus())
                .build();
        return save(state);
    }

    @Override
    public List<EmployeeEmploymentState> getAll() {
        return stateRepository.findAll();
    }

    @Override
    public EmployeeEmploymentState getById(Long id) {
        return findById(id);
    }

    @Override
    public List<EmployeeEmploymentState> getAllByEmployeeEmploymentId(Long employeeEmploymentId) {
        return stateRepository.findAllByEmployeeEmploymentId(employeeEmploymentId);
    }

    @Override
    public EmployeeEmploymentState update(Long id, EmployeeEmployment employeeEmployment) {
        try {
            EmployeeEmploymentState state = findById(id);
            state.setEmployeeEmployment(employeeEmployment);
            state.setStatus(employeeEmployment.getStatus());
            return save(state);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        stateRepository.delete(findById(id));
    }

    public EmployeeEmploymentStateResponse toDTO(EmployeeEmploymentState state) {
        return new EmployeeEmploymentStateResponse(
                state.getId(),
                statusService.toCompactDTO(state.getStatus()),
                state.getCreatedDate()
        );
    }

    @Override
    public EmployeeEmploymentState save(EmployeeEmploymentState state) {
        try {
            return stateRepository.save(state);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private EmployeeEmploymentState findById(Long id) {
        return stateRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }


}
