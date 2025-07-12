package com.fractal.domain.employee_management.subordinate;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.subordinate.dto.SubordinateRequest;
import com.fractal.domain.employee_management.subordinate.dto.SubordinateResponse;
import com.fractal.domain.employee_management.subordinate.type.SubordinateTypeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class SubordinateServiceImpl implements SubordinateService {

    private final SubordinateRepository subordinateRepository;
    private final SubordinateTypeService subordinateTypeService;
    private final EmployeeService employeeService;
    private final StatusService statusService;

    @Override
    public Subordinate create(SubordinateRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<Subordinate> getAll() {
        return subordinateRepository.findAll();
    }

    @Override
    public Subordinate getById(Long id) {
        return findById(id);
    }

    @Override
    public List<Subordinate> getAllByEmployeeId(Long employeeId) {
        return subordinateRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public Subordinate update(Long id, SubordinateRequest dto) {
        try {
         Subordinate subordinate = findById(id);
         subordinate.setEmployee(employeeService.getById(dto.employeeId()));
         subordinate.setSubordinateEmployee(employeeService.getById(dto.subordinateEmployeeId()));
         subordinate.setSubordinateType(subordinateTypeService.getById(dto.subordinateTypeId()));
         subordinate.setStatus(statusService.getById(dto.statusId()));
         subordinate.setStartDate(dto.startDate());
         subordinate.setEndDate(dto.endDate());
        return save(subordinate);
       }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        subordinateRepository.delete(findById(id));
    }

    public SubordinateResponse toDTO(Subordinate subordinate) {
        return new SubordinateResponse(
                subordinate.getId(),
                subordinate.getEmployee().getFirstName(),
                subordinate.getSubordinateEmployee().getFirstName(),
                subordinate.getSubordinateType().getName(),
                subordinate.getStatus().getName(),
                subordinate.getStartDate(),
                subordinate.getEndDate(),
                subordinate.getCreatedDate()
        );
    }

    private Subordinate toEntity(SubordinateRequest dto) {
        return Subordinate.builder()
                .employee(employeeService.getById(dto.employeeId()))
                .subordinateEmployee(employeeService.getById(dto.subordinateEmployeeId()))
                .subordinateType(subordinateTypeService.getById(dto.subordinateEmployeeId()))
                .status(statusService.getById(dto.statusId()))
                .startDate(dto.startDate())
                .endDate(dto.endDate())
                .build();
    }

    private Subordinate save(Subordinate subordinate) {
        try {
            return subordinateRepository.save(subordinate);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private Subordinate findById(Long id) {
        return subordinateRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Subordinate with id: " + id + " not found"));
    }

}
