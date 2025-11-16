package com.fractal.domain.employee_management.professional_experience.mapper;

import com.fractal.domain.dictionary.industry.IndustryService;
import com.fractal.domain.employee_management.professional_experience.EmployeeProfessionalExperience;
import com.fractal.domain.employee_management.professional_experience.dto.EmployeeProfessionalExperienceRequest;
import com.fractal.domain.employee_management.professional_experience.dto.EmployeeProfessionalExperienceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeProfessionalExperienceMapperServiceImpl implements EmployeeProfessionalExperienceMapperService {

    private final IndustryService industryService;

    @Override
    public EmployeeProfessionalExperienceResponse toDTO(EmployeeProfessionalExperience professionalExperience) {
        return new EmployeeProfessionalExperienceResponse(
                professionalExperience.getId(),
                industryService.toDTO(professionalExperience.getIndustry()),
                professionalExperience.getYears(),
                professionalExperience.getCreatedDate()
        );
    }

    @Override
    public EmployeeProfessionalExperience toEntity(EmployeeProfessionalExperienceRequest dto) {
        return mapToEntity(new EmployeeProfessionalExperience(), dto);
    }


    @Override
    public EmployeeProfessionalExperience toEntity(EmployeeProfessionalExperience professionalExperience, EmployeeProfessionalExperienceRequest dto) {
        return mapToEntity(professionalExperience, dto);
    }

    private EmployeeProfessionalExperience mapToEntity(EmployeeProfessionalExperience professionalExperience, EmployeeProfessionalExperienceRequest dto) {
        professionalExperience.setIndustry(industryService.getById(dto.industryId()));
        professionalExperience.setYears(dto.years());
        return professionalExperience;

    }


}
