package com.fractal.domain.organization_management.job_description.authority;

import com.fractal.domain.organization_management.job_description.JobDescriptionService;
import com.fractal.domain.organization_management.job_description.authority.dto.AuthorityRequest;
import com.fractal.domain.organization_management.job_description.authority.dto.AuthorityResponse;
import com.fractal.domain.organization_management.job_description.authority.mapper.AuthorityMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class AuthorityServiceImpl implements AuthorityService {

      private final AuthorityRepository authorityRepository;
      private final AuthorityMapperService mapperService;
      private final JobDescriptionService jobDescriptionService;

    @Override
    @Transactional
    public Authority create(Long jobDescriptionId, AuthorityRequest dto) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var authority = mapperService.toEntity(dto);
        jobDescription.addAuthority(authority);
        jobDescriptionService.save(jobDescription);
        return authority;
    }

    @Override
    public List<Authority> getAllByJobDescriptionId(Long jobDescriptionId) {
        return authorityRepository.findAllByJobDescriptionId(jobDescriptionId);
    }

    @Override
    public Authority getById(Long jobDescriptionId, Long id) {
        return authorityRepository.findByJobDescriptionIdAndId(jobDescriptionId,id).orElseThrow(()-> new ResourceNotFoundException("Authority with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public Authority update(Long jobDescriptionId, Long id, AuthorityRequest dto) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var authority = jobDescription.getAuthorities().stream()
                .filter(q -> q.getId().equals(id))
                .findFirst().orElseThrow(()-> new ResourceNotFoundException("Authority with id: " + id + " not found"));
        authority = authorityRepository.save(mapperService.toEntity(authority,dto));
        jobDescriptionService.save(jobDescription);
        return authority;
    }

    @Override
    @Transactional
    public void delete(Long jobDescriptionId, Long id) {
        var jobDescription = jobDescriptionService.getById(jobDescriptionId);
        var authority = jobDescription.getAuthorities().stream()
                .filter(q -> q.getId().equals(id))
                .findFirst().orElseThrow(()-> new ResourceNotFoundException("Authority with id: " + id + " not found"));
        jobDescription.removeAuthority(authority);
        jobDescriptionService.save(jobDescription);
    }

    @Override
    public AuthorityResponse toDTO(Authority authority) {
        return mapperService.toDTO(authority);
    }
}
