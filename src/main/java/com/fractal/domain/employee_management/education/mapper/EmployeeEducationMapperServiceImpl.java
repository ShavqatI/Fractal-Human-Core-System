package com.fractal.domain.employee_management.education.mapper;

import com.fractal.domain.education.Education;
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
        return convert(new EmployeeEducation(),educationMapperService.toEntity(dto));
    }

    @Override
    public EmployeeEducation toEntity(EmployeeEducation education, EducationRequest dto) {
        return convert(education,educationMapperService.toEntity(education,dto));
    }

    @Override
    public EmployeeEducation convert(EmployeeEducation employeeEducation, Education education) {
        employeeEducation.setEducationType(education.getEducationType());
        employeeEducation.setEducationDocumentType(education.getEducationDocumentType());
        employeeEducation.setBeginDate(education.getBeginDate());
        employeeEducation.setEndDate(education.getEndDate());
        employeeEducation.setInstitutionName(education.getInstitutionName());
        employeeEducation.setInstitutionAddress(education.getInstitutionAddress());
        employeeEducation.setIsForeignInstitution(education.getIsForeignInstitution());
        employeeEducation.setSpecialization(education.getSpecialization());
        employeeEducation.setDegreeType(education.getDegreeType());
        employeeEducation.setGradePointAverage(education.getGradePointAverage());
        employeeEducation.setAccreditationStatus(education.getAccreditationStatus());
        employeeEducation.setDocumentVerified(education.getDocumentVerified());
        employeeEducation.setVerificationNotes(education.getVerificationNotes());
        employeeEducation.setStatus(education.getStatus());
        employeeEducation.setResources(education.getResources());
        return employeeEducation;
    }




}
