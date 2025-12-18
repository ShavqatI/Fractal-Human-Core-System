package com.fractal.domain.employee_management.language_skill;

import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.employee_management.employee.EmployeeService;
import com.fractal.domain.employee_management.language_skill.mapper.EmployeeLanguageSkillMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class EmployeeLanguageSkillServiceImpl implements EmployeeLanguageSkillService {

    private final EmployeeLanguageSkillRepository languageSkillRepository;
    private final EmployeeLanguageSkillMapperService mapperService;
    private final EmployeeService employeeService;

    @Override
    @Transactional
    public EmployeeLanguageSkill create(Long employeeId, LanguageSkillRequest dto) {
        var candidate = employeeService.getById(employeeId);
        var languageSkill = mapperService.toEntity(dto);
        candidate.addLanguageSkill(languageSkill);
        employeeService.save(candidate);
        return languageSkill;
    }

    @Override
    public List<EmployeeLanguageSkill> getAllByEmployeeId(Long employeeId) {
        return languageSkillRepository.findAllByEmployeeId(employeeId);
    }

    @Override
    public EmployeeLanguageSkill getById(Long employeeId, Long id) {
        return languageSkillRepository.findByEmployeeIdAndId(employeeId, id).orElseThrow(() -> new ResourceNotFoundException("Military Service with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public EmployeeLanguageSkill update(Long employeeId, Long id, LanguageSkillRequest dto) {
        var candidate = employeeService.getById(employeeId);
        var languageSkill = candidate.getLanguageSkills()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Language Skill with id: " + id + " not found"));
        languageSkill = mapperService.toEntity(languageSkill, dto);
        employeeService.save(candidate);
        return languageSkill;
    }

    @Override
    @Transactional
    public void delete(Long employeeId, Long id) {
        var candidate = employeeService.getById(employeeId);
        var languageSkill = candidate.getLanguageSkills()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Language Skill with id: " + id + " not found"));
        candidate.removeLanguageSkill(languageSkill);
        employeeService.save(candidate);
    }

    @Override
    public LanguageSkillResponse toDTO(EmployeeLanguageSkill employeeLanguageSkill) {
        return mapperService.toDTO(employeeLanguageSkill);
    }


    @Override
    public EmployeeLanguageSkill getById(Long id) {
        return findById(id);
    }

    @Override
    public EmployeeLanguageSkill save(EmployeeLanguageSkill employeeLanguageSkill) {
        try {
            return languageSkillRepository.save(employeeLanguageSkill);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private EmployeeLanguageSkill findById(Long id) {
        return languageSkillRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Language Skill  with id: " + id + " not found"));
    }
}
