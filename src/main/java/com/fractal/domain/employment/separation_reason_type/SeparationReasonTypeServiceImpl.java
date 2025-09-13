package com.fractal.domain.employment.separation_reason_type;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.employment.separation_reason_type.dto.SeparationReasonTypeCompactResponse;
import com.fractal.domain.employment.separation_reason_type.dto.SeparationReasonTypeRequest;
import com.fractal.domain.employment.separation_reason_type.dto.SeparationReasonTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;


@Service
@RequiredArgsConstructor
class SeparationReasonTypeServiceImpl implements SeparationReasonTypeService {

    private final SeparationReasonTypeRepository separationReasonTypeRepository;
    private final StatusService statusService;


    @Override
    public SeparationReasonType create(SeparationReasonTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<SeparationReasonType> getAll() {
        return separationReasonTypeRepository.findAll();
    }

    @Override
    public SeparationReasonType getByCode(String code) {
        return separationReasonTypeRepository.findByCode(code).orElseThrow(()-> new ResourceNotFoundException("Separation Reason with code: " + code + " not found"));
    }

    @Override
    public SeparationReasonType getById(Long id) {
        return findById(id);
    }

    @Override
    public SeparationReasonType update(Long id, SeparationReasonTypeRequest dto) {
        try {
            SeparationReasonType separationReasonType = findById(id);
            separationReasonType.setCode(dto.code());
            separationReasonType.setName(dto.name());
            dto.children().forEach(separationReasonTypeRequest -> separationReasonType.addChild(toEntity(separationReasonTypeRequest)));
            return save(separationReasonType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
      separationReasonTypeRepository.delete(findById(id));
    }

    @Override
    public SeparationReasonTypeResponse toDTO(SeparationReasonType separationReasonType) {
        return new SeparationReasonTypeResponse(
                separationReasonType.getId(),
                separationReasonType.getCode(),
                separationReasonType.getName(),
                Optional.ofNullable(separationReasonType.getParent())
                        .map(SeparationReasonType::getName)
                        .orElse(null),
                Optional.ofNullable(separationReasonType.getChildren())
                        .orElse(emptyList())
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList()),
                 statusService.toCompactDTO(separationReasonType.getStatus()),
                separationReasonType.getCreatedDate()
        );
    }

   @Override
    public SeparationReasonTypeCompactResponse toCompactDTO(SeparationReasonType separationReasonType) {
        return new SeparationReasonTypeCompactResponse(
                separationReasonType.getId(),
                separationReasonType.getCode(),
                separationReasonType.getName()
        );
    }

    private SeparationReasonType toEntity(SeparationReasonTypeRequest dto) {
        var separationReason = SeparationReasonType.builder()
                .code(dto.code())
                .name(dto.name())
                .build();
        dto.children().forEach(separationReasonTypeRequest -> separationReason.addChild(toEntity(separationReasonTypeRequest)));
    return separationReason;
    }

    private SeparationReasonType save(SeparationReasonType separationReasonType) {
        try {
            return separationReasonTypeRepository.save(separationReasonType);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private SeparationReasonType findById(Long id) {
        return separationReasonTypeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Separation Reason with id: " + id + " not found"));
    }
}
