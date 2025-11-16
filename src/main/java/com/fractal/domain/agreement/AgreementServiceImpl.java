package com.fractal.domain.agreement;

import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;

    @Override
    public Agreement getById(Long id) {
        return agreementRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order with id: " + id + " not found"));
    }

    @Override
    public void save(Agreement agreement) {
        try {
            agreementRepository.save(agreement);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }
}
