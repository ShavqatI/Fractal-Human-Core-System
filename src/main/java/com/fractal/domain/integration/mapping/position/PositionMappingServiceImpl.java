package com.fractal.domain.integration.mapping.position;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.integration.mapping.position.dto.PositionMappingRequest;
import com.fractal.domain.integration.mapping.position.dto.PositionMappingResponse;
import com.fractal.domain.organization_management.position.PositionService;
import com.fractal.exception.ResourceNotFoundException;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
class PositionMappingServiceImpl implements PositionMappingService {

    private final PositionMappingRepository positionMappingRepository;
    private final PositionService positionService;
    private final StatusService statusService;

    @Override
    public PositionMapping create(PositionMappingRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<PositionMapping> getAll() {
        return positionMappingRepository.findAll();
    }

    @Override
    public PositionMapping getById(Long id) {
        return findById(id);
    }

    @Override
    public PositionMapping update(Long id, PositionMappingRequest dto) {
        try {
            PositionMapping positionMapping = findById(id);
            positionMapping.setPosition(positionService.getById(dto.positionId()));
            positionMapping.setReferenceType(dto.referenceType());
            positionMapping.setReference(dto.reference());
            positionMapping.setStatus(statusService.getById(dto.statusId()));
            return save(positionMapping);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        positionMappingRepository.delete(findById(id));
    }

    @Override
    public PositionMappingResponse toDTO(PositionMapping positionMapping) {
        return new PositionMappingResponse(
                positionMapping.getId(),
                positionService.toCompactDTO(positionMapping.getPosition()),
                positionMapping.getReferenceType(),
                positionMapping.getReference(),
                statusService.toCompactDTO(positionMapping.getStatus()),
                positionMapping.getCreatedDate()
        );
    }

    private PositionMapping toEntity(PositionMappingRequest dto) {
        return PositionMapping.builder()
                .position(positionService.getById(dto.positionId()))
                .referenceType(dto.referenceType())
                .reference(dto.reference())
                .status(statusService.getById(dto.statusId()))
                .build();
    }

    private PositionMapping save(PositionMapping positionMapping) {
        try {
            return positionMappingRepository.save(positionMapping);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private PositionMapping findById(Long id) {
        return positionMappingRepository.findById(id).orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}
