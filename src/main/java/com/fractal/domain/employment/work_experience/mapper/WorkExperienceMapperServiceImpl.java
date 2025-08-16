package com.fractal.domain.employment.work_experience.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employment.work_experience.WorkExperience;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;
import com.fractal.domain.employment.type.EmploymentTypeService;
import com.fractal.domain.location.country.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class WorkExperienceMapperServiceImpl implements WorkExperienceMapperService {

    private final CountryService countryService;
    private final StatusService statusService;
    private final EmploymentTypeService employmentTypeService;


    @Override
    public WorkExperienceResponse toDTO(WorkExperience workExperience) {
        return new WorkExperienceResponse(
                workExperience.getId(),
                countryService.toCompactDTO(workExperience.getCountry()),
                workExperience.getLocation(),
                employmentTypeService.toCompactDTO(workExperience.getEmploymentType()),
                workExperience.getStartDate(),
                workExperience.getEndDate(),
                workExperience.getOrganization(),
                workExperience.getDepartment(),
                workExperience.getDivision(),
                workExperience.getPosition(),
                workExperience.getResponsibilities(),
                workExperience.getAchievements(),
                workExperience.getLeaveReason(),
                statusService.toCompactDTO(workExperience.getStatus()),
                workExperience.getCreatedDate()
        );
    }

    @Override
    public WorkExperience toEntity(WorkExperienceRequest dto) {
        return mapToEntity(new WorkExperience(),dto);
    }

    @Override
    public WorkExperience toEntity(WorkExperience workExperience, WorkExperienceRequest dto) {
       return mapToEntity(workExperience,dto);
    }

    private WorkExperience mapToEntity(WorkExperience workExperience, WorkExperienceRequest dto) {
        workExperience.setCountry(countryService.getById(dto.countryId()));
        workExperience.setLocation(dto.location());
        workExperience.setEmploymentType(employmentTypeService.getById(dto.employmentTypeId()));
        workExperience.setStartDate(dto.startDate());
        workExperience.setEndDate(dto.endDate());
        workExperience.setOrganization(dto.organization());
        workExperience.setDepartment(dto.department());
        workExperience.setDivision(dto.division());
        workExperience.setPosition(dto.position());
        workExperience.setResponsibilities(dto.responsibilities());
        workExperience.setAchievements(dto.achievements());
        workExperience.setLeaveReason(dto.leaveReason());
        workExperience.setStatus(statusService.getById(dto.statusId()));
        return workExperience;
    }

}
