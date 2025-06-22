package com.fractal.domain.employee_management.employment.agreement;

import com.fractal.domain.employee_management.employment.EmploymentHistoryService;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementRequest;
import com.fractal.domain.employee_management.employment.agreement.dto.AgreementResponse;
import com.fractal.domain.employee_management.employment.agreement.mapper.AgreementMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;
    private final AgreementMapperService agreementMapperService;
    private final EmploymentHistoryService employmentHistoryService;

    @Override
    @Transactional
    public Agreement create(Long employmentHistoryId, AgreementRequest dto) {
        var employmentHistory = employmentHistoryService.getById(employmentHistoryId);
        var agreement = agreementMapperService.toEntity(dto);
        employmentHistory.addAgreement(agreement);
        employmentHistoryService.save(employmentHistory);
        return agreement;
    }

    @Override
    public List<Agreement> getAllByEmploymentHistoryId(Long employmentHistoryId) {
        return agreementRepository.findAllByEmploymentHistoryId(employmentHistoryId);
    }

    @Override
    public Agreement getById(Long employmentHistoryId, Long id) {
        return agreementRepository.findByEmploymentHistoryIdAndId(employmentHistoryId,id).orElseThrow(()-> new ResourceNotFoundException("Agreement with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public Agreement update(Long employmentHistoryId, Long id, AgreementRequest dto) {
        var employmentHistory = employmentHistoryService.getById(employmentHistoryId);
        var agreement = employmentHistory.getAgreements()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Agreement with id: " + id + " not found"));
        agreement = agreementMapperService.toEntity(agreement,dto);
        agreementRepository.save(agreement);
        employmentHistoryService.save(employmentHistory);
        return agreement;
    }

    @Override
    @Transactional
    public void delete(Long employmentHistoryId, Long id) {
        var employmentHistory = employmentHistoryService.getById(employmentHistoryId);
        var agreement = employmentHistory.getAgreements()
                .stream()
                .filter(a-> a.getId().equals(id)).findFirst().orElseThrow(()-> new ResourceNotFoundException("Agreement with id: " + id + " not found"));
        agreementRepository.delete(agreement);
        employmentHistoryService.save(employmentHistory);
    }

    @Override
    public AgreementResponse toDTO(Agreement agreement) {
        return agreementMapperService.toDTO(agreement);
    }
    @Override
    public Agreement save(Agreement agreement) {
        try {
            return agreementRepository.save(agreement);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public Agreement getById(Long id) {
        return findById(id);
    }

    private Agreement findById(Long id) {
        return agreementRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Agreement with id: " + id + " not found"));
    }
}
