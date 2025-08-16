package com.fractal.domain.recruitment.candidate.education.mapper;

import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.education.mapper.EducationMapperService;
import com.fractal.domain.employee_management.education.EmployeeEducation;
import com.fractal.domain.location.address.type.AddressTypeService;
import com.fractal.domain.location.city.CityService;
import com.fractal.domain.location.country.CountryService;
import com.fractal.domain.location.district.DistrictService;
import com.fractal.domain.location.region.RegionService;
import com.fractal.domain.recruitment.candidate.education.CandidateEducation;
import com.fractal.domain.recruitment.candidate.education.dto.CandidateAddressRequest;
import com.fractal.domain.recruitment.candidate.education.dto.CandidateAddressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateEducationMapperServiceImpl implements CandidateEducationMapperService {

    private final EducationMapperService educationMapperService;
    @Override
    public EducationResponse toDTO(CandidateEducation education) {
        return educationMapperService.toDTO(education);
    }

    @Override
    public CandidateEducation toEntity(EducationRequest dto) {
        return (CandidateEducation) educationMapperService.toEntity(dto);
    }

    @Override
    public CandidateEducation toEntity(CandidateEducation education, EducationRequest dto) {
        return (CandidateEducation) educationMapperService.toEntity(education,dto);
    }

}
