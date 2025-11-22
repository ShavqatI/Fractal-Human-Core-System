package com.fractal.domain.vacation_management.vacation.allocation;

import com.fractal.domain.vacation_management.vacation.allocation.dto.VacationAllocationRequest;
import com.fractal.domain.vacation_management.vacation.allocation.dto.VacationAllocationResponse;

import java.util.List;

public interface VacationAllocationService {

    VacationAllocation create(Long vacationRequestId, VacationAllocationRequest dto);

    List<VacationAllocation> getAllByVacationRequestId(Long vacationRequestId);

    VacationAllocation getById(Long vacationRequestId, Long id);

    VacationAllocation update(Long vacationRequestId, Long id, VacationAllocationRequest dto);

    void delete(Long vacationRequestId, Long id);

    VacationAllocationResponse toDTO(VacationAllocation vacationAllocation);

}
