package com.fractal.domain.recruitment.candidate.education.mapper;

import com.fractal.domain.education.Education;
import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.education.mapper.EducationMapperService;
import com.fractal.domain.recruitment.candidate.education.CandidateEducation;
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
        return convert(new CandidateEducation(), educationMapperService.toEntity(dto));
    }

    @Override
    public CandidateEducation toEntity(CandidateEducation education, EducationRequest dto) {
        return convert(education, educationMapperService.toEntity(education, dto));
    }

    private CandidateEducation convert(CandidateEducation candidateEducation, Education education) {
        candidateEducation.setEducationType(education.getEducationType());
        candidateEducation.setEducationDocumentType(education.getEducationDocumentType());
        candidateEducation.setBeginDate(education.getBeginDate());
        candidateEducation.setEndDate(education.getEndDate());
        candidateEducation.setInstitutionName(education.getInstitutionName());
        candidateEducation.setInstitutionAddress(education.getInstitutionAddress());
        candidateEducation.setIsForeignInstitution(education.getIsForeignInstitution());
        candidateEducation.setSpecialization(education.getSpecialization());
        candidateEducation.setDegreeType(education.getDegreeType());
        candidateEducation.setGradePointAverage(education.getGradePointAverage());
        candidateEducation.setAccreditationStatus(education.getAccreditationStatus());
        candidateEducation.setDocumentVerified(education.getDocumentVerified());
        candidateEducation.setVerificationNotes(education.getVerificationNotes());
        candidateEducation.setStatus(education.getStatus());
        candidateEducation.setResources(education.getResources());
        return candidateEducation;
    }

}
