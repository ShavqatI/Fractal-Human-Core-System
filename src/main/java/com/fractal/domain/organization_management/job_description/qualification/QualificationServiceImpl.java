package com.fractal.domain.organization_management.job_description.qualification;

import com.fractal.domain.organization_management.job_description.JobDescriptionService;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationResponse;
import com.fractal.domain.organization_management.job_description.qualification.mapper.QualificationMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class QualificationServiceImpl implements QualificationService {

      private final QualificationRepository qualificationRepository;
      private final QualificationMapperService mapperService;
      private final JobDescriptionService jobDescriptionService;

    @Override
    @Transactional
    public Qualification create(Long jobDescriptionId, QualificationRequest dto) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var qualification = mapperService.toEntity(dto);
        jobDescription.addQualification(qualification);
        jobDescriptionService.save(jobDescription);
        return qualification;
    }

    @Override
    public List<Qualification> getAllByJobDescriptionId(Long jobDescriptionId) {
        return qualificationRepository.findAllByJobDescriptionId(jobDescriptionId);
    }

    @Override
    public Qualification getById(Long jobDescriptionId, Long id) {
        return qualificationRepository.findByJobDescriptionIdAndId(jobDescriptionId,id).orElseThrow(()-> new ResourceNotFoundException("Qualification with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public Qualification update(Long jobDescriptionId, Long id, QualificationRequest dto) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var qualification = jobDescription.getQualifications().stream()
                .filter(q -> q.getId().equals(id))
                .findFirst().orElseThrow(()-> new ResourceNotFoundException("Qualification with id: " + id + " not found"));
        qualification = qualificationRepository.save(mapperService.toEntity(qualification,dto));
        jobDescriptionService.save(jobDescription);
        return qualification;
    }

    @Override
    @Transactional
    public void delete(Long jobDescriptionId, Long id) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var qualification = jobDescription.getQualifications().stream()
                .filter(q -> q.getId().equals(id))
                .findFirst().orElseThrow(()-> new ResourceNotFoundException("Qualification with id: " + id + " not found"));
        jobDescription.removeQualification(qualification);
        qualificationRepository.delete(qualification);
        jobDescriptionService.save(jobDescription);
    }

    @Override
    public QualificationResponse toDTO(Qualification qualification) {
        return mapperService.toDTO(qualification);
    }
}
