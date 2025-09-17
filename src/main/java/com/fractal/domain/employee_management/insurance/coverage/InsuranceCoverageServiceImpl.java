package com.fractal.domain.employee_management.insurance.coverage;

import com.fractal.domain.employee_management.insurance.InsuranceService;
import com.fractal.domain.employee_management.insurance.coverage.dto.InsuranceCoverageRequest;
import com.fractal.domain.employee_management.insurance.coverage.dto.InsuranceCoverageResponse;
import com.fractal.domain.employee_management.insurance.coverage.mapper.InsuranceCoverageMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class InsuranceCoverageServiceImpl implements InsuranceCoverageService {

    private final InsuranceCoverageRepository coverageRepository;
    private final InsuranceCoverageMapperService mapperService;
    private final InsuranceService insuranceService;


    @Override
    @Transactional
    public InsuranceCoverage create(Long insuranceId, InsuranceCoverageRequest dto) {
        var insurance = insuranceService.getById(insuranceId);
        var coverage = mapperService.toEntity(dto);
        insurance.addCoverage(coverage);
        insuranceService.save(insurance);
        return coverage;
    }

    @Override
    public List<InsuranceCoverage> getAllByInsuranceId(Long insuranceId) {
        return coverageRepository.findAllByInsuranceId(insuranceId);
    }

    @Override
    public InsuranceCoverage getById(Long insuranceId, Long id) {
        return coverageRepository.findByInsuranceIdAndId(insuranceId,id).orElseThrow(()-> new ResourceNotFoundException("Business Trip Expense with id:" + id + " not found"));
    }

    @Override
    public InsuranceCoverage getById(Long id) {
        return coverageRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("EBusiness Trip Expense with id:" + id + " not found"));
    }

    @Override
    @Transactional
    public InsuranceCoverage update(Long insuranceId, Long id, InsuranceCoverageRequest dto) {
        var insurance = insuranceService.getById(insuranceId);
        var coverage = insurance.getCoverages()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Business Trip Expense with id: " + id + " not found"));
        coverage = mapperService.toEntity(coverage,dto);
        insuranceService.save(insurance);
        return coverage;
    }

    @Override
    @Transactional
    public void delete(Long insuranceId, Long id) {
        var insurance = insuranceService.getById(insuranceId);
        var coverage = insurance.getCoverages()
                .stream()
                .filter(c-> c.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("EBusiness Trip Expense with id: " + id + " not found"));
        insurance.removeCoverage(coverage);
        insuranceService.save(insurance);
    }

    @Override
    public InsuranceCoverageResponse toDTO(InsuranceCoverage coverage) {
        return mapperService.toDTO(coverage);
    }


}
