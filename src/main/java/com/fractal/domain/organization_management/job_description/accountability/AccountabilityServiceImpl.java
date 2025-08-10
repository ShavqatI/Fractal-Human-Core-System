package com.fractal.domain.organization_management.job_description.accountability;

import com.fractal.domain.organization_management.job_description.JobDescription;
import com.fractal.domain.organization_management.job_description.JobDescriptionService;
import com.fractal.domain.organization_management.job_description.accountability.dto.AccountabilityRequest;
import com.fractal.domain.organization_management.job_description.accountability.dto.AccountabilityResponse;
import com.fractal.domain.organization_management.job_description.accountability.mapper.AccountabilityMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class AccountabilityServiceImpl implements AccountabilityService {

      private final AccountabilityRepository accountabilityRepository;
      private final AccountabilityMapperService mapperService;
      private final JobDescriptionService jobDescriptionService;

    @Override
    @Transactional
    public Accountability create(Long jobDescriptionId, AccountabilityRequest dto) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var accountability = mapperService.toEntity(dto);
        jobDescription.addAccountability(accountability);
        jobDescriptionService.save(jobDescription);
        return accountability;
    }

    @Override
    public List<Accountability> getAllByJobDescriptionId(Long jobDescriptionId) {
        return accountabilityRepository.findAllByJobDescriptionId(jobDescriptionId);
    }

    @Override
    public Accountability getById(Long jobDescriptionId, Long id) {
        return accountabilityRepository.findByJobDescriptionIdAndId(jobDescriptionId,id).orElseThrow(()-> new ResourceNotFoundException("Accountability with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public Accountability update(Long jobDescriptionId, Long id, AccountabilityRequest dto) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var accountability = findById(jobDescription,id);
        accountability = accountabilityRepository.save(mapperService.toEntity(accountability,dto));
        jobDescriptionService.save(jobDescription);
        return accountability;
    }

    @Override
    @Transactional
    public void delete(Long jobDescriptionId, Long id) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var accountability = findById(jobDescription,id);
        jobDescription.removeAccountability(accountability);
        accountabilityRepository.delete(accountability);
        jobDescriptionService.save(jobDescription);
    }

    @Override
    public AccountabilityResponse toDTO(Accountability accountability) {
        return mapperService.toDTO(accountability);
    }

    private Accountability findById(JobDescription jobDescription, Long id) {
        return jobDescription.getAccountabilities().stream()
                .filter(q -> q.getId().equals(id))
                .findFirst().orElseThrow(()-> new ResourceNotFoundException("Accountability with id: " + id + " not found"));
    }
}
