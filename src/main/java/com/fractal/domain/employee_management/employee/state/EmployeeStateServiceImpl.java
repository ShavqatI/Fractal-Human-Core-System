package com.fractal.domain.employee_management.employee.state;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmployeeStateServiceImpl implements EmployeeStateService {

    private final EmployeeStateRepository stateRepository;
    private final StatusService statusService;

    @Override
    public EmployeeState create(Employee employee) {
        var state = EmployeeState.builder()
                .employee(employee)
                .status(employee.getStatus())
                .build();
        return save(state);
    }

    @Override
    public List<EmployeeState> getAll() {
        return stateRepository.findAll();
    }

    @Override
    public EmployeeState getById(Long id) {
        return findById(id);
    }

    @Override
    public List<EmployeeState> getAllByEmployeeId(Long employeeId) {
        return stateRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public EmployeeState update(Long id, Employee employee) {
        try {
            EmployeeState state = findById(id);
            state.setEmployee(employee);
            state.setStatus(employee.getStatus());
            return save(state);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        stateRepository.delete(findById(id));
    }

    public EmployeeStateResponse toDTO(EmployeeState state) {
        return new EmployeeStateResponse(
                state.getId(),
                statusService.toCompactDTO(state.getStatus()),
                state.getCreatedDate()
        );
    }

    @Override
    public EmployeeState save(EmployeeState state) {
        try {
            return stateRepository.save(state);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private EmployeeState findById(Long id) {
        return stateRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }
}
