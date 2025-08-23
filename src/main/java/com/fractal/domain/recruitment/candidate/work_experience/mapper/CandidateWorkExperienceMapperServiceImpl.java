package com.fractal.domain.recruitment.candidate.work_experience.mapper;

import com.fractal.domain.employment.work_experience.WorkExperience;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;
import com.fractal.domain.employment.work_experience.mapper.WorkExperienceMapperService;
import com.fractal.domain.recruitment.candidate.work_experience.CandidateWorkExperience;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateWorkExperienceMapperServiceImpl implements CandidateWorkExperienceMapperService {

    private final WorkExperienceMapperService mapperService;
    @Override
    public WorkExperienceResponse toDTO(CandidateWorkExperience workExperience) {
        return mapperService.toDTO(workExperience);
    }

    @Override
    public CandidateWorkExperience toEntity(WorkExperienceRequest dto) {
        return convert(new CandidateWorkExperience(),mapperService.toEntity(dto));
    }

    @Override
    public CandidateWorkExperience toEntity(CandidateWorkExperience candidateWorkExperience, WorkExperienceRequest dto) {
        return convert(candidateWorkExperience,mapperService.toEntity(candidateWorkExperience,dto));
    }

    private CandidateWorkExperience convert(CandidateWorkExperience candidateWorkExperience,WorkExperience workExperience) {
        candidateWorkExperience.setCountry(workExperience.getCountry());
        candidateWorkExperience.setLocation(workExperience.getLocation());
        candidateWorkExperience.setEmploymentType(workExperience.getEmploymentType());
        candidateWorkExperience.setStartDate(workExperience.getStartDate());
        candidateWorkExperience.setEndDate(workExperience.getEndDate());
        candidateWorkExperience.setOrganization(workExperience.getOrganization());
        candidateWorkExperience.setDepartment(workExperience.getDepartment());
        candidateWorkExperience.setDivision(workExperience.getDivision());
        candidateWorkExperience.setPosition(workExperience.getPosition());
        candidateWorkExperience.setResponsibilities(workExperience.getResponsibilities());
        candidateWorkExperience.setAchievements(workExperience.getAchievements());
        candidateWorkExperience.setLeaveReason(workExperience.getLeaveReason());
        candidateWorkExperience.setStatus(workExperience.getStatus());
        return candidateWorkExperience;
    }


}
