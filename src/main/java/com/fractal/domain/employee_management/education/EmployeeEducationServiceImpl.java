package com.fractal.domain.employee_management.education;

import com.fractal.domain.employee_management.education.dto.EducationRequest;
import com.fractal.domain.employee_management.education.dto.EducationResponse;
import com.fractal.domain.employee_management.education.mapper.EmployeeEducationMapperService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmployeeEducationServiceImpl implements EmployeeEducationService {

    private final EmployeeEducationRepository employeeEducationRepository;
    private final EmployeeEducationMapperService mapperService;
    private final EmployeeService employeeService;

    @Override
    @Transactional
    public EmployeeEducation create(Long employeeId, EducationRequest dto) {
        var employee = employeeService.getById(employeeId);
        var education = mapperService.toEntity(dto);
        employee.addEducation(education);
        employeeService.save(employee);
       return education;
    }

    @Override
    public List<EmployeeEducation> getAllByEmployeeId(Long employeeId) {
        return employeeEducationRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public EmployeeEducation getById(Long employeeId, Long id) {
        return employeeEducationRepository.findByEmployeeIdAndId(employeeId,id).orElseThrow(()-> new ResourceNotFoundException("Education with id: " + id + " not found"));
    }

    @Override
    public EmployeeEducation getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public EmployeeEducation update(Long employeeId, Long id, EducationRequest dto) {
        var employee = employeeService.getById(employeeId);
        var education = employee.getEducations()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education with id: " + id + " not found"));
        education = employeeEducationRepository.save(mapperService.toEntity(education,dto));
        employeeService.save(employee);
        return education;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var employee = employeeService.getById(employeeId);
        var education = employee.getEducations()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education with id: " + id + " not found"));
        employee.removeEducation(education);
        employeeService.save(employee);
    }

    @Override
    public EducationResponse toDTO(EmployeeEducation employeeEducation) {
        return mapperService.toDTO(employeeEducation);
    }

    @Override
    public EmployeeEducation save(EmployeeEducation employeeEducation) {
        try {
            return employeeEducationRepository.save(employeeEducation);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    private EmployeeEducation findById(Long id) {
        return employeeEducationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Education History with id: " + id + " not found"));
    }
}
