package com.fractal.domain.profile.candidate.employment;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.recruitment.candidate.education.CandidateEducation;
import com.fractal.domain.recruitment.candidate.employment.CandidateEmployment;
import com.fractal.domain.recruitment.candidate.employment.CandidateEmploymentService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateProfileEmploymentServiceImpl implements CandidateProfileEmploymentService {

   private final CandidateEmploymentService employmentService;
   private final AuthenticatedService authenticatedService;


    @Override
    public CandidateEmployment create(ExternalEmploymentRequest dto) {
        return employmentService.create(authenticatedService.getCandidateId(), dto);
    }

    @Override
    public CandidateEmployment getById(Long id) {
        return findById(id);
    }

    @Override
    public List<CandidateEmployment> getAll() {
        return employmentService.getAllByCandidateId(authenticatedService.getCandidateId());
    }

    @Override
    public CandidateEmployment update(Long id, ExternalEmploymentRequest dto) {
        return employmentService.update(authenticatedService.getCandidateId(),findById(id).getId(), dto);
    }

    @Override
    public void delete(Long id) {
      employmentService.delete(authenticatedService.getCandidateId(),findById(id).getId());
    }

    @Override
    public EmploymentResponse toDTO(CandidateEmployment employment) {
        return employmentService.toDTO(employment);
    }

    private CandidateEmployment findById(Long id) {
        return employmentService.getAllByCandidateId(authenticatedService.getCandidateId()).stream()
                .filter(employment -> employment.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}
