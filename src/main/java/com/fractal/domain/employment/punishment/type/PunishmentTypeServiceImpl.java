package com.fractal.domain.employment.punishment.type;

import com.fractal.domain.employment.punishment.type.dto.PunishmentTypeCompactResponse;
import com.fractal.domain.employment.punishment.type.dto.PunishmentTypeRequest;
import com.fractal.domain.employment.punishment.type.dto.PunishmentTypeResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class PunishmentTypeServiceImpl implements PunishmentTypeService {

    private final PunishmentTypeRepository employmentTypeRepository;

    @Override
    public PunishmentType create(PunishmentTypeRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<PunishmentType> getAll() {
        return employmentTypeRepository.findAll();
    }

    @Override
    public PunishmentType getByCode(String code) {
        return employmentTypeRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Employment Type with code: " + code + " not found"));
    }

    @Override
    public PunishmentType getById(Long id) {
        return findById(id);
    }

    @Override
    public PunishmentType update(Long id, PunishmentTypeRequest dto) {
        try {
            PunishmentType punishmentType = findById(id);
            punishmentType.setCode(dto.code());
            punishmentType.setName(dto.name());
            punishmentType.setDuration(dto.duration());
            return save(punishmentType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        employmentTypeRepository.delete(findById(id));
    }

    @Override
    public PunishmentTypeResponse toDTO(PunishmentType punishmentType) {
        return new PunishmentTypeResponse(
                punishmentType.getId(),
                punishmentType.getCode(),
                punishmentType.getName(),
                punishmentType.getDuration(),
                punishmentType.getCreatedDate()
        );
    }

    @Override
    public PunishmentTypeCompactResponse toCompactDTO(PunishmentType punishmentType) {
        return new PunishmentTypeCompactResponse(
                punishmentType.getId(),
                punishmentType.getCode(),
                punishmentType.getName()

        );
    }

    private PunishmentType toEntity(PunishmentTypeRequest dto) {
        return PunishmentType.builder()
                .code(dto.code())
                .name(dto.name())
                .duration(dto.duration())
                .build();
    }

    private PunishmentType save(PunishmentType punishmentType) {
        try {
            return employmentTypeRepository.save(punishmentType);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private PunishmentType findById(Long id) {
        return employmentTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employment Type with id: " + id + " not found"));
    }

}
