package com.fractal.domain.organization_management.organization.work_schedule;

import com.fractal.domain.organization_management.organization.OrganizationService;
import com.fractal.domain.organization_management.organization.work_schedule.mapper.OrganizationWorkScheduleMapperService;
import com.fractal.domain.work_schedule.dto.WorkScheduleRequest;
import com.fractal.domain.work_schedule.dto.WorkScheduleResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationWorkScheduleServiceImpl implements OrganizationWorkScheduleService {

    private final OrganizationWorkScheduleRepository workScheduleRepository;
    private final OrganizationWorkScheduleMapperService mapperService;
    private final OrganizationService organizationService;

    @Override
    @Transactional
    public OrganizationWorkSchedule create(Long organizationId, WorkScheduleRequest dto) {
        var organization = organizationService.getById(organizationId);
        var workSchedule = mapperService.toEntity(dto);
        organization.addWorkSchedule(workSchedule);
        organizationService.save(organization);
        return workSchedule;
    }

    @Override
    public List<OrganizationWorkSchedule> getAllByOrganizationId(Long organizationId) {
        return workScheduleRepository.findAllByOrganizationId(organizationId);
    }

    @Override
    public OrganizationWorkSchedule getById(Long organizationId, Long id) {
        return workScheduleRepository.findByOrganizationIdAndId(organizationId,id).orElseThrow(()-> new ResourceNotFoundException("Organization work schedule with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public OrganizationWorkSchedule update(Long organizationId, Long id, WorkScheduleRequest dto) {
        var organization = organizationService.getById(organizationId);
        var workSchedule = organization.getWorkSchedules()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Organization work schedule with id: " + id + " not found"));
        workSchedule = workScheduleRepository.save(mapperService.toEntity(workSchedule,dto));
        organizationService.save(organization);
        return workSchedule;
    }

    @Override
    public void delete(Long organizationId, Long id) {
        var organization = organizationService.getById(organizationId);
        var workSchedule = organization.getWorkSchedules()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Organization work schedule with id: " + id + " not found"));
        organization.removeWorkSchedule(workSchedule);
        organizationService.save(organization);
    }

    @Override
    public WorkScheduleResponse toDTO(OrganizationWorkSchedule workSchedule) {
        return mapperService.toDTO(workSchedule);
    }
}
