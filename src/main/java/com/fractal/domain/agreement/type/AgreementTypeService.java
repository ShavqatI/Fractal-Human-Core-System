package com.fractal.domain.agreement.type;

import com.fractal.domain.agreement.type.dto.AgreementTypeRequest;
import com.fractal.domain.agreement.type.dto.AgreementTypeResponse;

import java.util.List;

public interface AgreementTypeService {

    AgreementType create(AgreementTypeRequest dto);
    List<AgreementType> getAll();
    AgreementType getByCode(String code);
    AgreementType getById(Long id);
    AgreementType update(Long id, AgreementTypeRequest dto);
    void deleteById(Long id);
    AgreementTypeResponse toDTO(AgreementType agreementType);
}
