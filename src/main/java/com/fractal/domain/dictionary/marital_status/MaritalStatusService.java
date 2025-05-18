package com.fractal.domain.dictionary.marital_status;

import com.fractal.domain.dictionary.marital_status.dto.MaritalStatusRequest;
import com.fractal.domain.dictionary.marital_status.dto.MaritalStatusResponse;

import java.util.List;

public interface MaritalStatusService {

    MaritalStatus create(MaritalStatusRequest dto);
    List<MaritalStatus> getAll();
    MaritalStatus getByCode(String code);
    MaritalStatus getById(Long id);
    MaritalStatus update(Long id, MaritalStatusRequest dto);
    void deleteById(Long id);
    MaritalStatusResponse toDTO(MaritalStatus maritalStatus);
}
