package com.fractal.domain.employee_management.citizenship.mapper;

import com.fractal.domain.employee_management.citizenship.Citizenship;
import com.fractal.domain.employee_management.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.employee_management.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.location.country.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CitizenshipMapperServiceImpl implements CitizenshipMapperService {
    private final CountryService countryService;

    @Override
    public CitizenshipResponse toDTO(Citizenship citizenship) {
        return new CitizenshipResponse(citizenship.getCountry().getName());
    }

    @Override
    public Citizenship toEntity(CitizenshipRequest dto) {
        return mapToEntity(new Citizenship(),dto);
    }

    @Override
    public Citizenship toEntity(Citizenship citizenship, CitizenshipRequest dto) {
        return mapToEntity(citizenship,dto);
    }

    private Citizenship mapToEntity(Citizenship citizenship, CitizenshipRequest dto) {
        citizenship.setCountry(countryService.getById(dto.countryId()));
        return citizenship;
    }
}
