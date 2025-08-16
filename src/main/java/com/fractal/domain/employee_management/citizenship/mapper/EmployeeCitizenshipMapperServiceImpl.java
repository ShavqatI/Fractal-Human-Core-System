package com.fractal.domain.employee_management.citizenship.mapper;

import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.citizenship.mapper.CitizenshipMapperService;
import com.fractal.domain.employee_management.citizenship.EmployeeCitizenship;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeCitizenshipMapperServiceImpl implements EmployeeCitizenshipMapperService {


    private final CitizenshipMapperService citizenshipMapperService;
    @Override
    public CitizenshipResponse toDTO(EmployeeCitizenship citizenship) {
        return citizenshipMapperService.toDTO(citizenship);
    }

    @Override
    public EmployeeCitizenship toEntity(CitizenshipRequest dto) {
        return (EmployeeCitizenship) citizenshipMapperService.toEntity(dto);
    }

    @Override
    public EmployeeCitizenship toEntity(EmployeeCitizenship citizenship, CitizenshipRequest dto) {
        return (EmployeeCitizenship) citizenshipMapperService.toEntity(citizenship,dto);
    }
}
