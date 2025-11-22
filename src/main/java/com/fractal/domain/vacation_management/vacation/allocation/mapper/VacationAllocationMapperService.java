package com.fractal.domain.vacation_management.vacation.allocation.mapper;

import com.fractal.domain.vacation_management.vacation.allocation.VacationAllocation;
import com.fractal.domain.vacation_management.vacation.allocation.dto.VacationAllocationRequest;
import com.fractal.domain.vacation_management.vacation.allocation.dto.VacationAllocationResponse;

public interface VacationAllocationMapperService {
    VacationAllocationResponse toDTO(VacationAllocation allocation);

    VacationAllocation toEntity(VacationAllocationRequest dto);

    VacationAllocation toEntity(VacationAllocation allocation, VacationAllocationRequest dto);
}


