package com.fractal.domain.employee_management.education.mapper;

import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.education.mapper.EducationMapperService;
import com.fractal.domain.employee_management.education.EmployeeEducation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeEducationMapperServiceImpl implements EmployeeEducationMapperService {

    private final EducationMapperService educationMapperService;
    @Override
    public EducationResponse toDTO(EmployeeEducation education) {
        return educationMapperService.toDTO(education);
    }

    @Override
    public EmployeeEducation toEntity(EducationRequest dto) {
        return (EmployeeEducation) educationMapperService.toEntity(dto);
    }

    @Override
    public EmployeeEducation toEntity(EmployeeEducation education, EducationRequest dto) {
       return (EmployeeEducation) educationMapperService.toEntity(education,dto);
    }



}
