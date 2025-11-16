package com.fractal.domain.organization_management.grade.method.hay.factor.type;

import com.fractal.domain.organization_management.grade.method.hay.factor.type.dto.HayFactorTypeCompactResponse;
import com.fractal.domain.organization_management.grade.method.hay.factor.type.dto.HayFactorTypeRequest;
import com.fractal.domain.organization_management.grade.method.hay.factor.type.dto.HayFactorTypeResponse;
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
class HayFactorTypeServiceImpl implements HayFactorTypeService {

    private final HayFactorTypeRepository hayFactorTypeRepository;

    @Override
    public HayFactorType create(HayFactorTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<HayFactorType> getAll() {
        return hayFactorTypeRepository.findAll();
    }

    @Override
    public HayFactorType getByCode(String code) {
        return hayFactorTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("HayFactor Type with code: " + code + " not found"));
    }

    @Override
    public HayFactorType getById(Long id) {
        return findById(id);
    }

    @Override
    public HayFactorType update(Long id, HayFactorTypeRequest dto) {
        try {
            HayFactorType hayFactorType = findById(id);
            hayFactorType.setCode(dto.code());
            hayFactorType.setName(dto.name());
            hayFactorType.setDescription(dto.description());
            dto.children().forEach(child -> hayFactorType.addChild(toEntity(child)));
            return save(hayFactorType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        hayFactorTypeRepository.delete(findById(id));
    }

    @Override
    public HayFactorTypeResponse toDTO(HayFactorType hayFactorType) {
        return new HayFactorTypeResponse(
                hayFactorType.getId(),
                hayFactorType.getCode(),
                hayFactorType.getName(),
                hayFactorType.getDescription(),
                Optional.ofNullable(hayFactorType.getChildren())
                        .orElse(emptyList())
                        .stream()
                        .map(this::toDTO)
                        .collect(Collectors.toList()),
                hayFactorType.getCreatedDate()
        );
    }

    @Override
    public HayFactorTypeCompactResponse toCompactDTO(HayFactorType hayFactorType) {
        return new HayFactorTypeCompactResponse(
                hayFactorType.getId(),
                hayFactorType.getCode(),
                hayFactorType.getName()
        );
    }

    @Override
    public HayFactorType addChild(Long id, HayFactorTypeRequest dto) {
        var factorType = findById(id);
        var child = toEntity(dto);
        factorType.addChild(child);
        return save(factorType);
    }

    @Override
    public HayFactorType updateChild(Long id, Long childId, HayFactorTypeRequest dto) {
        var factorType = findById(id);
        var child = factorType.getChildren().stream().filter(ch -> ch.getId().equals(childId)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Child with id: " + childId + " not found"));
        update(child.getId(), dto);
        return save(factorType);
    }

    @Override
    public HayFactorType deleteChild(Long id, Long childId) {
        var factorType = findById(id);
        var child = factorType.getChildren().stream().filter(ch -> ch.getId().equals(childId)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Child with id: " + childId + " not found"));
        factorType.removeChild(child);
        return save(factorType);
    }

    private HayFactorType toEntity(HayFactorTypeRequest dto) {
        var factorType = HayFactorType.builder()
                .code(dto.code())
                .name(dto.name())
                .description(dto.description())
                .build();
        dto.children().forEach(child -> factorType.addChild(toEntity(child)));
        return factorType;

    }

    private HayFactorType save(HayFactorType hayFactorType) {
        try {
            return hayFactorTypeRepository.save(hayFactorType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private HayFactorType findById(Long id) {
        return hayFactorTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("HayFactor Type  with id: " + id + " not found"));
    }
}
