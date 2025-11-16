package com.fractal.domain.recruitment.candidate.employment;

import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.external.ExternalEmploymentService;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.employment.mapper.CandidateEmploymentMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateEmploymentServiceImpl implements CandidateEmploymentService {

    private final CandidateEmploymentRepository employmentRepository;
    private final CandidateService candidateService;
    private final ExternalEmploymentService externalEmploymentService;
    private final CandidateEmploymentMapperService employmentMapperService;

    @Override
    @Transactional
    public CandidateEmployment create(Long candidateId, ExternalEmploymentRequest dto) {
        Employment employment = null;
        employment = externalEmploymentService.create(dto);
        var employeeEmployment = CandidateEmployment.builder().employment(employment).build();
        var employee = candidateService.getById(candidateId);
        employee.addEmployment(employeeEmployment);
        candidateService.save(employee);
        return employeeEmployment;
    }

    @Override
    public CandidateEmployment getById(Long candidateId, Long id) {
        return employmentRepository.findByCandidateIdAndId(candidateId, id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }

    @Override
    public List<CandidateEmployment> getAllByCandidateId(Long candidateId) {
        return employmentRepository.findAllByCandidateId(candidateId);
    }


    @Override
    public CandidateEmployment update(Long candidateId, Long id, ExternalEmploymentRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var candidateEmployment = candidate.getEmployments()
                .stream()
                .filter(eh -> eh.getEmployment().getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        externalEmploymentService.update(candidateEmployment.getEmployment().getId(), dto);
        employmentRepository.save(candidateEmployment);
        candidateService.save(candidate);
        return candidateEmployment;
    }


    @Override
    @Transactional
    public void delete(Long candidateId, Long id) {
        var candidate = candidateService.getById(candidateId);
        var candidateEmployment = candidate.getEmployments()
                .stream()
                .filter(employment -> employment.getEmployment().getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        candidate.removeEmployment(candidateEmployment);
        candidateService.save(candidate);
    }

    @Override
    public EmploymentResponse toDTO(CandidateEmployment employment) {
        return employmentMapperService.toDTO(employment);
    }
}
