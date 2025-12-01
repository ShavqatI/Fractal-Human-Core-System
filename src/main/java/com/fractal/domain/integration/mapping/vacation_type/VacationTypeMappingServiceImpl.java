package com.fractal.domain.integration.mapping.vacation_type;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.integration.mapping.vacation_type.dto.VacationTypeMappingRequest;
import com.fractal.domain.integration.mapping.vacation_type.dto.VacationTypeMappingResponse;
import com.fractal.domain.vacation_management.type.VacationTypeService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class VacationTypeMappingServiceImpl implements VacationTypeMappingService {

    private final VacationTypeMappingRepository vacationTypeMappingRepository;
    private final VacationTypeService vacationTypeService;
    private final StatusService statusService;

    @Override
    public VacationTypeMapping create(VacationTypeMappingRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<VacationTypeMapping> getAll() {
        return vacationTypeMappingRepository.findAll();
    }

    @Override
    public VacationTypeMapping getById(Long id) {
        return findById(id);
    }

    @Override
    public VacationTypeMapping update(Long id, VacationTypeMappingRequest dto) {
        try {
            VacationTypeMapping vacationTypeMapping = findById(id);
            vacationTypeMapping.setVacationType(vacationTypeService.getById(dto.vacationTypeId()));
            vacationTypeMapping.setReferenceType(dto.referenceType());
            vacationTypeMapping.setReference(dto.reference());
            vacationTypeMapping.setStatus(statusService.getById(dto.statusId()));
            return save(vacationTypeMapping);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        vacationTypeMappingRepository.delete(findById(id));
    }

    @Override
    public VacationTypeMappingResponse toDTO(VacationTypeMapping vacationTypeMapping) {
        return new VacationTypeMappingResponse(
                vacationTypeMapping.getId(),
                vacationTypeService.toDTO(vacationTypeMapping.getVacationType()),
                vacationTypeMapping.getReferenceType(),
                vacationTypeMapping.getReference(),
                statusService.toCompactDTO(vacationTypeMapping.getStatus()),
                vacationTypeMapping.getCreatedDate()
        );
    }

    private VacationTypeMapping toEntity(VacationTypeMappingRequest dto) {
        return VacationTypeMapping.builder()
                .vacationType(vacationTypeService.getById(dto.vacationTypeId()))
                .referenceType(dto.referenceType())
                .reference(dto.reference())
                .status(statusService.getById(dto.statusId()))
                .build();
    }

    private VacationTypeMapping save(VacationTypeMapping vacationTypeMapping) {
        try {
            return vacationTypeMappingRepository.save(vacationTypeMapping);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private VacationTypeMapping findById(Long id) {
        return vacationTypeMappingRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }
}
