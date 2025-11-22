package com.fractal.domain.vacation_management.vacation.allocation.mapper;

import com.fractal.domain.vacation_management.accrual.period.record.VacationAccrualPeriodRecordService;
import com.fractal.domain.vacation_management.vacation.allocation.VacationAllocation;
import com.fractal.domain.vacation_management.vacation.allocation.dto.VacationAllocationRequest;
import com.fractal.domain.vacation_management.vacation.allocation.dto.VacationAllocationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class VacationAllocationMapperServiceImpl implements VacationAllocationMapperService {


    private final VacationAccrualPeriodRecordService accrualPeriodRecordService;
    @Override
    public VacationAllocationResponse toDTO(VacationAllocation allocation) {
        return new VacationAllocationResponse(
                allocation.getId(),
                accrualPeriodRecordService.toDTO(allocation.getVacationAccrualPeriodRecord()),
                allocation.getDays(),
                allocation.getCreatedDate()

        );
    }

    @Override
    public VacationAllocation toEntity(VacationAllocationRequest dto) {
        return mapToEntity(new VacationAllocation(), dto);
    }

    @Override
    public VacationAllocation toEntity(VacationAllocation allocation, VacationAllocationRequest dto) {
        return mapToEntity(allocation, dto);
    }

    private VacationAllocation mapToEntity(VacationAllocation allocation, VacationAllocationRequest dto) {
        allocation.setVacationAccrualPeriodRecord(accrualPeriodRecordService.getById(dto.accrualPeriodRecordId()));
        allocation.setDays(dto.days());
        return allocation;
    }

}
