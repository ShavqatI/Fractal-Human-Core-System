package com.fractal.domain.employee_management.insurance;

import com.fractal.domain.employee_management.insurance.dto.InsuranceRequest;
import com.fractal.domain.employee_management.insurance.dto.InsuranceResponse;

import java.util.List;

public interface InsuranceService {

    Insurance create(InsuranceRequest dto);

    List<Insurance> getAllByEmployeeId(Long employeeId);
    List<Insurance> getAll();
    Insurance update(Long id, InsuranceRequest dto);
    void deleteById(Long id);
    Insurance getById(Long id);

    Insurance save(Insurance insurance);
    InsuranceResponse toDTO(Insurance insurance);


}
