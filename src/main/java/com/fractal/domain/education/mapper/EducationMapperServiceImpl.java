package com.fractal.domain.education.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.education.Education;
import com.fractal.domain.education.accreditation_status.AccreditationStatusService;
import com.fractal.domain.education.degree_type.DegreeTypeService;
import com.fractal.domain.education.document_type.EducationDocumentTypeService;
import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.education.grade_point_average.GradePointAverageService;
import com.fractal.domain.education.resource.EducationResource;
import com.fractal.domain.education.resource.mapper.EducationResourceMapperService;
import com.fractal.domain.education.type.EducationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class EducationMapperServiceImpl implements EducationMapperService {

    private final EducationTypeService educationTypeService;
    private final EducationDocumentTypeService educationDocumentTypeService;
    private final DegreeTypeService degreeTypeService;
    private final GradePointAverageService gradePointAverageService;
    private final AccreditationStatusService accreditationStatusService;
    private final EducationResourceMapperService resourceMapperService;
    private final StatusService statusService;


    @Override
    public EducationResponse toDTO(Education education) {
        return new EducationResponse(
                education.getId(),
                educationTypeService.toDTO(education.getEducationType()),
                educationDocumentTypeService.toDTO(education.getEducationDocumentType()),
                education.getBeginDate(),
                education.getEndDate(),
                education.getInstitutionName(),
                education.getInstitutionAddress(),
                education.getIsForeignInstitution(),
                education.getSpecialization(),
                degreeTypeService.toDTO(education.getDegreeType()),
                gradePointAverageService.toDTO(education.getGradePointAverage()),
                accreditationStatusService.toDTO(education.getAccreditationStatus()),
                education.getDocumentVerified(),
                education.getVerificationNotes(),
                statusService.toCompactDTO(education.getStatus()),
                Optional.ofNullable(education.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(resourceMapperService::toDTO)
                        .collect(Collectors.toList()),
                education.getCreatedDate()
        );
    }

    @Override
    public Education toEntity(EducationRequest dto) {
        return mapToEntity(new Education(), dto);
    }

    @Override
    public Education toEntity(Education education, EducationRequest dto) {
        return mapToEntity(education, dto);
    }

    @Override
    public Education copy(Education education) {
        var copy = Education.builder().build();
        copy.setEducationType(education.getEducationType());
        copy.setEducationDocumentType(education.getEducationDocumentType());
        copy.setBeginDate(education.getBeginDate());
        copy.setEndDate(education.getEndDate());
        copy.setInstitutionName(education.getInstitutionName());
        copy.setInstitutionAddress(education.getInstitutionAddress());
        copy.setIsForeignInstitution(education.getIsForeignInstitution());
        copy.setSpecialization(education.getSpecialization());
        copy.setDegreeType(education.getDegreeType());
        copy.setGradePointAverage(education.getGradePointAverage());
        copy.setAccreditationStatus(education.getAccreditationStatus());
        copy.setDocumentVerified(education.getDocumentVerified());
        copy.setVerificationNotes(education.getVerificationNotes());
        copy.setStatus(education.getStatus());
        var resourceCopy = education.getResources().stream().map(resourceMapperService::copy).collect(Collectors.toCollection(ArrayList::new));
        copy.setResources(resourceCopy);
        return copy;
    }

    private Education mapToEntity(Education education, EducationRequest dto) {
        education.setEducationType(educationTypeService.getById(dto.educationTypeId()));
        education.setEducationDocumentType(educationDocumentTypeService.getById(dto.educationDocumentTypeId()));
        education.setBeginDate(dto.beginDate());
        education.setEndDate(dto.endDate());
        education.setInstitutionName(dto.institutionName());
        education.setInstitutionAddress(dto.institutionAddress());
        education.setIsForeignInstitution(dto.isForeignInstitution());
        education.setSpecialization(dto.specialization());
        education.setDegreeType(degreeTypeService.getById(dto.degreeTypeId()));
        education.setGradePointAverage(gradePointAverageService.getById(dto.gradePointAverageId()));
        education.setAccreditationStatus(accreditationStatusService.getById(dto.accreditationStatusId()));
        education.setDocumentVerified(dto.documentVerified());
        education.setVerificationNotes(dto.verificationNotes());
        education.setStatus(statusService.getById(dto.statusId()));
        dto.files().forEach(file -> education.addResource((EducationResource) resourceMapperService.toEntity(file, null)));
        return education;
    }

}
