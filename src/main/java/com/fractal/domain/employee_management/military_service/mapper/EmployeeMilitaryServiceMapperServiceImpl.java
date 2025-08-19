package com.fractal.domain.employee_management.military_service.mapper;

import com.fractal.domain.employee_management.military_service.EmployeeMilitaryService;
import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;
import com.fractal.domain.military_service.mapper.MilitaryServiceMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeMilitaryServiceMapperServiceImpl implements EmployeeMilitaryServiceMapperService {

    private final MilitaryServiceMapperService mapperService;

    @Override
    public MilitaryServiceResponse toDTO(EmployeeMilitaryService militaryService) {
        return mapperService.toDTO(militaryService);
    }

    @Override
    public EmployeeMilitaryService toEntity(MilitaryServiceRequest dto) {
        return (EmployeeMilitaryService) mapperService.toEntity(dto);
    }

    @Override
    public EmployeeMilitaryService toEntity(EmployeeMilitaryService militaryService, MilitaryServiceRequest dto) {
        return (EmployeeMilitaryService) mapperService.toEntity(militaryService,dto);
    }


}
