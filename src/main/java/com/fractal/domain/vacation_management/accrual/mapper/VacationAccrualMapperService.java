package com.fractal.domain.vacation_management.accrual.mapper;

import com.fractal.domain.vacation_management.accrual.VacationAccrual;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualRequest;
import com.fractal.domain.vacation_management.accrual.dto.VacationAccrualResponse;

public interface VacationAccrualMapperService {
    VacationAccrualResponse toDTO(VacationAccrual accrual);
    VacationAccrual toEntity(VacationAccrualRequest dto);
    VacationAccrual toEntity(VacationAccrual accrual, VacationAccrualRequest dto);
}


