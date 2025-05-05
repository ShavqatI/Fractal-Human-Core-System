package com.fractal.domain.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.dto.JobDescriptionRequest;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionResponse;
import com.fractal.domain.organization_management.job_description.qualification.Qualification;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationResponse;
import com.fractal.domain.organization_management.job_description.required_experience.RequiredExperience;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceResponse;
import com.fractal.domain.organization_management.job_description.responsibility.Responsibility;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityResponse;
import com.fractal.domain.organization_management.position.PositionService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class JobDescriptionServiceImpl implements JobDescriptionService {

    private final JobDescriptionRepository jobDescriptionRepository;
    private final PositionService positionService;


    @Override
    public JobDescription create(JobDescriptionRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<JobDescription> getAll() {
        return jobDescriptionRepository.findAll();
    }

    @Override
    public JobDescription getById(Long id) {
        return findById(id);
    }

    @Override
    public JobDescription update(Long id, JobDescriptionRequest dto) {
        try {
            JobDescription jobDescription = findById(id);
            jobDescription.setTitle(dto.title());
            jobDescription.setSummary(dto.summary());
            jobDescription.setEffectiveDate(dto.effectiveDate());
            //jobDescription.setStatus();
            jobDescription.setPosition(positionService.getById(dto.positionId()));
            List<Responsibility> responsibilities = dto.responsibilities().stream()
                    .map(description-> Responsibility.builder().description(description).build())
                    .collect(Collectors.toList());
            jobDescription.setResponsibilities(responsibilities);
           return save(jobDescription);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        jobDescriptionRepository.delete(findById(id));
    }

    @Override
    public JobDescriptionResponse toDTO(JobDescription jobDescription) {
        return new JobDescriptionResponse(
                jobDescription.getId(),
                jobDescription.getTitle(),
                jobDescription.getSummary(),
                jobDescription.getEffectiveDate(),
                jobDescription.getStatus().getName(),
                jobDescription.getPosition().getName(),
                jobDescription.getResponsibilities().stream().map(this::toResponsibilityResponse).collect(Collectors.toList()),
                jobDescription.getQualifications().stream().map(this::toQualificationResponse).collect(Collectors.toList()),
                jobDescription.getRequiredExperiences().stream().map(this::toRequiredExperienceResponse).collect(Collectors.toList()),
                jobDescription.getCreatedDate()
        );
    }

    private ResponsibilityResponse toResponsibilityResponse(Responsibility responsibility) {
        return new ResponsibilityResponse(
                responsibility.getId(),
                responsibility.getDescription(),
                responsibility.getCreatedDate()
        );
    }
    private QualificationResponse toQualificationResponse(Qualification qualification) {
        return new QualificationResponse(
                qualification.getId(),
                qualification.getDescription(),
                qualification.getCreatedDate()
        );
    }
    private RequiredExperienceResponse toRequiredExperienceResponse(RequiredExperience requiredExperience) {
        return new RequiredExperienceResponse(
                requiredExperience.getId(),
                requiredExperience.getDescription(),
                requiredExperience.getRequiredYears(),
                requiredExperience.getDomain(),
                requiredExperience.getLevel(),
                requiredExperience.getStartDate(),
                requiredExperience.getEndDate(),
                requiredExperience.getMandatory(),
                requiredExperience.getNotes(),
                requiredExperience.getCreatedDate()
        );
    }

    private JobDescription toEntity(JobDescriptionRequest dto) {
        JobDescription jobDescription = JobDescription.builder()
                .title(dto.title())
                .summary(dto.summary())
                .effectiveDate(dto.effectiveDate())
                // add status later
                .position(positionService.getById(dto.positionId()))
                .build();

        List<Responsibility> responsibilities = dto.responsibilities().stream()
                                                                      .map(description-> Responsibility.builder().description(description).build())
                                                                      .collect(Collectors.toList());

        /*dto.responsibilities().forEach(
                description -> jobDescription.addResponsibility(Responsibility.builder().description(description).build())
        );*/

        jobDescription.setResponsibilities(responsibilities);

        return jobDescription;

    }

    private JobDescription save(JobDescription jobDescription) {
        try {
            return jobDescriptionRepository.save(jobDescription);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private JobDescription findById(Long id) {
        return jobDescriptionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("JobDescription with id: " + id + " not found"));
    }
}
