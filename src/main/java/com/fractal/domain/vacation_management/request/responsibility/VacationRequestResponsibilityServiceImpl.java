package com.fractal.domain.vacation_management.request.responsibility;

import com.fractal.domain.vacation_management.request.VacationRequestService;
import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityRequest;
import com.fractal.domain.vacation_management.request.responsibility.dto.VacationRequestResponsibilityResponse;
import com.fractal.domain.vacation_management.request.responsibility.mapper.VacationRequestResponsibilityMapperService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacationRequestResponsibilityServiceImpl implements VacationRequestResponsibilityService {

    private final VacationRequestResponsibilityRepository responsibilityRepository;
    private final VacationRequestResponsibilityMapperService responsibilityMapperService;
    private final VacationRequestService vacationRequestService;


    @Override
    @Transactional
    public VacationRequestResponsibility create(Long vacationRequestId, VacationRequestResponsibilityRequest dto) {
        var request = vacationRequestService.getById(vacationRequestId);
        var responsibility = responsibilityMapperService.toEntity(dto);
        request.addResponsibility(responsibility);
        vacationRequestService.save(request);
        return responsibility;
    }

    @Override
    public List<VacationRequestResponsibility> getAllByVacationRequestId(Long vacationRequestId) {
        return responsibilityRepository.findAllByVacationRequestId(vacationRequestId);
    }

    @Override
    public VacationRequestResponsibility getById(Long vacationRequestId, Long id) {
        return responsibilityRepository.findByVacationRequestIdAndId(vacationRequestId, id).orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
    }

    @Override
    @Transactional
    public VacationRequestResponsibility update(Long vacationRequestId, Long id, VacationRequestResponsibilityRequest dto) {
        var request = vacationRequestService.getById(vacationRequestId);
        var responsibility = request.getResponsibilities()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        responsibility = responsibilityRepository.save(responsibilityMapperService.toEntity(responsibility, dto));
        vacationRequestService.save(request);
        return responsibility;
    }

    @Override
    @Transactional
    public void delete(Long vacationRequestId, Long id) {
        var request = vacationRequestService.getById(vacationRequestId);
        var responsibility = request.getResponsibilities()
                .stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Employee contact with id: " + id + " not found"));
        request.removeResponsibility(responsibility);
        vacationRequestService.save(request);
    }

    @Override
    public VacationRequestResponsibilityResponse toDTO(VacationRequestResponsibility order) {
        return responsibilityMapperService.toDTO(order);
    }


}
