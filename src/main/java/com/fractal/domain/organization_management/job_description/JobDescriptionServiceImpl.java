package com.fractal.domain.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.dto.JobDescriptionRequest;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionResponse;
import com.fractal.domain.organization_management.job_description.mapper.JobDescriptionMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class JobDescriptionServiceImpl implements JobDescriptionService {

    private final JobDescriptionRepository jobDescriptionRepository;
    private final JobDescriptionMapperService mapperService;
    @Override
    @Transactional
    public JobDescription create(JobDescriptionRequest dto) {
        return save(mapperService.toEntity(dto));
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
    @Transactional
    public JobDescription update(Long id, JobDescriptionRequest dto) {
        try {
            JobDescription jobDescription = mapperService.toEntity(findById(id),dto);
            return save(jobDescription);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        jobDescriptionRepository.delete(findById(id));
    }

    @Override
    public JobDescriptionResponse toDTO(JobDescription jobDescription) {
        return mapperService.toDTO(jobDescription);
    }

    @Override
    public JobDescription save(JobDescription jobDescription) {
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
