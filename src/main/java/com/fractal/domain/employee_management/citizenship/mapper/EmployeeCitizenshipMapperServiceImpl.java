package com.fractal.domain.employee_management.citizenship.mapper;

import com.fractal.domain.employee_management.citizenship.EmployeeCitizenship;
import com.fractal.domain.employee_management.citizenship.dto.EmployeeCitizenshipRequest;
import com.fractal.domain.employee_management.citizenship.dto.EmployeeCitizenshipResponse;
import com.fractal.domain.location.country.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeCitizenshipMapperServiceImpl implements EmployeeCitizenshipMapperService {

    private final CountryService countryService;

    @Override
    public EmployeeCitizenshipResponse toDTO(EmployeeCitizenship employeeCitizenship) {
        return new EmployeeCitizenshipResponse(employeeCitizenship.getCountry().getName());
    }

    @Override
    public EmployeeCitizenship toEntity(EmployeeCitizenshipRequest dto) {
        return mapToEntity(new EmployeeCitizenship(),dto);
    }

    @Override
    public EmployeeCitizenship toEntity(EmployeeCitizenship employeeCitizenship, EmployeeCitizenshipRequest dto) {
        return mapToEntity(employeeCitizenship,dto);
    }

    private EmployeeCitizenship mapToEntity(EmployeeCitizenship employeeCitizenship, EmployeeCitizenshipRequest dto) {
        employeeCitizenship.setCountry(countryService.getById(dto.countryId()));
        return employeeCitizenship;
    }
}
