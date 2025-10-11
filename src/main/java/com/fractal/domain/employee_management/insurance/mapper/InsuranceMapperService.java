package com.fractal.domain.employee_management.insurance.mapper;

import com.fractal.domain.employee_management.insurance.Insurance;
import com.fractal.domain.employee_management.insurance.dto.InsuranceRequest;
import com.fractal.domain.employee_management.insurance.dto.InsuranceResponse;

public interface InsuranceMapperService {
    InsuranceResponse toDTO(Insurance insurance);
    Insurance toEntity(InsuranceRequest dto);
    Insurance toEntity(Insurance insurance, InsuranceRequest dto);
}


