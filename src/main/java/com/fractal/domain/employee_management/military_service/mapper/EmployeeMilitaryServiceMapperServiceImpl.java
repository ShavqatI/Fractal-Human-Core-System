package com.fractal.domain.employee_management.military_service.mapper;

import com.fractal.domain.employee_management.military_service.EmployeeMilitaryService;
import com.fractal.domain.military_service.MilitaryService;
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
        return convert(new EmployeeMilitaryService(),mapperService.toEntity(dto));
    }

    @Override
    public EmployeeMilitaryService toEntity(EmployeeMilitaryService militaryService, MilitaryServiceRequest dto) {
        return convert(militaryService,mapperService.toEntity(militaryService,dto));
    }

    private EmployeeMilitaryService convert(EmployeeMilitaryService employeeMilitaryService, MilitaryService militaryService) {
        employeeMilitaryService.setAccountNumber(militaryService.getAccountNumber());
        employeeMilitaryService.setTitle(militaryService.getTitle());
        employeeMilitaryService.setCategoryFund(militaryService.getCategoryFund());
        employeeMilitaryService.setAddress(militaryService.getAddress());
        employeeMilitaryService.setBeginDate(militaryService.getBeginDate());
        employeeMilitaryService.setEndDate(militaryService.getEndDate());
        employeeMilitaryService.setResources(militaryService.getResources());
        return employeeMilitaryService;
    }

}
