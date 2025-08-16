package com.fractal.domain.education;

import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.education.mapper.EducationMapperService;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;
    private final EducationMapperService mapperService;
    private final EmployeeService employeeService;
/*
    @Override
    @Transactional
    public Education create(Long employeeId, EducationRequest dto) {
        var employee = employeeService.getById(employeeId);
        var education = mapperService.toEntity(dto);
        employee.addEducation(education);
        employeeService.save(employee);
       return education;
    }

    @Override
    public List<Education> getAllByEmployeeId(Long employeeId) {
        return educationRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public Education getById(Long employeeId, Long id) {
        return educationRepository.findByEmployeeIdAndId(employeeId,id).orElseThrow(()-> new ResourceNotFoundException("Education with id: " + id + " not found"));
    }

    @Override
    public Education getById(Long id) {
        return findById(id);
    }

    @Override
    @Transactional
    public Education update(Long employeeId, Long id, EducationRequest dto) {
        var employee = employeeService.getById(employeeId);
        var education = employee.getEmployeeEducations()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education with id: " + id + " not found"));
        education = educationRepository.save(mapperService.toEntity(education,dto));
        employeeService.save(employee);
        return education;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var employee = employeeService.getById(employeeId);
        var education = employee.getEmployeeEducations()
                .stream()
                .filter(e-> e.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education with id: " + id + " not found"));
        employee.removeEducation(education);
        educationRepository.delete(education);
        employeeService.save(employee);
    }*/

    @Override
    public Education getById(Long id) {
        return findById(id);
    }

    @Override
    public EducationResponse toDTO(Education education) {
        return mapperService.toDTO(education);
    }

    @Override
    public Education save(Education education) {
        try {
            return educationRepository.save(education);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    private Education findById(Long id) {
        return educationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Education History with id: " + id + " not found"));
    }
}
