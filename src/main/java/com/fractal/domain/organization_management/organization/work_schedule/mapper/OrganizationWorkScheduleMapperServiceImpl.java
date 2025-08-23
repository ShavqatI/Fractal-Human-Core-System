package com.fractal.domain.organization_management.organization.work_schedule.mapper;

import com.fractal.domain.contact.Contact;
import com.fractal.domain.contact.dto.ContactRequest;
import com.fractal.domain.contact.dto.ContactResponse;
import com.fractal.domain.contact.mapper.ContactMapperService;
import com.fractal.domain.employee_management.work_experience.EmployeeWorkExperience;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;
import com.fractal.domain.organization_management.organization.work_schedule.OrganizationWorkSchedule;
import com.fractal.domain.work_schedule.WorkSchedule;
import com.fractal.domain.work_schedule.dto.WorkScheduleRequest;
import com.fractal.domain.work_schedule.dto.WorkScheduleResponse;
import com.fractal.domain.work_schedule.mapper.WorkScheduleMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class OrganizationWorkScheduleMapperServiceImpl implements OrganizationWorkScheduleMapperService {

    private final WorkScheduleMapperService mapperService;
    @Override
    public WorkScheduleResponse toDTO(OrganizationWorkSchedule workSchedule) {
        return mapperService.toDTO(workSchedule);
    }

    @Override
    public OrganizationWorkSchedule toEntity(WorkScheduleRequest dto) {
        return convert(new OrganizationWorkSchedule(),mapperService.toEntity(dto));
    }

    @Override
    public OrganizationWorkSchedule toEntity(OrganizationWorkSchedule workSchedule, WorkScheduleRequest dto) {
        return convert(workSchedule,mapperService.toEntity(workSchedule,dto));
    }


    private OrganizationWorkSchedule convert(OrganizationWorkSchedule organizationWorkSchedule, WorkSchedule workSchedule) {
        organizationWorkSchedule.setWeekDay(workSchedule.getWeekDay());
        organizationWorkSchedule.setStartTime(workSchedule.getStartTime());
        organizationWorkSchedule.setEndTime(workSchedule.getEndTime());
        organizationWorkSchedule.setStatus(workSchedule.getStatus());
        return organizationWorkSchedule;
    }
}
