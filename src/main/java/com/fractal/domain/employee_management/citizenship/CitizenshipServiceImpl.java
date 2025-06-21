package com.fractal.domain.employee_management.citizenship;

import com.fractal.domain.employee_management.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.employee_management.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.employee_management.citizenship.mapper.CitizenshipMapperService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class CitizenshipServiceImpl implements CitizenshipService {

    private final CitizenshipRepository citizenshipRepository;
    private final EmployeeService employeeService;
    private final CitizenshipMapperService mapperService;


    @Override
    @Transactional
    public Citizenship create(Long employeeId, CitizenshipRequest dto) {
        var employee = employeeService.getById(employeeId);
        var citizenship = mapperService.toEntity(dto);
        employee.addCitizenship(citizenship);
        employeeService.save(employee);
       return citizenship;
    }

    @Override
    public List<Citizenship> getAllByEmployeeId(Long employeeId) {
        return citizenshipRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public Citizenship getById(Long employeeId, Long id) {
        return citizenshipRepository.findByEmployeeIdAndId(employeeId,id).orElseThrow(()-> new ResourceNotFoundException("Citizenship with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public Citizenship update(Long employeeId, Long id, CitizenshipRequest dto) {
        var employee = employeeService.getById(employeeId);
        var citizenship = employee.getCitizenships()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Citizenship with id: " + id + " not found"));
        citizenship = mapperService.toEntity(citizenship,dto);
        citizenshipRepository.save(citizenship);
        employeeService.save(employee);
       return citizenship;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var employee = employeeService.getById(employeeId);
        var citizenship = employee.getCitizenships()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Citizenship with id: " + id + " not found"));
        employee.removeCitizenship(citizenship);
        citizenshipRepository.delete(citizenship);
        employeeService.save(employee);
    }

    @Override
    public CitizenshipResponse toDTO(Citizenship citizenship) {
        return mapperService.toDTO(citizenship);
    }

}
