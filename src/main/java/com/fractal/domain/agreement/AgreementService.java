package com.fractal.domain.agreement;

public interface AgreementService {
    Agreement getById(Long id);
    void save(Agreement agreement);

}
