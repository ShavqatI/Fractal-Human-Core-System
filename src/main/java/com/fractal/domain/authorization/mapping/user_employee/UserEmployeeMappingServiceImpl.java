package com.fractal.domain.authorization.mapping.user_employee;

import com.fractal.domain.authorization.mapping.user_employee.dto.UserEmployeeMappingRequest;
import com.fractal.domain.authorization.mapping.user_employee.dto.UserEmployeeMappingResponse;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.authorization.user.UserService;
import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class UserEmployeeMappingServiceImpl implements UserEmployeeMappingService {

    private final UserEmployeeMappingRepository userEmployeeMappingRepository;
    private final UserService userService;
    private final EmployeeService employeeService;
    private final StatusService statusService;

    @Override
    public UserEmployeeMapping create(UserEmployeeMappingRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<UserEmployeeMapping> getAll() {
        return userEmployeeMappingRepository.findAll();
    }


    @Override
    public UserEmployeeMapping getById(Long id) {
        return findById(id);
    }

    @Override
    public UserEmployeeMapping getByUserId(Long userId) {
        return userEmployeeMappingRepository.findByUserId(userId).orElseThrow(()-> new ResourceNotFoundException("User with id: " + userId +" in UserEmployeeMapping not found"));
    }

    @Override
    public Employee getEmployee(User user) {
        return userEmployeeMappingRepository.findByUserId(user.getId()).get().getEmployee();
    }

    @Override
    public UserEmployeeMapping update(Long id, UserEmployeeMappingRequest dto) {
        try {
            UserEmployeeMapping userEmployeeMapping = findById(id);
            userEmployeeMapping.setUser(userService.getById(dto.userId()));
            userEmployeeMapping.setEmployee(employeeService.getById(dto.employeeId()));
            userEmployeeMapping.setStatus(statusService.getById(dto.statusId()));
            return save(userEmployeeMapping);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        userEmployeeMappingRepository.delete(findById(id));
    }

    @Override
    public UserEmployeeMappingResponse toDTO(UserEmployeeMapping userEmployeeMapping) {
        return new UserEmployeeMappingResponse(
                userEmployeeMapping.getId(),
                userService.toCompactDTO(userEmployeeMapping.getUser()),
                employeeService.toCompactDTO(userEmployeeMapping.getEmployee()),
                statusService.toCompactDTO(userEmployeeMapping.getStatus()),
                userEmployeeMapping.getCreatedDate()
        );
    }

    private UserEmployeeMapping toEntity(UserEmployeeMappingRequest dto) {
        return UserEmployeeMapping.builder()
                .user(userService.getById(dto.userId()))
                .employee(employeeService.getById(dto.employeeId()))
                .status(statusService.getById(dto.statusId()))
                .build();
    }

    private UserEmployeeMapping save(UserEmployeeMapping userEmployeeMapping) {
        try {
            return userEmployeeMappingRepository.save(userEmployeeMapping);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private UserEmployeeMapping findById(Long id) {
        return userEmployeeMappingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserEmployeeMapping  with id: " + id + " not found"));
    }
}
