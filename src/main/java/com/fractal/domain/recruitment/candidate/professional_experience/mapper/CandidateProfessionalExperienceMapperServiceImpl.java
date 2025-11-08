package com.fractal.domain.recruitment.candidate.professional_experience.mapper;

import com.fractal.domain.dictionary.industry.IndustryService;
import com.fractal.domain.recruitment.candidate.professional_experience.CandidateProfessionalExperience;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceRequest;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateProfessionalExperienceMapperServiceImpl implements CandidateProfessionalExperienceMapperService {

    private final IndustryService industryService;

    @Override
    public CandidateProfessionalExperienceResponse toDTO(CandidateProfessionalExperience professionalExperience) {
        return new CandidateProfessionalExperienceResponse(
                professionalExperience.getId(),
                industryService.toDTO(professionalExperience.getIndustry()),
                professionalExperience.getYears(),
                professionalExperience.getCreatedDate()
        );
    }

    @Override
    public CandidateProfessionalExperience toEntity(CandidateProfessionalExperienceRequest dto) {
        return mapToEntity(new CandidateProfessionalExperience(), dto);
    }


    @Override
    public CandidateProfessionalExperience toEntity(CandidateProfessionalExperience professionalExperience, CandidateProfessionalExperienceRequest dto) {
        return mapToEntity(professionalExperience, dto);
    }

    private CandidateProfessionalExperience mapToEntity(CandidateProfessionalExperience professionalExperience, CandidateProfessionalExperienceRequest dto) {
        professionalExperience.setIndustry(industryService.getById(dto.industryId()));
        professionalExperience.setYears(dto.years());
        return professionalExperience;

    }


}
