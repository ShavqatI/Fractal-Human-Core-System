package com.fractal.domain.employment.internal.agreement;

import com.fractal.domain.employment.internal.InternalEmploymentService;
import com.fractal.domain.employment.internal.agreement.dto.InternalEmploymentAgreementRequest;
import com.fractal.domain.employment.internal.agreement.dto.InternalEmploymentAgreementResponse;
import com.fractal.domain.employment.internal.agreement.mapper.InternalEmploymentAgreementMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class InternalEmploymentAgreementServiceImpl implements InternalEmploymentAgreementService {

    private final InternalEmploymentAgreementRepository internalEmploymentAgreementRepository;
    private final InternalEmploymentAgreementMapperService internalEmploymentAgreementMapperService;
    private final InternalEmploymentService employmentService;

    @Override
    @Transactional
    public InternalEmploymentAgreement create(Long employmentId, InternalEmploymentAgreementRequest dto) {
        var employment = employmentService.getById(employmentId);
        var agreement = internalEmploymentAgreementMapperService.toEntity(dto);
        employment.addAgreement(agreement);
        employmentService.save(employment);
        return agreement;
    }

    @Override
    public List<InternalEmploymentAgreement> getAllByInternalEmploymentId(Long employmentId) {
        return internalEmploymentAgreementRepository.findAllByInternalEmploymentId(employmentId);
    }

    @Override
    public InternalEmploymentAgreement getById(Long employmentId, Long id) {
        return internalEmploymentAgreementRepository.findByInternalEmploymentIdAndId(employmentId, id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }

    @Override
    @Transactional
    public InternalEmploymentAgreement update(Long employmentId, Long id, InternalEmploymentAgreementRequest dto) {
        var employment = employmentService.getById(employmentId);
        var agreement = employment.getAgreements()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        agreement = internalEmploymentAgreementMapperService.toEntity(agreement, dto);
        internalEmploymentAgreementRepository.save(agreement);
        employmentService.save(employment);
        return agreement;
    }

    @Override
    @Transactional
    public void delete(Long employmentId, Long id) {
        var employment = employmentService.getById(employmentId);
        var agreement = employment.getAgreements()
                .stream()
                .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        employment.removeAgreement(agreement);
        employmentService.save(employment);
    }

    @Override
    public InternalEmploymentAgreementResponse toDTO(InternalEmploymentAgreement agreement) {
        return internalEmploymentAgreementMapperService.toDTO(agreement);
    }

    @Override
    public InternalEmploymentAgreement save(InternalEmploymentAgreement agreement) {
        try {
            return internalEmploymentAgreementRepository.save(agreement);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public InternalEmploymentAgreement getById(Long id) {
        return findById(id);
    }

    private InternalEmploymentAgreement findById(Long id) {
        return internalEmploymentAgreementRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }
}
