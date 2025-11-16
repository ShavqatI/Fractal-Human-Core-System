package com.fractal.domain.vacation_management.accrual;

import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualRequest;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualResponse;

import java.util.List;

public interface VacationAccrualService {
    VacationAccrual create(VacationAccrualRequest dto);

    List<VacationAccrual> getAll();

    VacationAccrual getById(Long id);

    List<VacationAccrual> getAllByEmployeeId(Long employeeId);

    VacationAccrual update(Long id, VacationAccrualRequest dto);

    void deleteById(Long id);

    VacationAccrualResponse toDTO(VacationAccrual vacationAccrual);

    VacationAccrual save(VacationAccrual vacationAccrual);

    void calculate();

}
