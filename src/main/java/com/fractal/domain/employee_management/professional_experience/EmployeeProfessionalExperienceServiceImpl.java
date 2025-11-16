package com.fractal.domain.employee_management.professional_experience;

import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.professional_experience.dto.EmployeeProfessionalExperienceRequest;
import com.fractal.domain.employee_management.professional_experience.dto.EmployeeProfessionalExperienceResponse;
import com.fractal.domain.employee_management.professional_experience.mapper.EmployeeProfessionalExperienceMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeProfessionalExperienceServiceImpl implements EmployeeProfessionalExperienceService {

    private final EmployeeProfessionalExperienceRepository professionalExperienceRepository;
    private final EmployeeProfessionalExperienceMapperService mapperService;
    private final EmployeeService employeeService;

    @Override
    public EmployeeProfessionalExperience create(Long employeeId, EmployeeProfessionalExperienceRequest dto) {
        var employee = employeeService.getById(employeeId);
        var professionalExperience = mapperService.toEntity(dto);
        employee.addProfessionalExperience(professionalExperience);
        employeeService.save(employee);
        return professionalExperience;
    }

    @Override
    public List<EmployeeProfessionalExperience> getAllByCandidateId(Long employeeId) {
        return professionalExperienceRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public EmployeeProfessionalExperience getById(Long employeeId, Long id) {
        return professionalExperienceRepository.findByEmployeeIdAndId(employeeId,id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }

    @Override
    public EmployeeProfessionalExperience update(Long employeeId, Long id, EmployeeProfessionalExperienceRequest dto) {
        var employee = employeeService.getById(employeeId);
        var professionalExperience = employee.getProfessionalExperiences()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        professionalExperience = mapperService.toEntity(professionalExperience,dto);
        professionalExperienceRepository.save(professionalExperience);
        employeeService.save(employee);
        return professionalExperience;
    }

    @Override
    public void delete(Long employeeId, Long id) {
        var employee = employeeService.getById(employeeId);
        var professionalExperience = employee.getProfessionalExperiences()
                .stream()
                .filter(m-> m.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
        employee.removeProfessionalExperience(professionalExperience);
        employeeService.save(employee);
    }

    @Override
    public EmployeeProfessionalExperienceResponse toDTO(EmployeeProfessionalExperience professionalExperience) {
        return mapperService.toDTO(professionalExperience);
    }

}
