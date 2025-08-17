package com.fractal.domain.employee_management.work_experience;

import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.work_experience.mapper.EmployeeWorkExperienceMapperService;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeWorkExperienceServiceImpl implements EmployeeWorkExperienceService {

    private final EmployeeWorkExperienceRepository workExperienceRepository;
    private final EmployeeWorkExperienceMapperService workExperienceMapperService;
    private final EmployeeService employeeService;


    @Override
    @Transactional
    public EmployeeWorkExperience create(Long employeeId, WorkExperienceRequest dto) {
        var employee = employeeService.getById(employeeId);
        var workExperience = workExperienceMapperService.toEntity(dto);
        employee.addWorkExperience(workExperience);
        employeeService.save(employee);
        return workExperience;
    }

    @Override
    public List<EmployeeWorkExperience> getAllByEmployeeId(Long employeeId) {
        return workExperienceRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public EmployeeWorkExperience getById(Long employeeId, Long id) {
        return workExperienceRepository.findByEmployeeIdAndId(employeeId,id).orElseThrow(()-> new ResourceNotFoundException("Candidate Work Experience  with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public EmployeeWorkExperience update(Long employeeId, Long id, WorkExperienceRequest dto) {
        var employee = employeeService.getById(employeeId);
        var workExperience = employee.getWorkExperiences()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Candidate Work Experience  with id: " + id + " not found"));
        workExperience = workExperienceRepository.save(workExperienceMapperService.toEntity(workExperience,dto));
        employeeService.save(employee);
        return workExperience;
    }

    @Override
    public void delete(Long employeeId, Long id) {
        var employee = employeeService.getById(employeeId);
        var workExperience = employee.getWorkExperiences()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Candidate Work Experience  with id: " + id + " not found"));
        employee.removeWorkExperience(workExperience);
        employeeService.save(employee);
    }

    @Override
    public WorkExperienceResponse toDTO(EmployeeWorkExperience workExperience) {
        return workExperienceMapperService.toDTO(workExperience);
    }
}
