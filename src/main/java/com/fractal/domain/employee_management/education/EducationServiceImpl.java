package com.fractal.domain.employee_management.education;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employee_management.education.accreditation_status.AccreditationStatusService;
import com.fractal.domain.employee_management.education.degree_type.DegreeTypeService;
import com.fractal.domain.employee_management.education.document_type.EducationDocumentTypeService;
import com.fractal.domain.employee_management.education.dto.EducationRequest;
import com.fractal.domain.employee_management.education.dto.EducationResponse;
import com.fractal.domain.employee_management.education.grade_point_average.GradePointAverageService;
import com.fractal.domain.employee_management.education.resource.EducationResourceService;
import com.fractal.domain.employee_management.education.type.EducationTypeService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;
    private final EducationTypeService educationTypeService;
    private final EducationDocumentTypeService educationDocumentTypeService;
    private final DegreeTypeService degreeTypeService;
    private final GradePointAverageService gradePointAverageService;
    private final AccreditationStatusService accreditationStatusService;
    private final EducationResourceService resourceService;

    private final StatusService statusService;
    @Override
    public Education create(EducationRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public EducationResponse toDTO(Education education) {
        return new EducationResponse(
                education.getId(),
                education.getEducationType().getName(),
                education.getEducationDocumentType().getName(),
                education.getBeginDate(),
                education.getEndDate(),
                education.getInstitutionName(),
                education.getInstitutionAddress(),
                education.getIsForeignInstitution(),
                education.getSpecialization(),
                education.getDegreeType().getName(),
                education.getGradePointAverage().getValue(),
                education.getAccreditationStatus().getName(),
                education.getDocumentVerified(),
                education.getVerificationNotes(),
                education.getStatus().getName(),
                Optional.ofNullable(education.getResources())
                        .orElse(emptyList())
                        .stream()
                        .map(resourceService::toDTO)
                        .collect(Collectors.toList()),
                education.getCreatedDate()
        );
    }

    @Override
    public Education toEntity(EducationRequest dto) {
        var education = Education.builder()
                .educationType(educationTypeService.getById(dto.educationTypeId()))
                .educationDocumentType(educationDocumentTypeService.getById(dto.educationDocumentTypeId()))
                .beginDate(dto.beginDate())
                .endDate(dto.endDate())
                .institutionName(dto.institutionName())
                .institutionAddress(dto.institutionAddress())
                .isForeignInstitution(dto.isForeignInstitution())
                .specialization(dto.specialization())
                .degreeType(degreeTypeService.getById(dto.degreeTypeId()))
                .gradePointAverage(gradePointAverageService.getById(dto.gradePointAverageId()))
                .accreditationStatus(accreditationStatusService.getById(dto.accreditationStatusId()))
                .documentVerified(dto.documentVerified())
                .verificationNotes(dto.verificationNotes())
                .status(statusService.getById(dto.statusId()))
                .build();
        dto.files().forEach(file-> education.addResource(resourceService.toEntity(file,null)));
      return education;
    }

    @Override
    public Education update(Long id, EducationRequest dto) {
       var education = findById(id);
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
        dto.files().forEach(file-> education.addResource(resourceService.toEntity(file,null)));
      return education;
    }

    @Override
    public void delete(Education education) {
       educationRepository.delete(education);
    }

    @Override
    public Education addResource(Long id, MultipartFile file, String url) {
        var education = findById(id);
        var resource =resourceService.toEntity(file,url);
        education.addResource(resource);
       return save(education);
    }

    @Override
    public Education updateResource(Long id, Long resourceId, MultipartFile file) {
        var education = findById(id);
        var resource = education.getResources()
                .stream()
                .filter(r -> r.getId().equals(resourceId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education Resource  with id: " + resourceId + " not found"));
        resourceService.update(resource,resourceService.fileToRequest(file,null));
        return save(education);
    }

    @Override
    public Education deleteResource(Long id, Long resourceId) {
        var education = findById(id);
        var resource = education.getResources()
                .stream()
                .filter(r -> r.getId().equals(resourceId)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Education Resource  with id: " + resourceId + " not found"));
        education.removeResource(resource);
        resourceService.delete(resource);
        return save(education);
    }

    private Education save(Education education) {
        try {
            return educationRepository.save(education);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }


    private Education findById(Long id) {
        return educationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Education History with id: " + id + " not found"));
    }
}
