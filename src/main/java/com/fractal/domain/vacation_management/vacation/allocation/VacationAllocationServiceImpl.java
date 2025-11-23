package com.fractal.domain.vacation_management.vacation.allocation;

import com.fractal.domain.vacation_management.vacation.VacationService;
import com.fractal.domain.vacation_management.vacation.allocation.dto.VacationAllocationRequest;
import com.fractal.domain.vacation_management.vacation.allocation.dto.VacationAllocationResponse;
import com.fractal.domain.vacation_management.vacation.allocation.mapper.VacationAllocationMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacationAllocationServiceImpl implements VacationAllocationService {

    private final VacationAllocationRepository allocationRepository;
    private final VacationAllocationMapperService mapperService;
    private final VacationService vacationService;


    @Override
    @Transactional
    public VacationAllocation create(Long vacationRequestId, VacationAllocationRequest dto) {
        var vacation = vacationService.getById(vacationRequestId);
        var allocation = mapperService.toEntity(dto);
        vacation.addAllocation(allocation);
        vacationService.save(vacation);
        return allocation;
    }

    @Override
    public List<VacationAllocation> getAllByVacationRequestId(Long vacationRequestId) {
        return allocationRepository.findAllByVacationId(vacationRequestId);
    }

    @Override
    public VacationAllocation getById(Long vacationRequestId, Long id) {
        return allocationRepository.findByVacationIdAndId(vacationRequestId, id).orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public VacationAllocation update(Long vacationRequestId, Long id, VacationAllocationRequest dto) {
        var vacation = vacationService.getById(vacationRequestId);
        var allocation = vacation.getAllocations()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        allocation = allocationRepository.save(mapperService.toEntity(allocation, dto));
        vacationService.save(vacation);
        return allocation;
    }

    @Override
    @Transactional
    public void delete(Long vacationRequestId, Long id) {
        var request = vacationService.getById(vacationRequestId);
        var allocation = request.getAllocations()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        request.removeResponsibility(allocation);
        vacationService.save(request);
    }

    @Override
    public VacationAllocationResponse toDTO(VacationAllocation order) {
        return mapperService.toDTO(order);
    }


}
