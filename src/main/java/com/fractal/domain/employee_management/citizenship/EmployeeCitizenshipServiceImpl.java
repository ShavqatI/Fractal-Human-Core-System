package com.fractal.domain.employee_management.citizenship;

import com.fractal.domain.employee_management.citizenship.dto.EmployeeCitizenshipRequest;
import com.fractal.domain.employee_management.citizenship.dto.EmployeeCitizenshipResponse;
import com.fractal.domain.employee_management.citizenship.mapper.EmployeeCitizenshipMapperService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmployeeCitizenshipServiceImpl implements EmployeeCitizenshipService {

    private final EmployeeCitizenshipRepository employeeCitizenshipRepository;
    private final EmployeeService employeeService;
    private final EmployeeCitizenshipMapperService mapperService;


    @Override
    @Transactional
    public EmployeeCitizenship create(Long employeeId, EmployeeCitizenshipRequest dto) {
        var employee = employeeService.getById(employeeId);
        var citizenship = mapperService.toEntity(dto);
        employee.addCitizenship(citizenship);
        employeeService.save(employee);
       return citizenship;
    }

    @Override
    public List<EmployeeCitizenship> getAllByEmployeeId(Long employeeId) {
        return employeeCitizenshipRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public EmployeeCitizenship getById(Long employeeId, Long id) {
        return employeeCitizenshipRepository.findByEmployeeIdAndId(employeeId,id).orElseThrow(()-> new ResourceNotFoundException("Citizenship with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public EmployeeCitizenship update(Long employeeId, Long id, EmployeeCitizenshipRequest dto) {
        var employee = employeeService.getById(employeeId);
        var citizenship = employee.getEmployeeCitizenships()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Citizenship with id: " + id + " not found"));
        citizenship = employeeCitizenshipRepository.save(mapperService.toEntity(citizenship,dto));
        employeeService.save(employee);
       return citizenship;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var employee = employeeService.getById(employeeId);
        var citizenship = employee.getEmployeeCitizenships()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Citizenship with id: " + id + " not found"));
        employee.removeCitizenship(citizenship);
        employeeCitizenshipRepository.delete(citizenship);
        employeeService.save(employee);
    }

    @Override
    public EmployeeCitizenshipResponse toDTO(EmployeeCitizenship employeeCitizenship) {
        return mapperService.toDTO(employeeCitizenship);
    }

}
